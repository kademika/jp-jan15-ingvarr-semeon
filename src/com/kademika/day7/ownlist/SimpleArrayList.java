package com.kademika.day7.ownlist;

public class SimpleArrayList {
	private Object[] elements;
	private int size = 0;
	
	public SimpleArrayList() {
		this.elements = new Object[10];
	}
	
    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
    }
    
    public void add(Object element) {
    	ensureCapacity(size + 1);
    	elements[size++] = element;
    }
    
    public void add(int index, Object element) {
    	ensureCapacity(size + 1);
    	System.arraycopy(elements, index, elements, index + 1, size - index);
    	elements[index] = element;
    	size++;
    }
    
    public void ensureCapacity(int requiredCapacity) {
    	if (requiredCapacity > elements.length) {
    		Object[] oldData = new Object[elements.length];
    		System.arraycopy(elements, 0, oldData, 0, elements.length);
    		Object[] newData = new Object[oldData.length * 3 / 2 + 1];
    		System.arraycopy(oldData, 0, newData, 0, oldData.length);
    		elements = newData;
    	}
    }
    
    public void remove(int index) {
    	int qtyMoved = elements.length - index - 1;
    	System.arraycopy(elements, index + 1, elements, index, qtyMoved);
    	size--;
    }
    
    public void remove(Object element) {
    	for (int i = 0; i < elements.length; i++) {
    		if (elements[i] == element) {
    			remove(i);
    			return;
    		}
    	}
    	System.out.println("Required element is absent");
    }
    
	public void printList() {
		if (size == 0) {
			System.out.println("List is empty");
		}
		
		System.out.print("[");
		int length = elements.length - 1;
		for (int i = 0; i < length; i++) {
			System.out.print(elements[i] + ", ");	
		}
		System.out.println(elements[length] + "]");
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
