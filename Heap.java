public class Heap {
  int[] heap;
  int size;

  public Heap(int[] array) {
    this.heap = array;
    this.size = array.length;
    buildHeap();
  }

  public void buildHeap() {
    for(int i = size/2-1; i>=0; i--) {
      heapfy(i);
    }
  }

  public void heapfy(int index) {
    int left = left(index);
    int right = right(index);
    int largest = index;
    if (left < size && heap[left] > heap[index]) largest = left;
    if (right < size && heap[right] > heap[largest]) largest = right;
    if (largest != index) {
      swap(index, largest);
      heapfy(largest);
    }
  }

  public int left(int index) {
    return 2 * index + 1;
  }

  public int right(int index) {
    return 2 * index + 2;
  }

  public void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public int extractMax() {
    int max = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapfy(0);
    return max;
  }
}
