package io.mersys.morePizza;


import io.mersys.morePizza.service.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

class Main {

    public static void main(String[] args) {
        final Service service = new Service();
        int a [] = new int[1000000000];

        try {
            Path inputPath = Paths.get("src", "main", "resources","morePizza", "in");
            Path outputPath = Paths.get("src", "main", "resources","morePizza", "out");

            Files.newDirectoryStream(inputPath,
                    path -> path.toString().endsWith(".txt"))
                    .forEach(path -> {
                        Instant start = Instant.now();
                        service.readInputFile(path);
                        Instant finish = Instant.now();
                        long timeElapsed = Duration.between(start, finish).toMillis();
                        System.out.printf("read %s takes %d\n",path.getFileName(), timeElapsed);


                        start = Instant.now();
                        List<Integer> obj = service.doStuffYeldar();
                        finish = Instant.now();
                        timeElapsed = Duration.between(start, finish).toMillis();
                        System.out.printf("process %s takes %d\n",path.getFileName(), timeElapsed);


                        start = Instant.now();
                        service.writeOutputFile(outputPath.resolve(path.getFileName()), obj);
                        finish = Instant.now();
                        timeElapsed = Duration.between(start, finish).toMillis();
                        System.out.printf("write %s takes %d\n\n",path.getFileName(), timeElapsed);
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
