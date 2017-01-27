package main.java;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by Ruben on 27-01-2017.
 */
public class TestRunner {

    public static void main(String[] args) {
        StringBuilder respond = new StringBuilder();

        respond.append("{\"testResults\":[" + "\n");
        respond.append(runTest("test A:", 5, 6, 11));
        respond.append(",\n");
        respond.append(runTest("test B:", 5, 6, 11));
        respond.append(",\n");
        respond.append(runTest("test C:", 5, 6, 15));
        respond.append("\n]}");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("testResults.json"))) {
            writer.write(respond.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private String runTest(String test, int a, int b, int res){
        StringBuilder sb = new StringBuilder();
        boolean passed = false;
        Instant start = Instant.now();
        try {
            ChallengeReply challenge = new ChallengeReply();
            int testRes = challenge.Sum(a, b);
            passed = res == testRes;
        }
        catch(Throwable err) {
            // make sure we would not fail due to bad code
        }
        Instant end = Instant.now();
        sb.append("{");
        sb.append("\"title\":\"" + test + "\",");
        sb.append("\"passed\":" + passed + ",");
        sb.append("\"time\":\"" + Duration.between(start, end) + "\"");
        sb.append("}");
        return sb.toString();
    }
}
