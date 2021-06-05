
package sortingtec;




import java.util.Random;
import java.util.concurrent.TimeUnit;



public class SortingTec {

final static int x[]=genrate(10);
final static int y[]=genrate(100);
final static int c[]=genrate(1000);
final static int v[]=genrate(10000);
final static int b[]=genrate(100000);

  public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for(int k =0;k<n-1;k++){
            for(int j =0;j<n-k-1;j++)
            {
               if(arr[j]>arr[j+1])
                {
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
        
    }
      public static int [] genrate(int n){
        Random rd = new Random();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rd.nextInt(10000);
         
                  
      }
         
       return arr ;
   }
      
          
    public static void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        for (int i=n-1; i>=0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0); 
        } 
    } 
  
   
    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2; 
  
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            heapify(arr, n, largest); 
        } 
    }
    
    
        
    public static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    public static void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
  
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
  
            merge(arr, l, m, r); 
        } 
    } 
    
    
    
    
   public static void printArray(int[] arr)
{
    int size=arr.length;
    for(int i = 0; i < size; i++)
        System.out.print(arr[i] + " ");
         
    System.out.println();
}
    
    
    
    
   public static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
 
public static int partition(int[] arr, int low, int high)
{
     
    
    int pivot = arr[high];
     
  
    int i = (low - 1);
 
    for(int j = low; j <= high - 1; j++)
    {
         
       
        if (arr[j] < pivot)
        {
             
           
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}
 

static void quickSort(int[] arr, int low, int high)
{
    if (low < high)
    {
         
       
        int pi = partition(arr, low, high);
 

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
    
    
    
    
    
    
    
         public static void InsertionSort(int arr1[])
    {
        int n = arr1.length;
        for (int i = 1; i < n; ++i) {
            int key = arr1[i];
            int j = i - 1;
 
           
            while (j >= 0 && arr1[j] > key) {
                arr1[j + 1] = arr1[j];
                j = j - 1;
            }
            arr1[j + 1] = key;
        }
        
    }
    
    
    
    
    
    
    
    

 
   public static  void SelectionSort(int arr[])
    {
        int n = arr.length;
  
      
        for (int i = 0; i < n-1; i++)
        {
          
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
  
            
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    
   
   
   
  public static void show(int n){
     
     
   
      System.out.println("size of "+n+"array :");
      
    double start1 = System.nanoTime();
    quickSort(genrate(n),0,n-1);
    double stop1 = System.nanoTime(); 
    double sec=(stop1-start1)/1000000;
    System.out.println("quickSort time="+sec);
    
      
    double start2 = System.nanoTime();
    heapSort(genrate(n));
    double stop2 = System.nanoTime(); 
    double sec2=(stop2-start2)/1000000;
    System.out.println("heapSort time="+sec2);

    double start3 = System.nanoTime();
    mergeSort(genrate(n), 0, n-1);
    double stop3 = System.nanoTime(); 
    double sec3=(stop3-start3)/1000000;
    System.out.println("mergeSort time="+sec3);

      
    double start4 = System.nanoTime();
    InsertionSort(genrate(n));
    double stop4 = System.nanoTime(); 
    double sec4=(stop4-start4)/1000000;
    System.out.println("InsertionSort time="+sec4);


    double start5 = System.nanoTime();
    SelectionSort(genrate(n));
    double stop5 = System.nanoTime(); 
    double sec5=(stop5-start5)/1000000;
    System.out.println("SelectionSort time="+sec5);


    double start6 = System.nanoTime();
    bubbleSort(genrate(n));
    double stop6 = System.nanoTime(); 
    double sec6=(stop6-start6)/1000000;
    System.out.println("bubbleSort time="+sec6);
   
   
   
            }
   
   
    public static void main(String[] args) {
   


        show(10);
        show(100);
        show(1000);
        show(10000);
        show(100000);
       
       
   



    }
    
}
