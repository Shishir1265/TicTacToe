public class learn {

    public static int[] bs (int[] arr ) {
        int l = arr.length;
        for (int p = 1; p<=l-1; p++) {
            int flag = 0;
            for (int i = 0; i<=l-2; i++) {
                if (arr[i]> arr[i+1]) {
                    swap(i,i+1,arr);
                    flag++;
                }
            }
            if (flag==0) break;
        }
        return arr;
    }

    private static void swap (int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;        
    }
    public static void main(String[] args) {
        int arr[] = {40,20,60,10,30};
        bs(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
