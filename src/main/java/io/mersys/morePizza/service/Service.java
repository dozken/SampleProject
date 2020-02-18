package io.mersys.morePizza.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class Service {

    int maxSlices;
    int[] slices;

    public Object doStuff() {
        //printing
        System.out.printf("%d %d\n", maxSlices, slices.length);
        System.out.println(Arrays.toString(slices));
        //end printing



        return null;

    }

    public void readInputFile(Path path) {
        //TODO read input file and assign constraints
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String[] settings = br.readLine().split(" ");
            this.maxSlices = Integer.parseInt(settings[0]);
            int typeCount = Integer.parseInt(settings[1]);

            this.slices = new int[typeCount];
            for (int i = 0; i < typeCount; i++) {
                int numericValue = Character.getNumericValue(br.read());
                this.slices[i] = numericValue;
                br.skip(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeOutputFile(Path path, Object obj) {
        //TODO write obj to output file
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.format("%d", 1));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
