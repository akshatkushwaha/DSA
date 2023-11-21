interface MaxHeapInterface {
    public void insert(int x);

    public int popMax();

    public int getMax();

    public int size();

    public boolean isEmpty();

    public void print();

}

public class Wallmart implements MaxHeapInterface {
    private int[] heap;
    private int size;
    private int maxSize;
    private int x;

    public Wallmart(int x) {
        this.x = x;
        this.size = 0;
        this.maxSize = (int) Math.pow(2, x) - 1;
        this.heap = new int[maxSize];
    }

    public void insert(int x) {
        if (size == maxSize) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = x;
        size++;
        heapifyUp(size - 1);
    }

    public int popMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public int getMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / x;
        if (index > 0 && heap[parent] < heap[index]) {
            swap(parent, index);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int max = index;
        for (int i = 1; i <= x; i++) {
            int child = x * index + i;
            if (child < size && heap[child] > heap[max]) {
                max = child;
            }
        }
        if (max != index) {
            swap(max, index);
            heapifyDown(max);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Wallmart heap = new Wallmart(3);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);

        heap.print();
        System.out.println(heap.popMax());

        heap.print();
        System.out.println(heap.getMax());
    }
}