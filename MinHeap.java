public class MinHeap {
    private Device[] Heap;
    private int size;
    private int maxsize;
    private int original_size;

    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize * 2;
        this.original_size = maxsize;
        this.size = 1;
        Heap = new Device[this.maxsize + 1];
        for (int i = 0; i < original_size; i++) {
            Heap[i] = new Device("", "", "",Integer.MAX_VALUE ,Double.MAX_VALUE);
        }
    }

    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    private void swap(int fpos, int spos) {
        Device tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void minHeapify(int pos) {
        if (!isLeaf(pos) && Heap[pos].getPrice() > Heap[leftChild(pos)].getPrice()
                || Heap[pos].getPrice() > Heap[rightChild(pos)].getPrice()) {
            if (Heap[leftChild(pos)].getPrice() < Heap[rightChild(pos)].getPrice()) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }

    }
    public void insert(Device item) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = item;
        int current = size;
        while (Heap[parent(current)] == null || Heap[current].getPrice() < Heap[parent(current)].getPrice()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public Device remove() {
        if (isEmpty()) {
            return null;
        }
        Device popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
}
