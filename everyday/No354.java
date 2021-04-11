package everyday;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class No354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;

        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }


    public static void main(String[] args) {

        //int[][] envelopes = {{5,4}, {6,4},{6,7}, {2,3}};
       // int[][] envelopes = {{5,1,7}, {4,2,6},{3,3,4}, {2,4,3}};
        int[][] envelopes = {{2,1}, {1,2},{1,3}, {1,4}};
        //No354 oo354 = new No354();
        //int nums = oo354.maxEnvelopes(envelopes);

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < envelopes.length; i++){
            System.out.print(envelopes[i][0]);
            System.out.print(envelopes[i][1]);

            System.out.println();
        }

    }
}
