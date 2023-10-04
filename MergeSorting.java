public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = {5,2,14,5,74,16,8,81,100,0};
        MergeSort(arr);
        for(int a: arr) {
            System.out.println(a);
        }
    }
    public static void MergeSort(int[] arr){
        recMergeSort(arr, 0, arr.length - 1);
    }

    private static void recMergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            recMergeSort(arr, left, mid);
            recMergeSort(arr, mid + 1, right);

            mergeSortedArray(arr, left, mid, right);
        }
    }

    private static void mergeSortedArray(int[] sourceArr, int left, int mid, int right) {
        int[] leftSubArr = new int[mid - left + 1];
        int[] rightSubArr = new int[right - mid];

        System.arraycopy(sourceArr, left, leftSubArr, 0, leftSubArr.length); // copy arr[0...mid +1] to leftSubArr
        System.arraycopy(sourceArr, mid + 1, rightSubArr, 0, rightSubArr.length); // copy arr[mid + 1...right] to rightSubArr

        int i = 0, j = 0, k = left;
        while(i < leftSubArr.length && j < rightSubArr.length){
            if(leftSubArr[i] <= rightSubArr[j]){
                sourceArr[k++] = leftSubArr[i++];
            }else {
                sourceArr[k++] = rightSubArr[j++];
            }
        }

        //only one of this functions will work
        System.arraycopy(leftSubArr, i, sourceArr, k, leftSubArr.length - i); // if there are uncoppied elements in leftSubArray
        System.arraycopy(rightSubArr, j, sourceArr, k, rightSubArr.length - j);//if there are uncoppied elements in rightSubArray

    }
}
