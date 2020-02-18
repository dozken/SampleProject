package io.mersys;


import io.mersys.service.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Main {

    public static void main(String[] args) {
        final Service service = new Service();

        try {
            Path inputPath = Paths.get("src", "main", "resources", "in");
            Path outputPath = Paths.get("src", "main", "resources", "out");

            Files.newDirectoryStream(inputPath,
                    path -> path.toString().endsWith(".txt"))
                    .forEach(path -> {
                        service.readInputFile(path);
                        Object slideshow = service.doStuff();
                        service.writeOutputFile(outputPath.resolve(path.getFileName()), slideshow);
                        System.out.println();
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
