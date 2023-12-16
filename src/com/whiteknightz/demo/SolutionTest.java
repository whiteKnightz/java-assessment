package com.whiteknightz.demo;

import java.util.*;
import java.util.stream.IntStream;

public class SolutionTest {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = IntStream.of(Arrays.copyOfRange(nums, i, j + 1)).sum();
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (currentVal * nums[j] > max) {
                    max = currentVal * nums[j];
                }
                currentVal *= nums[j];
            }
        }
        return max;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet with sum 0
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static int missingNumber(int[] nums) {
        int missingNum = -1;
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            if (Arrays.stream(nums).noneMatch(value -> (value == finalI))) {
                missingNum = i;
                break;
            }
        }
        return missingNum;
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // Sort the coins array in ascending order
        Arrays.sort(coins);

        // Create an array to store the fewest number of coins needed for each amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Iterate through each coin
        for (int coin : coins) {
            // Iterate through each amount starting from the coin value
            for (int i = coin; i <= amount; i++) {
                // Update the dp array with the fewest number of coins needed
                System.out.println(coin + "--" + i + ": " + dp[i] + "----" + dp[i - coin]);
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
                System.out.println(coin + "--" + i + ": " + dp[i]);
            }
        }

        // Check if it's possible to make up the given amount and return the result
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // Initialize all LIS values to 1

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 1;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

//    public static boolean wordBreak(String s, List<String> wordDict) {
//        boolean isMatch = true;
//        int[] indices = new int[wordDict.size()];
//        Arrays.fill(indices, -1);
//        for(int i = 0; i< wordDict.size();i++){
//            int index = s.indexOf(wordDict.get(i));
//            if(index<0){
//                isMatch = false;
//                break;
//            }
//            indices[i] = index;
//        }
//        if(isMatch){
//            Arrays.sort(indices);
//
//            for(int i = 1; i< indices.length;i++){
//                if (indices[i]>-1 && indices[i]==indices[i-1]){
//                    isMatch=false;
//                    break;
//                }
//            }
//        }
//        return isMatch;
//    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string can always be segmented

        // Iterate through each character in the string
        for (int i = 1; i <= s.length(); i++) {
            // Check if the substring up to index i can be segmented
            for (String word : wordDict) {
                if (i >= word.length() && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // The final result is whether the entire string can be segmented
        return dp[s.length()];
    }


    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] sums = new int[len];
        sums[0] = nums[0];
        sums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            sums[i] = Math.max(sums[i - 1], nums[i] + sums[i - 2]);
        }
        return sums[len - 1];
    }

    public static int rob2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int max1 = rob2Helper(nums, 0, len - 2);
        int max2 = rob2Helper(nums, 1, len - 1);
        return Math.max(max1, max2);
    }

    private static int rob2Helper(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
//        sums[len]=Math.max(sums[len-1], nums[0]+sums[len-2]);
        return Math.max(currMax, prevMax);
    }

    public static int numDecodings(String s) {
        int len = s.length();

        if (len == 1) {
            return 1;
        } else if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0; i < len; i++) {
            if (i > reach) {
                return false;
            }

            reach = Math.max(reach, i + nums[i]);

            if (reach >= len - 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (arr[current] == 0) {
                return true;
            }

            visited[current] = true;

            int forward = current + arr[current];
            int backward = current - arr[current];

            if (isValidIndex(forward, n) && !visited[forward]) {
                queue.offer(forward);
            }

            if (isValidIndex(backward, n) && !visited[backward]) {
                queue.offer(backward);
            }
        }

        return false;
    }

    private static boolean isValidIndex(int index, int n) {
        return index >= 0 && index < n;
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }

    private Node cloneGraph(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        for (Node n : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(n, visited));
        }
        return clonedNode;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an array to store the in-degree of each course
        int[] inDegree = new int[numCourses];

        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the in-degree array and the adjacency list
        for (int[] prerequisite : prerequisites) {
            int courseA = prerequisite[0];
            int courseB = prerequisite[1];

            inDegree[courseA]++;
            graph.get(courseB).add(courseA);
        }

        // Use a queue for topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform topological sorting
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;

            for (int neighbor : graph.get(course)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all courses have been taken (numCourses is 0), return true; otherwise, return false
        return numCourses == 0;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, canReachPacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, canReachAtlantic, Integer.MIN_VALUE, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, canReachPacific, Integer.MIN_VALUE, 0, j);
            dfs(heights, canReachAtlantic, Integer.MIN_VALUE, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, boolean[][] canReach, int prevHeight, int row, int col) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || canReach[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        canReach[row][col] = true;

        dfs(heights, canReach, heights[row][col], row + 1, col);
        dfs(heights, canReach, heights[row][col], row - 1, col);
        dfs(heights, canReach, heights[row][col], row, col + 1);
        dfs(heights, canReach, heights[row][col], row, col - 1);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Add non-overlapping interval to the result
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlappingCount = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                nonOverlappingCount++;
                end = intervals[i][1];
            }
        }

        return intervals.length - nonOverlappingCount;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        while (head!=null){
            nodes.add(head);
            head=head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        for (int i=0;i<nodes.size();i++){
            if(nodes.size()-n!=i-1){
                result.next = nodes.get(i);
                result=result.next;
            }
        }
        return dummy.next;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseList(middle.next);
        middle.next = null;

        // Step 3: Merge the first half and the reversed second half
        mergeLists(head, reversedSecondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow
                ;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    private void mergeLists(ListNode first, ListNode second) {
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    public static void main(String[] arg) {
        int[] inputVal = new int[]{3, 0, 2, 1, 2};
//        int result = SolutionTest.lengthOfLIS(inputVal);
//        String s = "bb";
//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("a","b","bbb","bbbb");
//        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        boolean result = SolutionTest.canReach(inputVal, 2);
        System.out.println(result);
    }

    public static void printArray(int[] objects) {
        for (int i = 0; i < objects.length; i++) {
            System.out.println(i + ": " + objects[i]);
        }
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
