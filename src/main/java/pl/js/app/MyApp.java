package pl.js.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class MyApp {

    public static void main(String[] args) {

        try {
            printCount(readString(args[0]));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No application argument!");
        }

    }

    private static HashMap<Character, Integer> readString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        return map;
    }

    private static void printCount(HashMap<Character, Integer> map) {
        TreeMap<Character, Integer> sortedMap = new TreeMap<>(map);
        Iterator<Character> iterator = sortedMap.keySet().iterator();
        System.out.println("Counted letters:");
        while(iterator.hasNext()) {
            char key = iterator.next();
            System.out.println(key + " = " + map.get(key));
        }
    }

}
