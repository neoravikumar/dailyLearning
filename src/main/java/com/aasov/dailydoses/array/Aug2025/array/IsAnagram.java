package com.aasov.dailydoses.array.Aug2025.array;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {
        //boolean result = isAnagram("anagram","nagaram");
        //boolean result = checkAnagram("anagram", "nagaram");
        boolean result2 = checkAnagram2("anagram", "nagaramooo");

        System.out.println(result2);
    }

    // Brute force approach
    public static boolean isAnagram(String s, String t) {
        char[] sInput = s.toCharArray();
        char[] tInput = t.toCharArray();
        int slength = s.length();
        int tlength = t.length();

        if (slength != tlength) {
            return false;
        }
        for (int i = 0; i < slength; i++) {
            boolean isFound = false;
            for (int k = 0; k < tlength; k++) {
                if (sInput[i] == tInput[k]) {
                    isFound = true;
                    tInput[k] = '0';
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        return true;

    }

    // using HashMap
    public static boolean checkAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] sInput = s.toCharArray();
        char[] tInput = t.toCharArray();
        int slength = s.length();
        int tlength = t.length();

        for (char a : s.toCharArray()) {
            if (charMap.containsKey(a)) {
                int value = charMap.get(a);
                charMap.put(a, ++value);
            } else {
                charMap.put(a, 1);
            }

        }
        for (char f : t.toCharArray()) {
            if (charMap.containsKey(f) && charMap.get(f) > 0) {
                int value = charMap.get(f);
                if (value >= 1) {
                    charMap.put(f, --value);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAnagram2(String s, String t) {
        // prepare a frequency Map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i) )+ 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int k = 0; k < t.length(); k++) {
            if (map.containsKey(t.charAt(k)) && map.get(t.charAt(k)) > 0) {
                int value = map.get(t.charAt(k));
                if (value >= 1) {
                    map.put(t.charAt(k), --value);
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
