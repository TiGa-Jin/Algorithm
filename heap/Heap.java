package heap;

public class Heap {

    //上浮
    public int[] swim (int[] arrays){

        for (int i = arrays.length / 2 ; 0 <= i; i--) {
            int indx = i;
            while (indx > 0 && arrays[indx / 2 + 1] > arrays[indx]){
                int temp = arrays[indx / 2 + 1];
                arrays[indx / 2 + 1] = arrays[indx];
                arrays[indx] = temp;
                indx = indx / 2 + 1;
            }
        }
        return arrays;

    }
    //下沉
    public int[] sink(int[] arrays){

        for (int i = arrays.length -1 ; 0 <= i; i--) {
            int indx = i;
            while (indx > 0 && arrays[indx / 2] > arrays[indx]){
                int temp = arrays[indx / 2];
                arrays[indx / 2] = arrays[indx];
                arrays[indx] = temp;
                indx = indx / 2;
            }
        }
        return arrays;

    }
    public static void main(String[] args) {
        int[] arrays = {2,3,5,6,7,9,12,11,8,1};
        Heap heap = new Heap();
        int[] res = heap.swim(arrays);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
