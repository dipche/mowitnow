package fr.xebia.test;

import org.junit.After;
import org.junit.Before;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Grégory SOH on 05/09/2016.
 */
public class LectureCommandesTest {


    BufferedReader reader;



    @Before
    public void init() throws Exception {
        URL url = this.getClass().getResource("/commands.txt");
        Path path = Paths.get(url.toURI());
        reader = Files.newBufferedReader(path, Charset.defaultCharset());

    }




    @After
    public void fin() throws Exception {

        reader.close();
    }
}
