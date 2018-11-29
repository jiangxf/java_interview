�����N Queens���Ӽ��ˡ�
        ��ΪֻҪ�����ĸ���������Ҫ�����г�����
        ���൱������drawChessBoard()���������
        ����˼·��N Queens��ͬ��
        ���������˽ⷨ1��ʹ��DFS���ݹ�����õ������

        ͬʱ���Ƿ�������ֻ��Ҫ��ķ���������������Ҫ���ǽ�����ķ����г�����
        �����ǿ���ʹ�ö�̬�滮����������⡣
        ����������˽ⷨ2��DP

/*
Description:
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.

Example
For n=4, there are 2 distinct solutions.

*/

//	Version 1: DFS Traverse
class Solution {
    /**
     * Get all distinct N-Queen solutions
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    int result = 0;

    public int totalNQueens(int n) {
        //write your code here
        if (n <= 0) {
            return result;
        }

        helper(new ArrayList<Integer>(), n);
        return result;
    }

    private void helper(ArrayList<Integer> list, int n) {
        if (list.size() == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(list, i)) {
                continue;
            }

            list.add(i);
            helper(list, n);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(ArrayList<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            //	б��Ϊ 1 -- 45��
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            //	б��Ϊ -1 -- 135��
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }

}


//	Version 2: DP
public class Solution {
    public static int sum;

    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        placeQueen(usedColumns, 0);
        return sum;
    }

    public void placeQueen(int[] usedColumns, int row) {
        int n = usedColumns.length;

        if (row == n) {
            sum++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueen(usedColumns, row + 1);
            }
        }
    }

    public boolean isValid(int[] usedColumns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (usedColumns[i] == col) {
                return false;
            }
            if ((row - i) == Math.abs(col - usedColumns[i])) {
                return false;
            }
        }
        return true;
    }
}