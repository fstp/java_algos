import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String str = "this is a test. this is only a test. testing, one, two, three.";
        String processedStr = str.replaceAll("\\s",""); // remove all spaces and tabs (not counted in substrings)
        String substr = findMostFrequentOccurringSubstring(processedStr, 3);
        System.out.println("Most frequent occurring substring: " + substr);
    }

    private static String findMostFrequentOccurringSubstring(String str, int minSubstringLen) {
        Map<String, Integer> substrCountMap = new HashMap<>();
        int length = str.length();
        int maxCount = 0;
        String maxOccurringSubstr = null;

        for (int i = 0; i < length; i++) {
            for (int j = i + minSubstringLen; j <= length; j++) {
                String substr = str.substring(i, j);

                // Update count in the map.
                int count = substrCountMap.getOrDefault(substr, 0);
                substrCountMap.put(substr, count + 1);

                // check if current substring has the max count
                if (count + 1 > maxCount) {
                    maxCount = count + 1;
                    maxOccurringSubstr = substr;
                }
            }
        }
        return maxOccurringSubstr;
    }
}
