
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
	// Attributes
	// Size
	private int size;
	// header of LL
	private Node first;
	// footer of LL
	private Node last;


	private class Node 
	{
		Item item;
		Node next;
	}

	
	public Deque() {

	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int size()
	{
		return size;
	}


	// insertion at the head
	public void addFirst(Item item) 
	{  
		
		if (item == null)
			throw new IllegalArgumentException();
		Node node = new Node();
		node.item = item;

		if (first == null) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}


	// insertion at footer
	public void addLast(Item item) 
	{
		if (item == null)
			throw new IllegalArgumentException();
		Node node = new Node();
		node.item = item;
		if (first == null) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;

		}
		size++;
	}

	
        // removes the first item
	public Item removeFirst() 
        {
		if (first != null) {
			Node node = first;
			first = first.next;
			node.next = null;
			size--;
			return node.item;
		} else {
			 throw new NoSuchElementException();
		}

	}

	// removes the last item
	public Item removeLast() 
	{
		
		if (first != null && last != null && first == last)
		{
			Node temp = first;
			first = null;
			last = null;
			size=0;
			return temp.item;
			
		}
		
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
		Node temp = first;
		while (temp.next.next != null) 
		{
			temp = temp.next;
		}
		Node deleted = temp.next;
		temp.next = null;
		last = temp;
		deleted.next = null;
		size--;
		return deleted.item;
		}
	}



	
	@Override
	public Iterator<Item> iterator() {

		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> 
	{
		
		public void remove()
		{
			 throw new UnsupportedOperationException();
		}
		private Node current = first;
		
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() 
		{
			if (current == null)
			{
				throw new NoSuchElementException();
			}
			
			
			Item item = current.item;
			current = current.next;

			return item;
		}

	}
	public static void main(String[] args) 
	{
		
		// testing
	}

}
