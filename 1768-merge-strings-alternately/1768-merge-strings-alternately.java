class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p =0,q=0;
        int m = word1.length();
        int n = word2.length();
        StringBuilder ans = new StringBuilder();
        while(p<m && q<n)
        {
            ans.append(word1.charAt(p++));
            ans.append(word2.charAt(q++));
        }
        while(p<m)
        ans.append(word1.charAt(p++));
        while(q<n)
        ans.append(word2.charAt(q++));
        return ans.toString();
    }
}