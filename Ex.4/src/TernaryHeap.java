
public class TernaryHeap {
	int [] heap;
	int size;
	public TernaryHeap(int capacity) {
		 heap = new int [capacity+1];

	}

	private int right(int i) {
		return (3*i)+1;
			
	}

	private int left(int i) {
		return (3*i)-1;
		
	}

	private int mid(int i) {
		return (3*i);
		
	}

	private int parent(int i) {
		if((i+1)%3==0) {
			return (i/3)+1;
		}
		else {
			return i/3;
		}
	}

	public boolean insert(int k) {
		if(size+1==heap.length) {
			return false;
		}
		else {
			heap[size+1]=k;
			int check=size;
			while(check!=1) {
			if(heap[parent(check+1)]<heap[check+1]) {
				heap[check+1]=heap[parent(check+1)];
				heap[parent(size+1)]=k;
				check--;
			}
			
			}
			return true;
		}
	}
	

	public int remove_max() {
		if (size==0) {
			return Integer.MAX_VALUE;
		}
		else {
			int tmp=1;
			int max=heap[1];
			heap[1]=heap[size+1];
			size--;
			
			while(tmp<size) {
				if(right(tmp)>=mid(tmp) && right(tmp)>=left(tmp)) {
					int righttmp =right(tmp);
					int temptree =heap[righttmp];
					heap[tmp]=temptree;
					tmp=mid(tmp);
					
				}
		
				else if(size<right(tmp)) {
					int lefttmp=left(tmp);
					int temptree= heap[lefttmp];
					heap[tmp]=temptree;
					tmp=left(tmp);
				}
				else {
					return Integer.MAX_VALUE;
					
				}
			}
			return max;
		}		
	}
}