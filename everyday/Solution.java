package everyday;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<String> res;
    int upCount = 0;
    int rightCount = 0;
    int upLen = 0;
    int rightLen = 0;

    public List<String> getAll(int n, int m){
        res = new ArrayList<>();
        upLen = n;
        rightLen = m;
        String[] flag = {"0","1"};

        backtrack("",flag);
        return res;
    }
    public void backtrack(String s, String[] flag){

        if((upCount == upLen -1) && (rightCount == rightLen - 1)){
            res.add(s);
            return;

        }

        for (int i = 0; i < 2; i++) {

            if(upCount > upLen -1 || rightCount > rightLen -1)
                continue;

            if(i==0){
                s = s + flag[i];
                upCount++;

                backtrack(s,flag);

                s = s.substring(0, s.length() - 1);
                upCount--;

            }
            if(i==1){
                s = s + flag[i];
                rightCount++;

                backtrack(s,flag);

                s = s.substring(0, s.length() - 1);
                rightCount--;

            }

        }

    }

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        Solution Solution = new Solution();
        List<String> res  = Solution.getAll(n, m);

        for (String s: res) {
            System.out.println(s);

        }
    }


}
