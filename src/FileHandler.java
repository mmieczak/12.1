import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileHandler {

    public static Map<String, Integer> readUniqueFromFile(String fileName) throws FileNotFoundException {

        Map<String, Integer> integerMap = new TreeMap<>();
        int linesNumber = 0;

        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            linesNumber++;
            try {
                int number = scan.nextInt();
                String keyValue = number + " - occurence number: ";
                //integerMap = addKeyAndValueToMap(keyValue, integerMap); //redundant integerMap, how to do this more elegant?
                addKeyAndValueToMap(keyValue, integerMap);    //the same effect, not elegant using argument that is modified
            } catch (InputMismatchException ex) {
                System.err.println("Wrong data format in line " + linesNumber + ": " + scan.next());
            }

        }
        scan.close();
        return integerMap;
    }

    private static Map<String, Integer> addKeyAndValueToMap(String key, Map<String, Integer> integerMap) {
        if (integerMap.containsKey(key)) {
            int value = integerMap.get(key) + 1;
            integerMap.put(key, value);
        } else {
            integerMap.put(key, 1);
        }
        return integerMap;
    }
}


