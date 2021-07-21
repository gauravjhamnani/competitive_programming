class Solution {

    // https://leetcode.com/problems/longest-substring-without-repeating-characters

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLength = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            if (map.containsKey(s.charAt(r))) {
                maxLength = Math.max(r - l, maxLength);
                map.remove(s.charAt(l));
                l++;
            } else {
                map.put(s.charAt(r), 1);
                r++;
            }
        }
        maxLength = Math.max(r - l, maxLength);
        return maxLength;
    }
}
