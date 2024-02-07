class Solution {
    public String frequencySort(String s) {
	HashMap<Character, Integer> cnt = new HashMap<>();
	for (char c : s.toCharArray()) {
		cnt.put(c, cnt.getOrDefault(c, 0) + 1);
	}
	
	List<Character> chars = new ArrayList(cnt.keySet());
	Collections.sort(chars, (a, b) -> (cnt.get(b) - cnt.get(a)));

	StringBuilder sb = new StringBuilder();
	for (Object c : chars) {
		for (int i = 0; i < cnt.get(c); i++) {
			sb.append(c);
		}
	}
	return sb.toString();
}
}