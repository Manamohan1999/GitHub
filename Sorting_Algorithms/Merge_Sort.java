import java.util.Arrays;
public class Merge_Sort{
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));
 
        Merge_Sort ob = new Merge_Sort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(arr));
	}

	public void sort(int[] arr, int l, int r){
		if(l < r){
			//find the middle postion
			int m = (l+r)/2;

			//sort the first and second halve
			sort(arr, l, m);
			sort(arr, m+1, r);

			//merge the sorted halves
			merge(arr, l, m, r);
		}
	}
	public void merge(int[] arr, int l, int m, int r){
		//find the size of the two subarrays to be merged
		int n1 = m -l + 1;
		int n2 = r - m;

		//crete two temporary arrays
		int[] L = new int[n1];
		int[] R = new int[n2];

		//copy data to temp arrays
		for(int i = 0; i < n1; i++){
			L[i] = arr[l + i];
		}
		for(int j = 0; j < n2; j++){
			R[j] = arr[m + 1 + j];
		}

		//merge the temp arrays

		//initial index of two sub arrays
		int i = 0, j = 0;

		//initial index of merged subarray
		int k = l;
		while(i < n1 && j < n2){
			if(L[i] <= R[j]){
				arr[k++] = L[i++];
			}else{
				arr[k++] = R[j++];
			}
		}

		//copy remaining elemnts of L[] to the merged sunarray
		while(i < n1){
			arr[k++] = L[i++];
		}

		//copy remaining elemnts of R[] to the merged sunarray
		while(j < n2){
			arr[k++] = R[j++];
		}
	}
}