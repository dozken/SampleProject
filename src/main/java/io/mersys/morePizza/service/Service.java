package io.mersys.morePizza.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class Service {

    int maxSlices;
    int[] slices;


    public List<Integer> doStuff() {
        List<Integer> positions = new ArrayList<>();
        //printing
        System.out.printf("%d %d\n", maxSlices, slices.length);
        System.out.println(Arrays.toString(slices));
        //end printing

        int complement = maxSlices;

        int max = 0;
        for (int i = slices.length - 1; i >= 0; i--) {
            int candidate = complement - slices[i];
            if (candidate < 0) {
                continue;
            }
            complement = candidate;
            max += slices[i];
            if(max > maxSlices)
                break;

            positions.add(i);

        }

        System.out.println("Max slices: " + max);
        Collections.reverse(positions);
        return positions;

    }

    public void readInputFile(Path path) {
        //TODO read input file and assign constraints
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String[] settings = br.readLine().split(" ");
            this.maxSlices = Integer.parseInt(settings[0]);
            int typeCount = Integer.parseInt(settings[1]);

            this.slices = new int[typeCount];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                this.slices[i] = Integer.parseInt(str[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeOutputFile(Path path, List<Integer> obj) {
        //TODO write obj to output file
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.format("%d", obj.size()));
            writer.newLine();

            for (Integer i : obj) {
                writer.write(String.format("%d ", i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
