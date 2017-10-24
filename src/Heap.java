import java.util.Arrays;

public class Heap {
    int[] heap;
    int size;
    int capacity;

    public Heap() {
        this.heap = new int[10];
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

    double getMedian() {
        double median = 0;

        if (this.size == 0) throw new IllegalStateException();
        if (size % 2 > 0)
            median = this.heap[size / 2];
        else median = (double) (this.heap[size / 2] + this.heap[size / 2 - 1]) / 2;

        return median;
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
        for (int i = 0; i < this.heap.length; i++)
            System.out.print(this.heap[i] + ",");
        System.out.println();
    }


    public class Position {
        private int xCoord;
        private int yCoord;

        public int getxCoord() {
            return xCoord;
        }

        public void setxCoord(int xCoord) {
            this.xCoord = xCoord;
        }

        public int getyCoord() {
            return yCoord;
        }

        public void setyCoord(int yCoord) {
            this.yCoord = yCoord;
        }
    }

    public boolean comperTwo(Position[] prevArr, Position[] currArr) {
        if (prevArr.length != currArr.length)
            return false;
        else {
            for (int i = 0; i < prevArr.length; i++) {
                if (prevArr[i].getxCoord() != currArr[i].getxCoord() || prevArr[i].getyCoord() != currArr[i].getyCoord())
                    return false;
            }
        }
        return true;
    }
}

