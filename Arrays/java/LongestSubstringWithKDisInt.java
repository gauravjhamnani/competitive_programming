class LongestSubstringWithKDisInt {
    
    // https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853
    
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        if (k < 1 || n < 1) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, size = 0, maxLength = -1;
        while (r < n) {
            char rChar = s.charAt(r);
            if (map.containsKey(rChar)) {
                int freq = map.get(rChar);
                map.put(rChar, ++freq);
                r++;
            } else {
                if (size < k) {
                    map.put(rChar, 1);
                    size++;
                    r++;
                } else {
                    maxLength = Math.max(maxLength, r - l);
                    char lChar = s.charAt(l);
                    int freq = map.get(lChar);
                    if (freq == 1) {
                        map.remove(lChar);
                        size--;
                    } else {
                        map.put(lChar, --freq);
                    }
                    l++;
                }
            }
        }
        if (size == k)
        maxLength = Math.max(maxLength, r - l);
        return maxLength;
    }
}
