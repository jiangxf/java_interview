Ҫ����� n �׳���β����ĸ���.
        ˼·������
        �����1 �� 2 �� 3 �� 4 �� ������ N ��ÿһ�������ֽ���������������ǣ�
        1 �� 2 �� 3 �� (2 �� 2) �� 5 �� (2 �� 3) �� 7 �� (2  �� 2 �� 2) ������
        ʮ��������β��ÿһ��0����ʾ��һ������10���� ���� �κν��ƶ�һ��������һ��M���Ƶ�������β��һ��0�� �ȼ��� ����M��
        10 ���Էֽ�Ϊ 2*5 ���� ��Ϊֻ������2��5����ܲ���0������κ�����������˶����ܲ���0������2��5���ֻ����һ��0��
        ���ԣ��ֽ�����������ʽ���ж��ٶ�(2,5)������о��ж��ٸ�0�����ֽ�Ľ���У�2�ĸ�����Ȼ�Ƕ���5�ģ���ˣ��ж��ٸ�5�����ж��ٸ�(2,5)�ԡ�
        ���ԣ����� n �Ľ׳˽�β�м���0�����⣬�ͱ�ת������1�� n ������Щ�����������ֽ�ʽ�ж��ٸ� 5 �����⡣

/*
Description
Write an algorithm which computes the number of trailing zeros in n factorial.

Example
11! = 39916800, so the out should be 2

Challenge 
O(log N) time

Tags 
Mathematics
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
};