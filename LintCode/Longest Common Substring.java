���ֵ���⣬�����������У�����ÿ��Ԫ��˳���ܵ��� =>Two Sequence DP

        ������Longest Common Subsequence�ǳ����ƣ���ͬ������Ҫ�󹫹������б���������
        ��ԭ�л����Ͻ�����΢���޸ļ��ɡ�
        State:
        ����������Ҫ�޸�f[i][j]����ʾ��״̬���塣
        �ܵ�Longest Incresing Subsequence���������������Ӧ�ý�f[i][j]����Ϊ��
        �ַ���A��ǰi���ַ����Ե�i���ַ���β�� �� �ַ���B��ǰj���ַ����Ե�j���ַ���β������������г��ȡ�
        Function:
        ��Ϊ�������Ե�i/j���ַ�Ϊ��β��LCS���ʵ��������ַ����ʱ��f[i][j]=f[i-1][j-1]+1
        �����ʱ��Ϊ0
        Answer:
        ��������� Math.max(f[0...n][0...m])

/*
Given two strings, find the longest common substring.

Return the length of it.

Example
Given A = "ABCD", B = "CBCE", return 2.

Note
The characters in substring should occur continuously in original string. This is different with subsequence.

Challenge
O(n x m) time and memory.

Tags Expand 
LintCode Copyright Longest Common Subsequence Dynamic Programming

Thoughts:
1. Compare all i X j.
2. Use a D[i][j] to mark the amount of common substring based on D[i - 1][j -1]. Could be 0.
3. track max length

NOTE: create 2D array that's [N + 1][M + 1] because we want to hold D[n][M] in the 2d array

*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        // State
        int[][] f = new int[A.length() + 1][B.length() + 1];
        int max = 0;

        // Initialize ��Ϊint�����ʼ����Ϊ0�����ڹ�������ʱ��Java�Ѿ�Ĭ�ϰ����������

        // Function
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
                max = Math.max(f[i][j], max);
            }
        }

        // Answer
        return max;
    }
}