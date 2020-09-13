package com.maliarenko.mykyta;

import java.io.*;

public class CSVParser {

    private String inputDelimiter = ",";
    private String outputDelimiter = "+";

    public CSVParser() {}

    public CSVParser(String inputDelimiter, String outputDelimiter) {
        this.inputDelimiter = inputDelimiter;
        this.outputDelimiter = outputDelimiter;
    }

    public void parseFile(String inputFilePath, String outputFilePath) {
        BufferedReader reader;
        BufferedWriter writer;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line = reader.readLine();
            while (line != null) {
                writer.write(this.parseString(line) + "\n");
                writer.flush();
                line = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String parseString(String input) {
        String inputCopy = input;
        StringBuilder result = new StringBuilder();

        while (true) {
            // We reached last value in this line
            if (!hasMoreValues(inputCopy)) {
                result.append(String.format("%d", inputCopy.length()));
                break;
            }

            String block;
            int endIndex;
            if (inputCopy.charAt(0) == '"') {
                endIndex = inputCopy.indexOf('"', 1) + 1;
                if (endIndex == 0)
                    throw new IllegalArgumentException("no closing \"");

                block = inputCopy.substring(1, endIndex - 1);
            } else {
                endIndex = inputCopy.indexOf(',');
                block = inputCopy.substring(0, endIndex);
            }

            result.append(String.format("%d%s", block.length(), outputDelimiter));
            inputCopy = inputCopy.substring(endIndex + 1);
        }

        return result.toString();
    }

    private boolean hasMoreValues(String input) {
        return input.contains(",") || input.charAt(0) == '"';
    }

    public String getInputDelimiter() {
        return inputDelimiter;
    }

    public String getOutputDelimiter() {
        return outputDelimiter;
    }

    public void setInputDelimiter(String inputDelimiter) {
        this.inputDelimiter = inputDelimiter;
    }

    public void setOutputDelimiter(String outputDelimiter) {
        this.outputDelimiter = outputDelimiter;
    }
}
