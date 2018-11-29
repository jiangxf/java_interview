Treu or False, ������ַ���˳�򲻿ɵ� =>Two Sequnce DP
        ������Ȼ����������������s3ʵ�����ǲ���ı�ģ����Ի���һ��Two Sequence DP
        State:
        f[i][j]: ��ʾs1��ǰi���ַ���s2��ǰj���ַ��ܷ����s3��ǰi+j���ַ�
        Initialize:
        s3ȫ��s1���
        f[i][0]=true // �� s1.charAt(i - 1) == s3.charAt(i - 1) && result[i - 1][0] ����ʱ
        s3ȫ��s2���
        f[0][j]=true // �� s2.charAt(j - 1) == s3.charAt(j - 1) && result[0][j - 1] ����ʱ
        Function:
        s1�ĵ�i���ַ���s3�ĵ�i+j���ַ���ȣ�����f[i-1][j]Ϊtrueʱ=>f[i][j]=true
        s2�ĵ�j���ַ���s3�ĵ�i+j���ַ���ȣ�����f[i][j-1]Ϊtrueʱ=>f[i][j]=true
        Answer:
        f[s1.length()][s2.length()]
	
/*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
Challenge
O(n2) time or better

Tags Expand 
Longest Common Subsequence Dynamic Programming

Attempt: 
DP[i][j]: boolean that if first S1(i) chars and first S2(j) chars can interleavign first S3(i + j)
Match one char by one char. We have 2 conditions: match s1 or s2 char, Let's do double-for-loop on s1 and s2
1. match s1: s3.charAt(i + j -1) == s1.charAt(i - 1) && DP[i - 1][j]; // makes sure DP[i-1][j] also works before adding s1[i-1] onto the match list
2. match s2: s3.charAt(i + j -1) == s2.charAt(j - 1) && DP[i][j - 1]// similar as above

Note:
DP ususally start i == 1, and always use (i - 1) in the loop... 
this is all because we are trying to get DP[i][j], which are 1 index more than length
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     *
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // State 
        boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];

        // Initialize
        result[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && result[i - 1][0]) {
                result[i][0] = true;
            }
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && result[0][j - 1]) {
                result[0][j] = true;
            }
        }

        // Funciton
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && result[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && result[i][j - 1])) {
                    result[i][j] = true;
                }
            }
        }

        // Answer
        return result[s1.length()][s2.length()];
    }
}