�漰�������ֵ�������ϣ������뵽��ʹ���ַ����������
        ��Ϊ�ַ���������� ���� ֧�ִ���������
        ��Ҫ�õ���Ϻ��ֵ��С�����漰���� �ַ��� �ıȽϡ�
        ������Ҫ�Ƚϵ��������ַ��� concat ֮���ĸ�����С���� a+b �� b+a �еĽ�Сֵ��
        ������дһ���Ƚ����������� Arrays.sort() ���������������ʱ�临�Ӷ�Ϊ O(nlogn)

        ע�⣺������ɺ�� ans �ַ�����ͷ�ܿ����� 0, ���Ǳ���Ҫ�Թ��ò��ֲ��С�

/*
Description
Construct minimum number by reordering a given non-negative integer array. Arrange them such that they form the minimum number.

Notice
The result may be very large, so you need to return a string instead of an integer.

Example
Given [3, 32, 321], there are 6 possible numbers can be constructed by reordering the array:
3+32+321=332321
3+321+32=332132
32+3+321=323321
32+321+3=323213
321+3+32=321332
321+32+3=321323
So after reordering, the minimum number is 321323, and return it.

Challenge 
Do it in O(nlogn) time complexity.

Tags 
Array
*/

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // �Զ���Ƚ�������С����
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String a, String b) {
                String ab = a.concat(b);
                String ba = b.concat(a);
                return ab.compareTo(ba);
            }
        });

        String ans = "";
        for (int i = 0; i < str.length; i++) {
            ans = ans.concat(str[i]);
        }
        // �ǵô����ַ����� 0 ��ͷ�Ĳ��֣�����
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        if (i == ans.length()) {
            return "0";
        }
        return ans.substring(i);
    }
}