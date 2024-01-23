class Solution{
public int mostWordsFound(String[] sentences) {
    return 1 + Stream.of(sentences).mapToInt(s -> (int)s.chars().filter(ch -> ch == ' ').count()).max().getAsInt();
}}