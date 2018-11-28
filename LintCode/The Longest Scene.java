/*
Description
A string, each character representing a scene. Between two identical characters is considered to be a continuous scene.
For example: abcda, you can think of these five characters as the same scene.
Or acafghbeb can think of two aca and beb scenes.
If there is a coincidence between the scenes, then the scenes are combined.
For example, abcab, where abca and bcab are coincident, then the five characters are considered to be the same scene.
Give a string to find the longest scene.

1 <= |str| <=1e5
str contains only lowercase letters

Example
Given str = "abcda", return 5.
Explanation:
The longest scene is "abcda".

Given str = "abcab", return 5.
Explanation:
The longest scene is "abcab".
 */

/**
 * Approach 1: Sweep Line
 * 与 区间归并(Merge Intervals) 这道题目十分类似
 * https://github.com/cherryljr/LintCode/blob/master/Merge%20Intervals.java
 *
 * 扫描线详解：
 * https://github.com/cherryljr/LintCode/blob/master/Number%20of%20Airplanes%20in%20the%20Sky.java
 */
public class Solution {
    /**
     * @param str: The scene string
     * @return: Return the length longest scene
     */
    public int getLongestScene(String str) {
        char[] chars = str.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new LinkedList<>());
            }
            map.get(chars[i]).add(i);
        }

        // 生成每个字符所对应的最长区间
        List<Interval> intervals = new LinkedList<>();
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> tempList = entry.getValue();
            // 只有一个数，无法形成区间
            if (tempList.size() == 1) {
                continue;
            }
            int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
            for (int index : tempList) {
                if (index < start) {
                    start = index;
                }
                if (index > end) {
                    end = index;
                }
            }
            intervals.add(new Interval(start + 1, end + 1));
        }

        // 使用 Sweep Line 处理这些区间段即可
        List<Point> list = new LinkedList<>();
        for (Interval interval : intervals) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, -1));
        }
        Collections.sort(list);

        int count = 0;
        int pre = 0, preIndex = 0;
        int rst = 0;
        for (Point p : list) {
            count += p.flag;
            if (pre == 0 && count > 0) {
                pre = count;
                preIndex = p.index;
            }
            if (pre != 0 && count == 0) {
                rst = Math.max(rst, p.index - preIndex + 1);
                pre = count;
            }
        }
        return rst;
    }

    class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Point implements Comparable<Point> {
        int index, flag;

        public Point(int index, int flag) {
            this.index = index;
            this.flag = flag;
        }

        @Override
        public int compareTo(Point p) {
            return this.index - p.index == 0 ? this.flag - p.flag : this.index - p.index;
        }
    }
}

/**
 * Approach 2: Greedy
 * 将 Intervals 依据 start 进行排序，然后可以对比其前一个 preInterval.end 与当前 currInterval.start.
 * 如果 start 在前一个 interval 的 end 之后，
 * 那么说明上一个区间与当前区间无法连起来，因此我们需要更新当前区间的起点。
 * 否则，说明上一个区间与当前区间存在重合部分，
 * 所以将上一个区间的 pre.end 更新为当前区间的 curr.end。
 */
public class Solution {
    /**
     * @param str: The scene string
     * @return: Return the length longest scene
     */
    public int getLongestScene(String str) {
        char[] chars = str.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new LinkedList<>());
            }
            map.get(chars[i]).add(i);
        }

        // 生成每个字符所对应的最长区间
        List<Interval> intervals = new LinkedList<>();
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> tempList = entry.getValue();
            // 只有一个数，无法形成区间
            if (tempList.size() == 1) {
                continue;
            }
            int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
            for (int index : tempList) {
                if (index < start) {
                    start = index;
                }
                if (index > end) {
                    end = index;
                }
            }
            intervals.add(new Interval(start + 1, end + 1));
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // Initialize pre and maxLen
        Interval pre = intervals.get(0);
        int maxLen = intervals.get(0).end - intervals.get(0).start + 1;
        for (Interval curr : intervals) {
            if (pre.end < curr.start) {
                pre =curr;
            } else {
                pre.end = Math.max(pre.end, curr.end);
            }
            maxLen = Math.max(maxLen, pre.end - pre.start + 1);
        }
        return maxLen;
    }

    class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}