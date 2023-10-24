//13. How do you reverse a linked list in Java?
import java.util.Scanner;
import java.util.ArrayList;
class Reverselist{
	Node head,temp,current,dnext,dhold;
	boolean flag = false;
	class Node{
		int data;
		Node next;
	}
	void setData(int input){
		Node n1 = new Node();
		if(head==null){
			n1.data = input;
			n1.next = head;
			head = n1;
			temp = n1;
		}else{
			n1.data = input;
			n1.next = temp.next;
			temp.next = n1;
			temp = n1;
		}
	}
	void show(){
		temp = head;
		while(temp != null){
			System.out.print(" "+temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	Node deleteNode(int item){
		if(head.data == item){
			head = head.next;
			return head;
		}else{
			dnext = head.next;
			dhold = head;
			while(dhold.next != null){
				if(dnext.data==item){
					dhold.next = dnext.next;
					flag = true;
					break;
				}else{
					dnext = dnext.next;
					dhold = dhold.next;
				}
			}
			if(flag==false){
					System.out.println("Element not found:");
			}	
		}
		return head;
	}
	void reverseLL(){
		Node next = null;
		Node previous = null;	
		Node current = head;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;		
		}
		head = previous;
	}
	void insertIntoMid(int findItem,int insertItem){
		dnext = head;
		while(dnext.data != findItem){
			dnext = dnext.next;
		}
		if(dnext.data == findItem){
			dhold = dnext.next;
			Node n1 = new Node();
			n1.data = insertItem;
			n1.next = dhold;
			dnext.next = n1;
		}else{
			System.out.println("element not found");
		}
	}
	void deleteDub(ArrayList<Integer> arrlist){
		dnext = head;
		dhold = head;
		while(dnext != null){
			if(arrlist.contains(dnext.data)){
				dhold.next = dnext.next;
				dnext = dnext.next;
			}else{
				arrlist.add(dnext.data);
				dhold = dnext;
				dnext = dnext.next;
			}
		}
	}
	
	
}
class Mainofll{
	public static void main(String[] args){
		Reverselist rl = new Reverselist();
		Scanner scr = new Scanner(System.in);
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		System.out.print("how many elements want to insert: ");
		int input = scr.nextInt();
		for(int i = 1; i<=input;i++){
			System.out.print("enter no. for "+i+" position: ");
			int num = scr.nextInt();
			rl.setData(num);
		}
		rl.show();
		/*System.out.println("which element want to delete? :");
		int delNode = scr.nextInt();
		System.out.println(rl.deleteNode(delNode));
		rl.show();
		System.out.println("After deleted element");
		rl.reverseLL();
		rl.show();
		System.out.println("After reverse list:");
		System.out.println("after which Node want to insert");
		int findNum = scr.nextInt();
		System.out.print("Enter new element for new Node: ");
		int newNum = scr.nextInt();
		rl.insertIntoMid(findNum,newNum);
		rl.show();
		*/
		rl.deleteDub(arrlist);
		rl.show();
		
	}
}