Binary Search 
提示：时间复杂度要求为O(logN)

/*There is an integer array which has the following features:

    * The numbers in adjacent positions are different.

    * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].

We define a position P is a peek if A[P] > A[P-1] && A[P] > A[P+1].

Find a peak in this array. Return the index of the peak.

Note
The array may contains multiple peeks, find any of them.

Example
[1, 2, 1, 3, 4, 5, 7, 6]

return index 1 (which is number 2)  or 6 (which is number 7)

Challenge
Time complexity O(logN)

Tags Expand 
Binary Search Array LintCode Copyright

Thinking Process:
画图
想象股票涨跌，以Binary Search Templete为基础对各个条件判断后进行处理
`/		 peak				\				\/
/				/\			   \
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int start = 1;
        int end = A.length - 1; 
        if (A[0] > A[1]) {
		return 0;
	}
	if (A[end - 1] > A[end - 2]) {
		return end - 1;
	}
        
        while(start < end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}
