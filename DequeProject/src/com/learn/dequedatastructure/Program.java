package com.learn.dequedatastructure;

import java.util.Iterator;

public class Program 
{
	public static void main(String[] args) 
	{
		Deque<String> queue=new Deque<String>();
		
		queue.addFirst("Good");
		queue.addFirst("Evening");
		queue.addLast("Shwetha");
		queue.addFirst("Have a nice day");
		queue.addFirst("stick on to your goals");
		
		queue.removeLast();
		queue.removeLast();
		queue.removeLast();
		queue.removeLast();
		queue.removeLast();
		queue.removeLast();
     	Iterator<String> itr=queue.iterator();
		
   	    while(itr.hasNext())
	    {
			System.out.println(itr.next());
		}
		
	}

}
