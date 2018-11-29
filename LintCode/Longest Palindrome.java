˼·һ�� ���� HahsMap ʵ��
        ��������һ���ַ������������ҳ�������ɵ���Ļ��Ĵ��ĳ��ȣ������ַ�˳����Դ��ң�
        ���������ת��Ϊ����ż�����ַ��ĸ����������˽���Ĵ��Ķ�֪�������Ĵ���Ҫ��������ʽ��
        һ����������ȫ�ԳƵģ�����noon; ����һ�������м��ַ�Ϊ���ģ����ҶԳƣ�����bob��level�ȡ�
        ��ô����ͳ�Ƴ�������ż�����ַ��ĳ����ܺͣ�Ȼ��������������ַ��Ļ�������ȡȡ�������ż����
        Ȼ���������1���ɡ�

        ˼·���� ���� HashSet ʵ��
        ˼·һ��ͨ��ͨ����ϣ���������ַ����͸����ַ����ִ�����ӳ�䡣
        �������ǿ����ڴ˻����ϻ�һ��˼·��
        1. �ҳ��������������ַ���
        ���ǲ��õķ�����ʹ��һ��set���ϣ�������������ַ�����set�У���ô�ͽ������set��
        ����Ѿ���set���ˣ��ͽ����set��ɾȥ������������ɺ�set�о������г��ָ��������������ַ��ˡ�
        2.s�ĳ��ȼ�ȥ Math.max(0,hs.size()-1), �������Ĵ�����
        ��ôΪʲô�Ǽ�ȥ���ߵ����ֵ�أ�
        ԭ���ǣ����û�г��ָ��������������ַ�����ôt�ĳ��Ⱦ���0����1����-1����ôs�ĳ���ֻҪ��ȥ0���ɣ�
        ��������������ַ�����ô�ַ�������1�����ǲ�����ɻ��Ĵ����ַ�����Ϊ���Ĵ��������һ�����ɶԳ��ֵ��ַ�.

/*
Description
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.

Notice
Assume the length of given string will not exceed 1010.

Example
Given s = "abccccdd" return 7
One longest palindrome that can be built is "dccaccd", whose length is 7.

Tags 
Hash Table Amazon
*/

// Version 1: HashMap


// Version 2: HashSet
public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> hs = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }

        return (s.length() - Math.max(0, hs.size() - 1));
    }
}