public class Q2_binarySearch {

    public static int binarySearch(int [] arr, int key){
        int high = arr.length-1;
        int low = 0;
        while(low<=high){
            int mid =(high+low)/2;

            if(arr[mid]==key){
                System.out.println("Element " + key + " found at index " + mid );
                return mid;
            }else if(arr[mid]<key){
                low=mid+1;
            }else{
                high = mid -1;
            }
        }
        System.out.println("Element " + key + " not found (Iterative)");
        return -1;
    }

    public static void main(String[] args) {

        int[] sortedArr = {1,2,3,4,5,6,7,8,9};
        int key =7;

        int result = binarySearch(sortedArr, key);
        System.out.println("Binary search result : "+result);
        
    }
    
}
