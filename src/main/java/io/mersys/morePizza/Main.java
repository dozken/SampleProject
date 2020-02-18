package io.mersys.morePizza;


import io.mersys.morePizza.service.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Main {

    public static void main(String[] args) {
        final Service service = new Service();

        try {
            Path inputPath = Paths.get("src", "main", "resources","morePizza", "in");
            Path outputPath = Paths.get("src", "main", "resources","morePizza", "out");

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
