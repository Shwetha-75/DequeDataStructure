package com.learn.dequedatastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	int size;

	private class Node {
		Item item;
		Node next;
	}

	Node first;
	Node last;

	public Deque() {

	}

	public void addFirst(Item item) {
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

	public void addLast(Item item) {
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

	public Item removeFirst() throws NoSuchElementException {
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

	public Item removeLast() throws NoSuchElementException
	{
		
		if(first!=null && last!=null && first==last)
		{
			Node temp=first;
			first=null;
			last=null;
			return temp.item;
			
		}
		
		if(first==null)
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
		
		public void remove()throws UnsupportedOperationException
		{
			 throw new UnsupportedOperationException();
		}
		private Node current = first;
		
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() throws UnsupportedOperationException
		{
			if(current==null)
			{
				throw new UnsupportedOperationException();
			}
			
			
			Item item = current.item;
			current = current.next;

			return item;
		}

	}

}
