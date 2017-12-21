
import java.lang.reflect.Array;
import java.util.*;


// is not Done
public class Find_Running_Median {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        MinHeap minHeap = new MinHeap(n);
        MaxHeap maxHeap = new MaxHeap(n);
        for(int a_i=0; a_i < n; a_i++){
            int s = in.nextInt();
            minHeap.add(s);
            maxHeap.add(s);
            double max = maxHeap.peek();
            double min = minHeap.peek();
            System.out.println(Arrays.toString(minHeap.heap));
            System.out.println(Arrays.toString(maxHeap.heap));
            if(maxHeap.size%2==0)
                System.out.println((max + min) / 2);
            else
                System.out.println((double) minHeap.heap[Math.round(minHeap.size/2)]);
        }
    }
    public static class MinHeap {
        int[] heap;
        int size;
        int capacity;

        public MinHeap(int maxSize) {
            this.heap = new int[maxSize];
            this.size = 0;
            this.capacity = 10;
        }

        private int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        private int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 2) / 2;
        }

        private boolean hasLeftChild(int parentIndex) {
            return getLeftChildIndex(parentIndex) < size;
        }

        private boolean hasRightChild(int parentIndex) {
            return getRightChildIndex(parentIndex) < size;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private int getLeftChild(int parentIndex) {
            return this.heap[getLeftChildIndex(parentIndex)];
        }

        private int getRightChild(int parentIndex) {
            return this.heap[getRightChildIndex(parentIndex)];
        }

        private int getParent(int index) {
            return this.heap[getParentIndex(index)];
        }

        private void swap(int indexOne, int indexTwo) {
            int temp = this.heap[indexOne];
            this.heap[indexOne] = this.heap[indexTwo];
            this.heap[indexTwo] = temp;
        }

        private void ensureExtraCapacity() {
            if (this.size + 1 == this.capacity) {
                this.heap = Arrays.copyOf(this.heap, capacity * 2);
                capacity *= 2;
            }
        }

        int peek() {
            if (this.size == 0) throw new IllegalStateException();
            return this.heap[0];
        }

        void add(int item) {
            ensureExtraCapacity();
            this.heap[size] = item;
            size++;
            heapUp();
        }


        int remove() {
            if (this.size == 0) throw new IllegalStateException();
            int top = this.heap[0];
            this.heap[0] = this.heap[size - 1];
            size--;
            heapDown();
            return top;
        }

        private void heapDown() {
            if (this.size == 0) throw new IllegalStateException();
            int index = 0;
            while (hasLeftChild(index)) {
                int smallIndex = getLeftChildIndex(index);
                if (this.heap[getLeftChildIndex(index)] > this.heap[getRightChildIndex(index)])
                    smallIndex = getRightChildIndex(index);
                swap(index, smallIndex);
                index = smallIndex;
            }
        }

        private void heapUp() {
            if (this.size == 0) throw new IllegalStateException();
            int index = this.size - 1;
            while (getParentIndex(index) >= 0 && this.heap[index] < this.heap[getParentIndex(index)]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }

        public void print() {
            Arrays.stream(this.heap).mapToObj(i1 -> i1 + ",").forEach(System.out::print);
            System.out.println();
        }
    }

    public static class MaxHeap {
        int[] heap;
        int size;
        int capacity;

        public MaxHeap(int maxSize) {
            this.heap = new int[maxSize];
            this.size = 0;
            this.capacity = 10;
        }

        private int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        private int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 2) / 2;
        }

        private boolean hasLeftChild(int parentIndex) {
            return getLeftChildIndex(parentIndex) < size;
        }

        private boolean hasRightChild(int parentIndex) {
            return getRightChildIndex(parentIndex) < size;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private int getLeftChild(int parentIndex) {
            return this.heap[getLeftChildIndex(parentIndex)];
        }

        private int getRightChild(int parentIndex) {
            return this.heap[getRightChildIndex(parentIndex)];
        }

        private int getParent(int index) {
            return this.heap[getParentIndex(index)];
        }

        private void swap(int indexOne, int indexTwo) {
            int temp = this.heap[indexOne];
            this.heap[indexOne] = this.heap[indexTwo];
            this.heap[indexTwo] = temp;
        }

        private void ensureExtraCapacity() {
            if (this.size + 1 == this.capacity) {
                this.heap = Arrays.copyOf(this.heap, capacity * 2);
                capacity *= 2;
            }
        }

        int peek() {
            if (this.size == 0) throw new IllegalStateException();
            return this.heap[0];
        }

        void add(int item) {
            ensureExtraCapacity();
            this.heap[size] = item;
            size++;
            heapUp();
        }


        int remove() {
            if (this.size == 0) throw new IllegalStateException();
            int top = this.heap[0];
            this.heap[0] = this.heap[size - 1];
            size--;
            heapDown();
            return top;
        }

        private void heapDown() {
            if (this.size == 0) throw new IllegalStateException();
            int index = 0;
            while (hasLeftChild(index)) {
                int smallIndex = getLeftChildIndex(index);
                if (this.heap[getLeftChildIndex(index)] < this.heap[getRightChildIndex(index)])
                    smallIndex = getRightChildIndex(index);
                swap(index, smallIndex);
                index = smallIndex;
            }
        }

        private void heapUp() {
            if (this.size == 0) throw new IllegalStateException();
            int index = this.size - 1;
            while (getParentIndex(index) >= 0 && this.heap[index] > this.heap[getParentIndex(index)]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }


    }
}
