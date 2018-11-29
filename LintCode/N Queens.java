DFS�ľ�����Ŀ��
        N�ʺ�����Ľ����Ȼ��ÿ�к�ÿ�������ҽ���һ���ʺ�
        ����ʵ���Ͼ���һ���������⡣
        ��������������һ����СΪN���������洢ÿ�лʺ��λ�ã��������±��ʾrow��ֵ��ʾcolumn��
        Ȼ���ж��¼���Ļʺ��Ƿ�ṥ���������Ļʺ�
        �������鱻������˵���ҵ���һ�ֽⷨ���㽫��ӵ�result�С�

        �����ʺ���Թ������Է��������������жϣ�
        1. ��ȡÿ�лʺ��λ�ã�ȷ��ÿ��ֻ��һ���ʺ�
        2. ����������ĺ�������ĺ��Ƿ�������ж��������Ƿ���ͬһб���� --б��Ϊ 1
        3. ����������ĺ�������Ĳ��Ƿ�������ж��������Ƿ���ͬһб���� --б��Ϊ-1
/*
Description:
The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
both indicate a queen and an empty space respectively.

Example
There exist two distinct solutions to the 4-queens puzzle:

[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
] 	

Challenge 
Can you do it without recursion?
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private void search(ArrayList<ArrayList<String>> results,
                        ArrayList<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private ArrayList<String> drawChessboard(ArrayList<Integer> cols) {
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
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