import java.util.*;
public class HeapMain {
    public static void main(String[] args) {
        // Create a random set of data to test the program on 
        int[] data = {3, 7, 4, 5, 2, 9, 8, 1, 6};

        // Make an empty list of nodes that represents the heap 
        List<TreeNode<Integer>> heap = new LinkedList<TreeNode<Integer>>();
        // Add the random data as nodes to the heap
        for (int i=0; i<data.length; i++) {
            if(i==0) { // If this is the first one, add it as the root node 
                TreeNode<Integer> rootNode = new TreeNode<Integer> (data[i]); 
                heap.add(rootNode);
            }
            else { // Otherwise, add this data value as a child node
                int parentIndex = (i-1)/2;
                TreeNode<Integer> parentNode = heap.get(parentIndex);
                TreeNode<Integer> childNode = new TreeNode<Integer>(data[i], parentNode); 
                heap.add(childNode);
            }
        }

        System.out.println("Rand Heap: "+ heap); // Print out the heap to check if all the nodes were added
        buildMaxHeap(heap); // Call build max heap to reorganize the heap into a max heap
        System.out.println("Max Heap: "+ heap); // Print out the heap to check if it is a correct max heap 
        heapSort(heap); // call heap sort to sort the data from least to greatest
        System.out.println("Sorted: " + heap); // print out the heap to chek if it is sorted correctly
    }

    public static void buildMaxHeap(List<TreeNode<Integer>> heap){
        for(int i = heap.size()-1; i>=0; i--){
            siftDownMax(heap,i,heap.size());
        }
    }

    public static void siftDownMax(List<TreeNode<Integer>> heap,int index, int considered){
        int rightIndex = index*2+2;
        int leftIndex = index*2+1;
        
        if(rightIndex < considered){

            if(heap.get(rightIndex).getData() > heap.get(leftIndex).getData() && heap.get(rightIndex).getData() > heap.get(index).getData()){ // if right is bigger then left and right is bigger then parent
                Integer temp = heap.get(rightIndex).getData();
                heap.get(rightIndex).setData(heap.get(index).getData());
                heap.get(index).setData(temp);
                siftDownMax(heap, rightIndex, considered);
            } else if(heap.get(leftIndex).getData() > heap.get(index).getData()){ // if left is bigger then right and left is bigger then parent 
                Integer temp = heap.get(leftIndex).getData();
                heap.get(leftIndex).setData(heap.get(index).getData());
                heap.get(index).setData(temp);
                siftDownMax(heap, leftIndex, considered);
            }
        } else if(leftIndex < considered && heap.get(leftIndex).getData() > heap.get(index).getData()){
            Integer temp = heap.get(leftIndex).getData();
                heap.get(leftIndex).setData(heap.get(index).getData());
                heap.get(index).setData(temp);
                siftDownMax(heap, leftIndex, considered);
        } 
    }

    public static void heapSort(List<TreeNode<Integer>> heap){
        int considered = heap.size();
        for(int i = considered; considered > 0; i-= 0){
            Collections.swap(heap, 0, considered-1);
            considered--;
            siftDownMax(heap,0,considered);
        }
    }
}