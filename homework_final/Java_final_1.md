# Java Final

## 两数之和

```java
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

### 循环遍历

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        int target = input.nextInt();
        input.close();
        twosum(nums, target);
    }

    public static int[] twosum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.print(i + " ");
                    System.out.print(j);
                }
            }
        }
        return null;
    }
}
```

### 哈希映射法

```java
import java.util.Scanner;
import java.util.HashMap;

public class sumoftwonumbers2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        int target = input.nextInt();
        input.close();
        twosum(nums, target);
    }

    public static void twosum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (!hashmap.containsKey(target - nums[i])) {
                hashmap.put(nums[i], i);
            }
            else {
                System.out.print(hashmap.get(target - nums[i]));
                System.out.print(" ");
                System.out.print(i);
            }
        }
    }
}
```



## 压栈序列

```java
输入共由3行组成，第一行为押入顺序序列的个数，第二行为压栈序列，第三行为弹出序列
若第三行输入为第二行的弹出序列，则输出true，否则输出false 示例：
输入：
5
1 2 3 4 5
4 5 3 2 1
输出：
true
```

### 	模拟栈操作

* 建立一个新的栈，然后依次`push`，加`while pop`。

```java
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] pushed = new int[length];
        for (int i = 0; i < length; i++) {
            pushed[i] = input.nextInt();
        }
        int[] poped = new int[length];
        for (int i = 0; i < length; i++) {
            poped[i] = input.nextInt();
        }
        input.close();
        if (sequenceVerify(length, pushed, poped))
            System.out.println("true");
        else
            System.out.println("false");
        
    }

    public static boolean sequenceVerify(int length, int[] pushed, int[] poped) {
        Stack<Integer> stk = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < length; i++) {
            stk.push(pushed[i]);
            while (!stk.empty() && stk.peek() == poped[j]) {
                stk.pop();
                j++;
            }
        }
        return j == length;
    }
}
```

## 反转链表

```java
给定n个整数,将n个组织成链表形式,然后将该链表反转后输出.
如给定元素为:1 2 3,则首先将输入元素组织为1 -&gt;2 -&gt;3的形式,然后将链表反转为3-&gt;2-&gt;1,然后输出. 输入格式
输入由两行组成,第一行为要输入的整数个数n,第二行为n个整数.
输出格式
链表反转后的结果
示例
输入
3
1 2 3
输出
3 2 1
```

### 迭代

* 双指针法，还利用了头节点的一个空闲指针用来操作

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        if (length == 0) {
            input.close();
            return;
        }
        ListNode head = new ListNode(input.nextInt());
        ListNode tail = head;
        for (int i = 0; i < length - 1; i++) {
            tail.next = new ListNode(input.nextInt());
            tail = tail.next;
        }
        input.close();
        if (head != null)
            head = reverseList(head);
        printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur, nxt;
        cur = head;
        nxt = cur.next;
        while (nxt != null) {
            head.next = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = head.next;
        }
        head.next = null;
        return cur;
    }

    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
```

### 递归

* 一定注意递归的边界，以及递归函数返回的是最后一个结点

```java
import java.util.Scanner;

public class reverseLinkedList2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        if (length == 0) {
            input.close();
            return;
        }
        ListNode head = new ListNode(input.nextInt());
        ListNode tail = head;
        for (int i = 0; i < length - 1; i++) {
            tail.next = new ListNode(input.nextInt());
            tail = tail.next;
        }
        input.close();
        if (head != null)
            head = reverseList(head);
        printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if(head.next != null) {
            ListNode temp = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return temp;
        }
        else {
            return head;
        }
        
    }

    // 错误做法，一定要返回初始状态的尾结点
    // public static ListNode reverseList2(ListNode head) {
    //     if(head.next != null) {
    //         reverseList2(head.next).next = head;
    //         head.next = null;
    //         return head;
    //     }
    //     else {
    //         return head;
    //     }
        
    // }

    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
```



## 缺失数字

```java
输入由两行组成,第一行为要输入数组的个数,第二行为数组的各个元素.
输出部分直接打印结果即可

输入输出示例
示例1
输入:
3
0 1 3
输出:
2
示例2
输入:
9
0 1 2 3 4 5 6 7 9
输出:
8
```

### 顺序遍历

* 依次遍历，找到不相符的数字

```java
import java.util.Scanner;
public class lackNumber {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int [] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        System.out.print(getlackNumber(length, nums));
    }

    public static int getlackNumber(int length, int [] nums) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = nums[i] - i;
            if (sum != 0) return i;
        }
        return length;
    }

}

```

### 二分法

* 二分查找找到不符合的数

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        System.out.print(getlackNumber(0, length, nums));
    }

    // 这里用左闭右开的区间，从而统一了尾部元素的情况
    public static int getlackNumber(int start, int end, int[] nums) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}

```

## 子树结构

```java
输入输出说明
输入由四行组成.
第一行为代表二叉树A结构的数组长度,第二行为代表二叉树A结构的数组.
第三行为代表二叉树B结构数组的长度,第四行为代表二叉树B结构的数组.
约定:二叉树节点的值都为整数值,0代表该节点对应位置为空. 输出为true或者false

输入输出示例
输入: 7
3 4 5 1 2 0 0
3
4 1 0
输出:
true
上述的输入对应题目中给出的示例,5的左右子节点都为null,因此子节点对应的数值为0
```

### 树的构造和打印

```java
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class isSubtree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n_1 = input.nextInt();
        int[] nums_1 = new int[n_1];
        for (int i = 0; i < n_1; i++) {
            nums_1[i] = input.nextInt();
        }
        // int n_2 = input.nextInt();
        // int[] nums_2 = new int[n_2];
        // for (int i = 0; i < n_2; i++) {
        // nums_2[i] = input.nextInt();
        // }
        input.close();
        TreeNode tree_1 = genTree(nums_1);
        printTree(tree_1);

    }

    public static TreeNode genTree(int[] nums) {
        int length = nums.length;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i < length && nums[i] != 0) {
                queue.peek().left = new TreeNode(nums[i]);
                queue.add(queue.peek().left);
            }
            if (i + 1 < length && nums[i + 1] != 0) {
                queue.peek().right = new TreeNode(nums[i + 1]);
                queue.add(queue.peek().right);
            }
            queue.poll();
            i += 2;
        }
        return root;
    }

    public static void midorder(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            midorder(root.left);
        System.out.print(root.val + " ");
        if (root.right != null)
            midorder(root.right);
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val + " ");
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
                next++;
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
                next++;
            }
            queue.poll();
            current--;

            if (current == 0) {
                current = next;
                next = 0;
                System.out.println();
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    TreeNode() {
        val = 0;
        left = null;
        right = null;
    }
}
```

### 递归比较

* 比较双方根节点
* 比较左子树和根节点
* 比较右子树和根节点

```java
    public static boolean compTree(TreeNode root_1, TreeNode root_2) {
        if (root_2 == null || root_1 == null)
            return false;
        else if (compNode(root_1, root_2))
            return true;
        else
            return compTree(root_1.left, root_2) || compTree(root_1.right, root_2);
    }

    public static boolean compNode(TreeNode node_1, TreeNode node_2) {
        if (node_2 == null)
            return true;
        else if (node_1 == null || node_1.val != node_2.val)
            return false;
        else
            return compNode(node_1.left, node_2.left) && compNode(node_1.right, node_2.right);
    }
```

## 重建二叉树

```java
输入输出说明
输入由3行组成:
第一行为二叉树的节点个数,即先序和后续序列的长度.
第二行为先序遍历得到的序列
第三行为中序遍历得到的序列

输入输出示例
输入:
5
3 9 20 15 7
9 3 15 20 7
输出:
9 15 7 20 3
```

### 切片递归

* 每次从前序中读的时候要顺手删除已读元素
* 从中序序列中读的时候

```java
public static TreeNode genTree(List<Integer> nums_pre, List<Integer> nums_mid) {
    if (nums_mid.isEmpty())
        return null;
    int rootVal = nums_pre.remove(0);
    int rootIndex = nums_mid.indexOf(rootVal);

    TreeNode root = new TreeNode(rootVal);
    root.left = genTree(nums_pre, nums_mid.subList(0, rootIndex));
    root.right = genTree(nums_pre, nums_mid.subList(rootIndex + 1, nums_mid.size()));

    return root;
}
```

## 层次遍历

```java
输出:3 9 20 15 7

输入输出说明
二叉树以满二叉树的数组形式给出,其中0代表空节点,如上述二叉树对应的数组形式为[3,9,20,0,0,15,7].
输入由两部分组成,第一行为数组个数,第二行为数组中的各个元素. 输出为遍历结果.

输入输出示例
输入:
7
3 9 20 0 0 15 7
输出
3 9 20 15 7
```

### 队列辅助

```java
public static void layerorder(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    if (root == null)
        return;
    queue.add(root);
    while (!queue.isEmpty()) {
        System.out.print(queue.peek().val + " ");
        if (queue.peek().left != null)
            queue.add(queue.peek().left);
        if (queue.peek().right != null)
            queue.add(queue.peek().right);
        queue.pop();
    }
}
```



### 分层换行

```java
public static void layerorder2(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    if (root == null)
        return;
    queue.add(root);
    int currentline = 1;
    int nextline = 0;
    while (!queue.isEmpty()) {
        System.out.print(queue.peek().val + " ");
        if (queue.peek().left != null) {
            queue.add(queue.peek().left);
            nextline += 1;
        }
        if (queue.peek().right != null) {
            queue.add(queue.peek().right);
            nextline += 1;
        }
        queue.pop();
        currentline -= 1;
        if (currentline == 0) {
            currentline = nextline;
            nextline = 0;
            System.out.println();
        }
    }
}
```



## 矩阵路径

```java
判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]
但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

输入输出说明
输入由3行组成.
第一行由两个整数m和n组成,代表矩阵的维度.
第二行由m*n个字符组成的字符串组成,字符中间没有空格.
第三行为一行字符串,字符串中间没有空格
输出为true或false

输入输出示例
输入
3 4
abcesfcsadee	
abfb
输出
false
```

### 回溯+标志位

```java
import java.util.Scanner;

public class validtrace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        char[][] board = new char[m][n];
        String str = input.next();
        String target = input.next();
        input.close();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(i * n + j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, target, 0, 0, 0)) {
                    System.out.print("true");
                    return;
                }
            }
        }
        System.out.print("false");
    }

    public static boolean dfs(char[][] board, int m, int n, String target, int i, int j, int k) {
        if (i < 0 || i >= m || j >= n || j < 0 || board[i][j] != target.charAt(k))
            return false;
        if (k == target.length() - 1)
            return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, m, n, target, i - 1, j, k + 1) || dfs(board, m, n, target, i + 1, j, k + 1)
                || dfs(board, m, n, target, i, j - 1, k + 1) || dfs(board, m, n, target, i, j + 1, k + 1);
        board[i][j] = temp;
        return res;
    }

    public static void printBoard(char[][] board) {
        for (char[] line : board) {
            for (char item : line) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}

```

## 编辑距离

```java
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
 

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

### 动态规划

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int up_value = dp[i - 1][j] + 1;
                int left_value = dp[i][j - 1] + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    left_value = Math.min(left_value, dp[i - 1][j - 1]);
                else
                    left_value = Math.min(left_value, dp[i - 1][j - 1] + 1);
                dp[i][j] = Math.min(up_value, left_value);
            }
        }
        return dp[m][n];
    }
}
```

## 最近公共祖先

```java
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]


```

### 完整测试代码

```java
import java.util.LinkedList;

public class commonAncester {
    static TreeNode ans = null;
    public static void main(String[] args) {
        int[] nums = { 3, 5, 1, 6, 2, 0, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 4 };
        TreeNode[] init_tree = genTree(nums, 5, 1);
        TreeNode root = init_tree[0];
        TreeNode p = init_tree[1];
        TreeNode q = init_tree[2];
        System.out.print(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson)))
            ans = root;
        return root.val == p.val || root.val == q.val || lson || rson;
    }

    public static void midorder(TreeNode root) {
        if (root == null)
            return;
        midorder(root.left);
        System.out.print(root.val + " ");
        midorder(root.right);
    }

    public static TreeNode[] genTree(int[] nums, int p_value, int q_value) {
        int length = nums.length;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        TreeNode p = null, q = null;
        queue.add(root);
        int cur = 1;
        while (!queue.isEmpty()) {
            if (cur < length && nums[cur] != Integer.MAX_VALUE) {
                queue.peek().left = new TreeNode(nums[cur]);
                queue.add(queue.peek().left);
                if (nums[cur] == p_value)
                    p = queue.peek().left;
                if (nums[cur] == q_value)
                    q = queue.peek().left;
            }
            if (cur + 1 < length && nums[cur + 1] != Integer.MAX_VALUE) {
                queue.peek().right = new TreeNode(nums[cur + 1]);
                queue.add(queue.peek().right);
                if (nums[cur + 1] == p_value)
                    p = queue.peek().right;
                if (nums[cur + 1] == q_value)
                    q = queue.peek().right;
            }
            queue.poll();
            cur += 2;
        }
        TreeNode[] res = { root, p, q };
        return res;
    }
}

```



### 递归

* 用一个辅助函数来判断根节点的子树种是否含有一个或者两个结点

```java
class Solution {
    static TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson)))
            ans = root;
        return root.val == p.val || root.val == q.val || lson || rson;
    }
}
```

### 哈希

* 用一个映射记录每个结点的父节点
* 用一个哈希集合记录从一个结点向上的路径遇到的每一个结点

```java
public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    HashMap<Integer, TreeNode> hashtable = new HashMap<Integer, TreeNode>();
    HashSet<TreeNode> visited = new HashSet<TreeNode>();
    init_hash(root, hashtable);
    while(p.val != root.val) {
        visited.add(p);
        p = hashtable.get(p.val);
    }
    while(q.val != root.val) {
        if (visited.contains(q)) {
            return q;
        }
        q = hashtable.get(q.val);
    }
    return root;
}

public static void init_hash(TreeNode root, HashMap<Integer, TreeNode> hashtable) {
    if (root == null)
        return;
    if (root.left != null) {
        hashtable.put(root.left.val, root);
        init_hash(root.left, hashtable);
    }
    if (root.right != null) {
        hashtable.put(root.right.val, root);
        init_hash(root.right, hashtable);
    }
}
```

### DFS

```java

```

