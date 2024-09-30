import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {1,3442,131,3,4,1,3,2,3,132,5,1340304,235,13,5,1,522323,125,24,1};
        int[] helper = new int[array.length];

        mergeSort(array,helper,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }


    public static void mergeSort(int[] array,int[] helper,int low,int high){

        if(low < high){
            int middle = (low + high) / 2;
            mergeSort(array,helper,low,middle); // for left part
            mergeSort(array,helper,middle+1,high);
            merge(array,helper,low,middle,high);
        }

    }

    public static void merge(int[] array,int[] helper,int low,int middle,int high){

        for(int i = low;i<=high;i++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;


        while(helperLeft <= middle && helperRight <= high){

            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }else {
                array[current] = helper[helperRight];
                helperRight++;
            }

            current++;
        }

        int remaining = middle - helperLeft;

        for(int i = 0;i<=remaining;i++){
            array[current + i] = helper[helperLeft + i];
        }

    }
}