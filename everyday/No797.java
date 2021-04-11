package everyday;

import java.util.*;
public class No797 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }
    public void traverse(int[][] graph, int s, LinkedList<Integer> path){

        path.addLast(s);//添加节点s到路径

        int n = graph.length;//二维数组得行数，也就是节个数

        if(s == n - 1){
            //到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //递归地遍历每个相邻节点
        for(int i: graph[s]){
            traverse(graph, i, path);
        }

        //从路径移除节点S
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        No797 solution = new No797();
        List<List<Integer>> res = solution.allPathsSourceTarget(graph);
        for(List<Integer> path: res){
            for (int i: path){
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println();

        }
    }

}
