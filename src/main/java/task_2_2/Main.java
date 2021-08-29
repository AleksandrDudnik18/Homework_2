package task_2_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Comparator<String> COMPARATOR = Comparator.comparing(String::length).
            thenComparing(String::compareTo);


    public static void main(String[] args) {

        InputFile inputFile = new InputFile("/src/main/resources/test.txt");
        List<String> fileLines = inputFile.getFileLines();
        List<String> words = inputFile.getWords();


        System.out.println("choose home task (1-6) or '0' for exit");
        int chooseAction = inputValue();
        switch (chooseAction) {
            case 0: {
                System.out.println("exit");
                break;
            }
            case 1: {
                System.out.println("different words in the text: " + words.size());
                break;
            }
            case 2: {

                words.stream().distinct().sorted(COMPARATOR).forEach(System.out::println);

//                    words.stream().distinct().sorted((str1, str2) ->
//                    {
//                        Integer lengthStr1 = str1.length();
//                        Integer lengthStr2 = str2.length();
//
//                        if (!lengthStr1.equals(lengthStr2)) {
//                            return lengthStr1 - lengthStr2;
//                        }
//
//                        if (!str1.equals(str2)) {
//                            return str1.compareTo(str2);
//                        }
//
//                        return 0;
//                    }).forEach(System.out::println);

                break;
            }
            case 3: {

                Map<String, Integer> hashMap = new HashMap<String, Integer>();

                for (int i = 0; i < words.size(); i++) {

                    if (!hashMap.containsKey(words.get(i))) {
                        hashMap.put(words.get(i), 1);
                    } else {
                        hashMap.put(words.get(i), hashMap.get(words.get(i)) + 1);
                    }
                }

                printMap(hashMap);

                break;
            }

            case 4: {

                for (int i = fileLines.size() - 1; i >= 0; i--) {
                    System.out.println(fileLines.get(i));
                }


                break;
            }

            case 5: {

                List<String> list = fileLines.stream().map(x -> x.split(" ")).flatMap(Arrays::stream).
                        collect(Collectors.toList());

                for (String str : new Reverse<String>(list)) {
                    System.out.println(str);
                }

                break;
            }

            case 6: {

                System.out.println("input number string of file from '1' to '" + fileLines.size() + "' or press '0' to exit: ");

                List<Integer> listOfNumberString = new ArrayList<>();

                while (true) {

                    int numberOfString = inputValue();

                    if (numberOfString == 0) {
                        break;
                    } else if (numberOfString < 1 || numberOfString > fileLines.size()) {
                        System.out.println("wrong number of string");
                        System.out.println("input next number or press '0' to exit: ");
                        continue;
                    }

                    listOfNumberString.add(numberOfString - 1);
                    System.out.println("input next number or press '0' to exit: ");
                }

                listOfNumberString.forEach(el -> System.out.println("number string: '" + (el + 1) + "', is: " + fileLines.get(el)));
            }
            break;

            default: {

                System.out.println("choose wrong action");

                break;
            }

        }


    }

    protected static void printMap(Map<String, Integer> hashMap) {

        hashMap.forEach((key, value) -> System.out.println("word: '" + key + "' meets: "
                + value));

    }

    private static int inputValue() {

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }


}
