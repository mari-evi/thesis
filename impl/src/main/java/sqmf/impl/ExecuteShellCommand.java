/*
 * Copyright © 2017 M.E Xezonaki in the context of her MSc Thesis,
 * Department of Informatics and Telecommunications, UoA.
 * All rights reserved.
 */
package sqmf.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The class containing the necessary methods to execute a shell command in Java.
 *
 */
public class ExecuteShellCommand {

    /**
     * The method which executes a shell command from the Java code.
     *
     * @param command       The command to be executed.
     * @return              The command execution's output.
     */
    public String executeCommand(String command) {

        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return output.toString();

    }




    /**
     * Alternative method which executes a shell command from the Java code.
     *
     * @param command       The command to be executed.
     * @return              The command execution's output.
     */
    public String executeCommand(String[] command) {

        StringBuilder output = new StringBuilder();

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.inheritIO();
            builder.redirectOutput(ProcessBuilder.Redirect.PIPE);

            Process p = builder.start();

            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                String line = "";
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
            }

            p.waitFor();

        } catch (IOException | InterruptedException e) {
            // Process failed;  do not attempt to continue!
            throw new RuntimeException(e);
        }

        return output.toString();
    }

}
