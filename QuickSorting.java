public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = {5,2,14,5,74,16,8,81,100,0};
        QuickSort(arr);
        for(int a: arr) {
            System.out.println(a);
        }
    }

    private static void QuickSort(int[] arr) {
        recQSort(arr, 0, arr.length - 1);
    }

    private static void recQSort(int[] arr, int left, int right) {
        if(left < right) {
            int pivot = getPivotIndex(arr, left, right);

            recQSort(arr, left, pivot - 1);
            recQSort(arr, pivot + 1, right);
        }
    }

    private static int getPivotIndex(int[] arr, int left, int right) {
        int pivot = arr[right];
        int j = left;
        for(int i = left; i < right; ++i) {
            if(arr[i] < pivot) {
                swap(arr, i, j);
                ++j;
            }
        }
        swap(arr, right, j);
        return j;
    }

    private static void swap(int[] arr, int lhs, int rhs) {
        int temp = arr[lhs];
        arr[lhs] = arr[rhs];
        arr[rhs] = temp;
    }
}

