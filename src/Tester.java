import java.io.FileNotFoundException;
import java.util.*;

public class Tester {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String,Integer> collection;
        collection = FileHandler.readUniqueFromFile("inputFile.txt");

        Set<String> keys = collection.keySet();

        for (String key : keys) {
            System.out.println(key + collection.get(key));
        }
    }
}
