���ⱳ�����Ⲣ���Ǻ����ԣ�û������Ͷ�����
        ������С״̬���״̬�������Ǳ���Ҫ��֪��f[i-1][j]����֪��f[i][j],���뵽ʹ�ö�̬�滮�ķ���

        State:
        f[i][j] ��ʾ��ǰi�������е������ѵ�i��������Ϊj����С�����Ƕ���
        Function:
        f[i][j]=Math.min(f[i][j],f[i-1][j]+Math.abs(A[i]-k))
        Intialize:
        ������Ҫȡ������Сֵ�����Ƚ��������е�ֵ��ʼ��Ϊ�����
        Ȼ���ٽ�f[0][i]=0,��Ϊ����ǰ0������������ô���������۶���0
        Answer:
        Math.min(f[A.size()][0.. .100])

/*

Description
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Notice
You can assume each number in the array is a positive integer and not greater than 100.

Have you met this question in a real interview? Yes

Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
Return 2.

Tags 
Backpack LintCode Copyright Dynamic Programming

*/

public class Solution {
    /**
     * @param A:      An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }

        // State
        int[][] f = new int[A.size() + 1][101];

        // Initialize
        for (int i = 0; i <= A.size(); i++) {
            for (int j = 0; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j <= 100; j++) {
            f[0][j] = 0;
        }

        // Function
        for (int i = 1; i <= A.size(); i++) {
            for (int j = 0; j <= 100; j++) {
                if (f[i - 1][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k <= 100; k++) {
                        if (Math.abs(j - k) <= target) {
                            f[i][k] = Math.min(f[i][k],
                                    f[i - 1][j] + Math.abs(A.get(i - 1) - k));
                        }
                    }
                }
            }
        }

        // Answer
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; ++i)
            if (f[A.size()][i] < ans)
                ans = f[A.size()][i];
        return ans;
    }
}