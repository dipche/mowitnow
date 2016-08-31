package fr.xebia.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Grégory SOH on 31/08/2016.
 */
public class IoUtils {
        private final static Logger LOG = LoggerFactory.getLogger(IoUtils.class.getName());

        public static InputStream createStreamFromFile(final String fileName) {
            if (fileName == null || fileName.length() == 0) {
                throw new IllegalArgumentException("Error at IOUtil::createStreamFromFile. file name is null or empty!");
            }
            final InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            return in;
        }

        public static Properties loadPropertiesFromFile(final String filename) {
            final ClassLoader cl = Thread.currentThread().getContextClassLoader();
            final Properties props = new Properties();
            InputStream in = null;
            try {
                in = cl.getResourceAsStream(filename);
                props.load(in);
                return props;
            }
            catch (NullPointerException ex) {
                LOG.error("Excpetion in IOUtil::loadPropertiesFromFile(String filename). Could not find properties fileError: " + ex.getMessage(), ex);
                //throw new LoadFileException("Error at IoUtils::loadPropertiesFromFile(String filename) due to " + ex.getMessage(), ex);
            }
            catch (IOException ex2) {
                LOG.error("Excpetion in IOUtil::loadPropertiesFromFile(String filename). Could not find properties fileError: " + ex2.getMessage(), ex2);
                //throw new LoadFileException("Error at IoUtils::loadPropertiesFromFile(String filename) due to " + ex2.getMessage(), ex2);
            }
            finally {
                if (in != null) {
                    closeInputStream(in);
                }
            }
            return props;
        }

        public static void closeInputStream(final InputStream in) {
            try {
                in.close();
            }
            catch (IOException e) {
                LOG.error("Exception in IOUtil::closeInputStream" + e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }
