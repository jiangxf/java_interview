��һ��ӦΪ������Ȼ���ѯ���ɡ����ǽ������������Ҫ���� O(NlogN) ��ʱ�临�Ӷȡ�
        �ʿ���������������ĿҪ��Ϊ O(N) ��ʱ�临�Ӷȣ�Ҳ����˵����ÿһ��Ԫ�صĲ�������
        O(1) �ģ����Ҹ���Ԫ��������ģ������������ص������뵽������������� HashMap.
        ��Ϊ���ص�������в�����Ϊ O(1), ����û��˳��

        �뵽ʹ�� HashMap ֮��������Ҫ��������key,valueӦ�ô洢ʲô��key��������Ӧ�þ���
        ����Ԫ���ˣ���ôvalue�أ���ΪҪ�� O(N) ��ʱ�临�Ӷȣ���������ÿ��Ԫ��ֻ�ܲ�ѯһ�Σ�
        �����ζ��������Ҫȥ����Щ�ظ��Ĳ�ѯ�������� value ֵΪ boolean, ��ʾ��ǰԪ���Ƿ�
        �Ѿ�����ѯ���ˡ�

        ����������ֻ��Ҫ��ѯ num-- �� num++ �Ƿ������ HashMap �м��ɣ����������ʾ������
        ������+1, ͬʱ��num-- �� num++ �� value ��Ϊtrue. �����ڶ��β�ѯʱ����������value
        Ϊtrue��ֱ��������Ԫ�ء�������Ƿ����������������ĳ��ȼ��ɡ�

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Hide Tags Array

Thinking process:
0. This problem can be done using sorting, but time complexity of sorting is O(nlogn). This problem requires O(n).
1. Want to check if a number's left and right is consecutive to itself, but cannot do it due to the given unsorted array: think about a Hashmap.
2. HashMap(Key, Value) = (the number itself, boolean: have been counted or not). If you count a number as a consecutive, you only need to count it once.
3. How HashMap works: 
	when checking a number's consecutive, look at number--, number++, see if they are in the HashMap. If exist, means consecutive.
	If a number exist in the hashmap and its value is 'true', then we need to skip this number beacuse it has been checked.
4. Track the total number consecutives of 1 perticular number, compare it with the maxL. Save the Math.max to maxL.
5. Depending on the problem, we can store a consecutive sequence or simply just its length: maxL. This problem wants the maxL.
*/

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int maxL = 1;
        HashMap<Integer, Boolean> history = new HashMap<Integer, Boolean>();

        for (int i : num) {
            history.put(i, false);
        }

        for (int i : num) {
            // if the element has been checked skip it
            if (history.get(i)) {
                continue;
            }
            //check ++num
            int temp = i;
            int total = 1;
            while (history.containsKey(++temp)) {
                total++;
                history.put(temp, true);
            }
            //check --num
            temp = i;
            while (history.containsKey(--temp)) {
                total++;
                history.put(temp, true);
            }
            maxL = Math.max(maxL, total);
        }

        return maxL;
    }
}