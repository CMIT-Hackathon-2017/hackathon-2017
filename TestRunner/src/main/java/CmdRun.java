package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Path;

/**
 * Created by play on 27-01-2017.
 */
public class CmdRun {
    private static final String CMD = "/temp/javac/execTest.cmd";
    private static final String WORKING_LIRBRARY = "/temp/javac";
    public static void Test() {

        try {
            // Run "netsh" Windows command
            Process process = Runtime.getRuntime().exec(CMD, null, new File(WORKING_LIRBRARY));

            // Get input streams
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
