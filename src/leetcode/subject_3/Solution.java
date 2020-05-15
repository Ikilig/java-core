package leetcode.subject_3;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbb"));
        System.out.println(solution.lengthOfLongestSubstring2("bbbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> substr = new HashSet<>();
            int j = i;
            while (j < s.length() && !substr.contains(s.charAt(j))) {
                substr.add(s.charAt(j));
                j++;
            }
            max = max < substr.size() ? substr.size() : max;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int max = 0;
        int rk = -1;
        HashSet<Character> substr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                substr.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !substr.contains(s.charAt(rk + 1))) {
                substr.add(s.charAt(rk+1));
                rk++;
            }
            max = max < rk + 1 - i ? rk + 1 - i : max;
        }
        return max;
    }
}
