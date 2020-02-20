package io.mersys.qualification.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Service {

    //TODO change return type
    public Object process(){
        return null;
    }

    public void readInputFile(Path path) {
        //TODO read input file and assign constraints
        try (BufferedReader br = Files.newBufferedReader(path)) {
            Integer.parseInt(br.readLine());
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
