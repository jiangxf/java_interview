����ⷨ�ο���
        http://blog.csdn.net/fightforyourdream/article/details/17346385?reload#comments
        Ҫ�����˼·��������������ڽ��������

        State:
        f[i][j]��ʾ��S��ǰi���ַ���ɵ����е���������T��ǰj���ַ���ɵ����г��ֵĸ���
        Initialize:
        f[0][0]=1; // T��S���ǿմ�.
        f[1 ...S.length()-1][0]=1; // T�ǿմ���Sֻ��һ��������ƥ�䡣
        f[0][1 ...T.length()-1]=0; // S�ǿմ���T���ǿմ���Sû��������ƥ�䡣
        Function:
        f[i][j]=f[i-1][j]
        f[i][j]=f[i-1][j]+f[i-1][j-1]   //  S[i - 1] == T[j - 1]
        ��Χ��1<=i<=S.length(),1<=j<=T.length()
        Answer:
        f[S.length()][T.length()]
	
/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
Given S = "rabbbit", T = "rabbit", return 3.

Challenge
Do it in O(n2) time and O(n) memory.

O(n2) memory is also acceptable if you do not know how to optimize memory.

Tags Expand 
String Dynamic Programming
*/

public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        // State
        int[][] nums = new int[S.length() + 1][T.length() + 1];

        // Initialize
        for (int i = 0; i <= S.length(); i++) {
            nums[i][0] = 1;
        }

        // Function
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }

        // Answer
        return nums[S.length()][T.length()];
    }
}