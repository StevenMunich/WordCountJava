import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class WordTypeCount {
    public static void main(String[] args){
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap);
        displayMap(myMap);

    }

    public static void createMap(Map<String, Integer> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = scanner.nextLine();

        String[] tokens = input.split(" "); //splits each word

        for(String token: tokens){
            String word = token.toLowerCase();

            if(map.containsKey(word)){ //if map contains word increment
                int count = map.get(word); //gets current count
                count++;
                map.put(word, count); //writes back to map with incremented count
            }
            else {
                map.put(word, 1);
            }
        }//end ForLoop
    }//end CreateMap

    public static void displayMap(Map<String, Integer> map){
        Set<String> keys = map.keySet(); //get keys

        TreeSet<String> sortedKeys = new TreeSet<>(keys); //sorts the keys

        System.out.printf("%nMap contains:%nKey\t\tValues%n");

        for(String key: sortedKeys)
            System.out.printf("%-10s%10s%n", key, map.get(key));

        System.out.printf("%nSize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }

} //End Class
