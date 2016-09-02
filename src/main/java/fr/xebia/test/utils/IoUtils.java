package fr.xebia.test.utils;



import org.apache.log4j.Logger;

import java.io.*;


/**
 * Created by Grégory SOH on 31/08/2016.
 */
public class IoUtils {
        private final static Logger LOG = Logger.getLogger(IoUtils.class.getName());



        public static BufferedReader lectureFichier(final String fileName) throws IOException {

            if (fileName == null || fileName.length() == 0) {
                throw new IllegalArgumentException("Error at IOUtil::lectureFichier. Fichier en entree inexistant!");
            }
            return new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        }

        public static OutputStream ecrireFichier(OutputStream oups, final String message) throws IOException {
            oups.write(message.getBytes());
            oups.write('\n');
            return oups;
        }


        public static void closeInputStream(final BufferedReader in) throws IOException {
            try {
                in.close();
            }
            catch (IOException e) {
                LOG.error("Exception in IOUtil::closeInputStream" + e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }
