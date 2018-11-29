�����������⼸��������ʹ�÷��η������
        ע�⽫������Maximum Depth of Binary Tree���бȽϡ�

        �տ�ʼ�õ�����⣬���벻�Ǻܼ��𣬲����������ȵĴ����Ϊ��С�������� �������Ľ��������Щ����ʱͨ�����ġ�

        ��Ϊ�������б���������Ҳ����˵ֻ������������ֻ����������ʱ����������������ȵķ�����ʵ�ֵĻ����ó��Ĵ���0�������Ǵ���ġ�

        �����������ֽ��������
        ��һ�־��Ǽ�������������������ȵ�ʱ���ж��Ƿ����0���������0��˵�������������ڣ���ȸ�ֵΪ���ֵ��

        �ڶ��־����ж����������������Ƿ�Ϊ�գ���������Ϊ�գ��򷵻�����������ȣ���֮��������������ȣ��������Ϊ�գ��򷵻�����������������ȵ���Сֵ

/*

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The minimum depth is 2.

Tags 
Binary Tree Depth First Search
*/

//	Version 1

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        //	��������Ҷ�ӽڵ�ʱreturn 1��Ϊ�ݹ�ı߽�
        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}


//	Version 2 

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int helper(TreeNode root) {
        //	ͬVersion 1 ��������Ҷ�ӽڵ�ʱreturn 1��Ϊ�ݹ�ı߽�
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return helper(root.right) + 1;
        }
        if (root.right == null) {
            return helper(root.left) + 1;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        return Math.min(left, right) + 1;
    }

    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int rst = helper(root);
        return rst;
    }
}