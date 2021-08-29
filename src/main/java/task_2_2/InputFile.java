package task_2_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFile {

    private String fileName;
    private List<String> fileLines;
    private List<String> words;

    public List<String> getFileLines() {
        return fileLines;
    }

    public void setFileLines(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public InputFile(String fileName) {
        this.fileName = fileName;
        readFileToSupplier();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        readFileToSupplier();
    }

    public void readFileToSupplier() {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current absolute path is: " + s);

        String fullPath = s + fileName;

        collectToFileLines(fullPath);
        collectToWords(fullPath);


    }

    private void collectToFileLines(String fullPath) {

        try (Stream<String> lines = Files.lines(Paths.get(fullPath))) {

            fileLines = lines.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void collectToWords(String fullPath) {

        try (Stream<String> lines = Files.lines(Paths.get(fullPath))) {

            words = lines.map(x -> x.split(" ")).flatMap(Arrays::stream).
                    map(x -> x.replaceAll("\\pP", "")).
                    map(String::toLowerCase).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
