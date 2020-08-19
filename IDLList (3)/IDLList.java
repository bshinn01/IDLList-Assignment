package HW3;

import java.util.ArrayList;
import java.util.Arrays;

public class IDLList<E> {
	
	public static class Node<E> {
		//data fields
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		//constructor
		public Node(E elem){
			super();
			this.data = elem;
			this.prev = null;
			this.next = null;
		}
		public Node(E elem, Node<E> prev, Node<E> next) {
			super();
			this.data = elem;
			this.next = next;
			this.prev = prev;
		}
	}
	//data fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	//constructors
	public IDLList() {
		head = null;
		tail = null;
		size = 0;
		this.indices = new ArrayList<Node<E>>();
	}
	//add methods
	public boolean add (int index, E elem) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("add: index is not in bounds");
		}
		if (head == null) {
			head = new Node<E>(elem);
			tail = head;
			this.indices.add(head);
			size++;
		}
		else {
			if (index == 0) {
				this.add(elem);
			}
			else if (index == size) {
				this.append(elem);
			}
			else {
				Node<E> current = this.indices.get(index-1);
				Node <E> newNode = new Node<E>(elem, current,current.next);
				current.next = newNode;
				current.next.next.prev = newNode;
				this.indices.add(index, newNode);
				size++;
				tail = this.indices.get(this.indices.size()-1);
			}
		}
		return true;
	}
	public boolean add(E elem) {
		if (head == null) {
			head = new Node<E>(elem);
			this.indices.add(0, head);
			size++;
			tail = head;
		}
		else {
			head = new Node<E>(elem, null, head);
			head.next.prev = head;
			this.indices.add(0, head);
			size++;
			tail = this.indices.get(this.indices.size()-1);
		}
		return true;
	}
	public boolean append(E elem) {
		if (head == null) {
			head = new Node<E>(elem);
			tail = head;
			this.indices.add(0, head);
		}
		else {
			tail.next = new Node<E>(elem);
			tail.next.prev = tail;
			tail = tail.next;
			this.indices.add(tail);
		}
		size++;
		return true;
	}
	
	//get methods
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("get: index is out of bounds");
		}
		else {
			return this.indices.get(index).data;
		}
	}
	
	public E getHead() {
		if (head == null) {
			throw new IllegalStateException("getHead: list is empty");
		}
		else {
			return this.indices.get(0).data;
		}
	}
	
	public E getLast() {
		if (head == null) {
			throw new IllegalStateException("getLast: list is empty");
		}
		else {
			return this.indices.get(indices.size()-1).data;
		}
	}
	
	public int size() {
		return this.indices.size();
	}
	
	
	//remove methods
	public E remove() {
		if (head == null) {
			throw new IllegalStateException("remove: list is empty");
		}
		else if (size == 1){
			//ADD CASE FOR LIST SIZE 1
			E temp = this.indices.get(0).data;
			head = null;
			tail = null;
			size--;
			indices.remove(0);
			return temp;
		}
		else {
			E temp = this.indices.get(0).data;
			head = head.next;
			head.prev = null;
			size--;
			this.indices.remove(0);
			tail = this.indices.get(this.indices.size()-1);
			return temp;
		}
	}
	
	public E removeLast () {
		if (head == null) {
			throw new IllegalStateException("removeLast: list is empty");
		}
		else if (size == 1){
			E temp = this.indices.get(0).data;
			this.remove();
			return temp;
		}
		E temp = this.indices.get(this.indices.size()-1).data;
		tail.prev.next = null;
		tail = tail.prev;
		this.indices.remove(this.indices.size()-1);
		size--;
		return temp;
	}
	
	public E removeAt(int index) {
		if (index < 0 || index > size) {
			throw new IllegalStateException("get: index is out of bounds");
		}
		else {
			if (index == 0 || size == 1) {
				return this.remove();
			}
			else if (index == size-1) {
				return this.removeLast();
			}
			else {
			Node<E> current = this.indices.get(index);
			current.prev.next = current.next;
			current.next.prev = current.prev;
			size--;
			E temp = this.indices.get(index).data;
			this.indices.remove(index);
			tail = this.indices.get(this.indices.size()-1);
			return temp;
			}
		}
	}
		
	public boolean remove(E elem) {
		if (head == null) {
			throw new IllegalStateException("remove: list is empty");
		}
		for (int i = 0; i<size; i++) {
			if (this.indices.get(i).data == elem) {
				this.removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	
	//toString
	public String toString() {
		if (size ==0) {
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		Node<E> current = head;
		s.append("[");
		while (current!=null) {
			s.append(current.data.toString()+",");
			current = current.next;
		}
		s.deleteCharAt(s.length()-1);
		s.append("]");
		return s.toString();
	}
		
	public static void main(String[] args) {
	}
}
