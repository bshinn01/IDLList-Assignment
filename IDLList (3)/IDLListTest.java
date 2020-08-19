package HW3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDLListTest {
	
	IDLList<Integer> l = new IDLList<Integer>();
	
	@Test
	//add(elem)
	void testaddFirst1() {
		l.add(2);
		assertEquals(l.toString(), "[2]");
	}
	
	void testaddFirst2() {
		l.add(3);
		assertEquals(l.toString(), "[2,3]");
	}
	//add(index, elem)
	void testadd1() {
		l.add(0,0);
		assertEquals(l.toString(), "[0,2,3]");
	}
	
	void testadd2() {
		l.add(1, 1);
		assertEquals(l.toString(), "[0,1,2,3]");
	}
	//append(elem)
	void testappend1() {
		l.append(4);
		assertEquals(l.toString(), "[0,1,2,3,4]");
	}
	//get(index)
	void testget() {
		assertEquals(l.get(3), 3);
	}
	
	//getHead
	void testgetHead() {
		assertEquals(l.getHead(), 0);
	}
	
	//getLast
	void testgetLast() {
		assertEquals(l.getLast(), 4);
	}
	
	//remove()
	void testremove1() {
		l.remove();
		assertEquals(l.toString(), "[1,2,3,4]");
	}
	
	//removeLast()
	void testremoveLast() {
		l.removeLast();
		assertEquals(l.toString(), "[1,2,3]");
	}
	
	//testremoveAt(index)
	void testremoveAt1() {
		l.removeAt(1);
		assertEquals(l.toString(), "[1,3]");
	}
	
	void testremoveAt2() {
		l.removeAt(0);
		assertEquals(l.toString(), "[3]");
	}
	//remove(elem)
	void testremoveEle1() {
		l.remove(3);
		assertEquals(l.toString(), "[]");
	}
}
