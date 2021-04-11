package bfs;
/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */

import java.util.*;


public class No752 {

    //将s[j]向上拨动一次
    public String plusOne(String s, int j){
        char[] ch = s.toCharArray();
        if(ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    //将s[j]向下拨动一次
    public String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if(ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    //单向BFS解决方法
    public int openLock1(String[] deadends, String target){

        //记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s: deadends) {
            deads.add(s);

        }

        //记录已经穷尽过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        //从起点开始广度优先搜索
        int setp = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()){
            int sz = q.size();

            //将当前队列中所有节点向周围扩散
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                // 判断是否未死亡密码
                if(deads.contains(cur))
                    continue;
                //判断是否到达终点
                if(cur.equals(target))
                    return setp;

                //将每一个节点的未遍历的相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            //增加步数
            setp++;

        }
        return -1;
    }


    //双向BFS解决方法 ，知道起点和终点，如果只知道起点，不知道终点，那就不能用双向BFS
    public int openLock2(String[] deadends, String target){
        Set<String> deads = new HashSet<>();

        for (String s: deadends){
            deads.add(s);
        }

        //用集合不用队列，可以加快判断元素是否存在

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()){

            //哈希集合在遍历过程中不能修改，用temp存储起来
            Set<String> temp = new HashSet<>();

            //将q1中所有节点向周围扩散
            for(String cur: q1){
                //判断是否达到终点
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);

                //将每一个节点的未遍历的相邻节点加入集合
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if(!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);

                }
            }
            //增加步数
            step++;

            //temp相当于q1
            //这里交换 q1 q2,下一轮while就是扩散q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        No752 No752 = new No752();
        String[] arrys = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(No752.openLock1(arrys,target));
        System.out.println(No752.openLock2(arrys,target));

    }
}
