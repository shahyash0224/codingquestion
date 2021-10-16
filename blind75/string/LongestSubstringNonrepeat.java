package blind75.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNonrepeat {
    public static int longStrLen(String sourceStr) {
        if (sourceStr.length() == 0)
            return 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < sourceStr.length(); i++) {
            if (charMap.containsKey(sourceStr.charAt(i)))
                j = Math.max(j, charMap.get(sourceStr.charAt(i)) + 1);
            charMap.put(sourceStr.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sourceStr = br.readLine().split("\n")[0];
        System.out.println(longStrLen(sourceStr));
        br.close();
    }
}
