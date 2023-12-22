import java.util.Collection;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return List.copyOf(groupAnagramsProper(strs));
    }

    private static Collection<List<String>> groupAnagramsProper(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(Solution::sortString))
                .values();
    }

    private static String sortString(String str) {
        return str.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}