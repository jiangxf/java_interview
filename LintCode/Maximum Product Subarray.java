DP ���⡣

        State:
        max[i]:��ʾǰi�������������������֮��
        min[i]:��ʾǰi��������С����������֮��
        Function:
        ����Ϊ�漰�����������⡣������Ҫ�ֿ����ۣ�
        �� nums[i] ������ʱ��max[i]=Math.max(max[i],max[i-1]*nums[i]);
        min[i]=Math.min(min[i],min[i-1]*nums[i]);
        �� nums[i] �Ǹ���ʱ��max[i]=Math.max(max[i],min[i-1]*nums[i-1]);
        min[i]=Math.min(min[i],max[i-1]*nums[i-1]);
        Intitialize:
        max[0]=min[0]=1;
        rst=nums[0];

        ����ͨ���۲����Ƿ��֣������ DP �У���ǰ״̬����ֻ����һ��״̬�йأ�������״̬û�й�ϵ��
        ��������ֻ��Ҫ��һ��������������һ��״̬���ɡ�
        �������Ǳ���԰� O(N) �Ķ���ռ��Ż��� O(1) �Ķ���ռ䡣

        Note��
        ���������� Max �� Min ʱ�ǳ�ֵ�����ӵ�һ�����⣡����
        �ر������漰�� �˷� �� ����ֵ ����ʱ����������������ʮ����Ҫ�Ľ�ɫ������
        �������ͬ�Ļ��У� �ϳ��� �����Ŀ��Ҳ��һ�������к��� ���� �� DP ���⡣
        https://github.com/cherryljr/NowCoder/blob/master/%E5%90%88%E5%94%B1%E5%9B%A2.java
	
/*
Description
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags 
Subarray LinkedIn Dynamic Programming
*/

// Solution 1: O(N) Space Complexity
public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] max = new int[len + 1];
        int[] min = new int[len + 1];
        int rst = nums[0];
        max[0] = min[0] = 1;

        for (int i = 1; i <= len; i++) {
            max[i] = min[i] = nums[i - 1];
            if (nums[i - 1] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i - 1]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i - 1]);
            } else if (nums[i - 1] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i - 1]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i - 1]);
            }

            rst = Math.max(rst, max[i]);
        }

        return rst;
    }
}

// Solution 2: O(1) Space Complexity (Opitimized)
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // State & Initialize 
        int minPre = nums[0], maxPre = nums[0];
        int max = nums[0], min = nums[0];
        int res = nums[0];

        // Function
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
            min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
            res = Math.max(res, max);
            maxPre = max;
            minPre = min;
        }

        // Answer
        return res;
    }
}