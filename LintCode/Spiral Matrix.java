/*
Description
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.


Example
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

Tags 
Array Matrix
*/

/**
 * Approach: Layer by Layer
 * �����Ŀ�����һ����ģ��ķ���ȥ���⣬���ǻᷢ�֣�������̲����ô���
 * ���һ���������Ҫ����ı߽����⡣
 * ������ǿ��� ����ȥ����ֲ� ��ת����ôʵ�֣����Ǵ���Ŀ�� ���� ȥ���֡�
 * <p>
 * ����Ŀ�������������Ƿ�����ʵ�ʾ��� һ��� �� �ⲿ �� �ڲ� �������� ����ôһ�����̡�
 * ��������ȷ���� ���Ͻ� �� ���½� ֮���������εı߾Ϳ��Ա�ȷ����
 * Ȼ������ֻ��Ҫдһ�� ����˳ʱ��������������� ����ô������ printEdge ���ɡ�
 * ��������ͷǳ���ʵ���ˣ�ע�⴦��� �߽����� ���ɣ�
 * Ȼ���������ľ��κ����Ͻǵĵ� �� ���½ǵĵ� ���ڲ��ƶ�
 * ֱ�� ���Ͻǵ�ĺ������� ���� ��С�ǵ�ĺ�������
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> rst = new ArrayList<>();
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        // ����ǰ�� ���Ͻǵ�(tR,tC) �� ���½ǵ�(dR,dC) ����λ�õľ��εı��ϵ�����˳����� rst ��
        // �����굱ǰ�ľ��κ� ���Ͻǵĵ� �� ���½ǵĵ� ���ڲ��ƶ�
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--, rst);
        }

        return rst;
    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC, List<Integer> rst) {
        if (tR == dR) {
            // �� ���Ͻǵĵ� �� ��С�ǵĵ� ��ͬһ�е�ʱ�򣬽�����ȫ��Ԫ�ؼ��� rst ��
            for (int i = tC; i <= dC; i++) {
                rst.add(matrix[tR][i]);
            }
        } else if (tC == dC) {
            // �� ���Ͻǵĵ� �� ��С�ǵĵ� ��ͬһ�е�ʱ�򣬽�����Ԫ��ȫ������ rst ��
            for (int i = tR; i <= dR; i++) {
                rst.add(matrix[i][tC]);
            }
        } else {
            // ����˳ʱ���˳���� ���Ͻ� �� ���½� �������㶨λ�ľ��ε� ������ �ϵ���
            // ��˳��ȫ�����뵽 rst �У�ע�⴦��߽���������������ʹ���� ǰ�պ� �ķ�Χ��
            int currR = tR, currC = tC;
            // ��������������ߣ���ΧΪ [���Ͻ�...���Ͻ�)
            while (currC < dC) {
                rst.add(matrix[tR][currC++]);
            }
            // �����Ҳ�������ߣ���ΧΪ [���Ͻ�...���½�)
            while (currR < dR) {
                rst.add(matrix[currR++][dC]);
            }
            // ��������������ߣ���ΧΪ [���½�...���½�)
            while (currC > tC) {
                rst.add(matrix[dR][currC--]);
            }
            // �������������ߣ���ΧΪ [���½�...���Ͻ�)
            while (currR > tR) {
                rst.add(matrix[currR--][tC]);
            }
        }
    }
}