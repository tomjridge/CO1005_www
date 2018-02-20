import java.util.*;

public class Quicksort {

  int length(List l) {
    int to_return =0;
    while(true) {
      if(l.isEmpty()) return to_return;
      l=tl(l);
      to_return++;
    }
  }

  public List less_than(List l, int n) {
    List to_return = nil();
    while(true) {
      if(l.isEmpty()) return to_return;
      Integer i = (Integer)(hd(l));
      if(i<n) { to_return = append1(to_return,i); }
      l=tl(l);
    }
  }

  public List greater_than(List l, int n) {
    List to_return = nil();
    while(true) {
      if(l.isEmpty()) return to_return;
      Integer i = (Integer)(hd(l));
      if(i>n) { to_return = append1(to_return,i); }
      l=tl(l);
    }
  }

  List quicksort(List l) {
    if(length(l) == 0) return l; // already sorted
    if(length(l) == 1) return l; // already sorted
    int n = (Integer)(hd(l));
    List l1 = less_than(l,n);
    List l2 = greater_than(l,n);
    l1 = quicksort(l1);
    l2 = quicksort(l2);
    return append(append1(l1,n),l2);
  }

  void print(String s) {
    System.out.println(s);
  } 

  void main() { 
    List l123=cons(99,cons(2,cons(3,nil())));
    List l456=cons(4,cons(100,cons(6,nil())));
    List l456123 = append(l456,l123);
    print(asString(l456123));
    print(asString(quicksort(l456123)));
  }

  public static void main(String[] args) {
    new Quicksort().main(); // run main functions
  }



  //////////////////////////////////////////////////////////////////////
  // ALLLIST

  // most of the following methods could/should be static

  // clone is protected, so we could subclass but...  YOU ARE NOT
  // ALLOWED TO USE THIS FUNCTION!!! IT IS ONLY FOR IMPLEMENTING cons
  // ETC.
  List copy(List l0) {
    List to_return = new LinkedList();
    for(int i=0; i<l0.size(); i++) {
      to_return.add(i,l0.get(i));
    }
    return to_return;
  }

  // the empty list
  List nil() {
    return new LinkedList();
  }

  // add at front of list
  List cons(Object o, List l0) {
    List l = copy(l0);
    l.add(0,o);
    return l;
  }


  // head of the list
  Object hd(List l) { return l.get(0); }

  // tail of the list
  List tl(List l0) {
    List l = copy(l0);
    l.remove(0);
    return l;
  }

  // add at end of list
  List append1(List l0, Object o) {
    List l = copy(l0);
    l.add(l.size(),o);
    return l;
  }

  // join two lists together
  List append(List l01, List l02) {
    List to_return = copy(l01);
    List l2 = copy(l02);

    while(true) {
      if(l2.isEmpty()) return to_return;
      to_return=append1(to_return,hd(l2));
      l2=tl(l2);
    }

  }

  // for debugging
  String asString(List l) {
    String to_return ="[";
    while(true) {
      if(l.isEmpty()) return (to_return+"]");
      if(tl(l).isEmpty()) return (to_return+hd(l)+"]");
      to_return+=hd(l)+",";
      l=tl(l);
    }
  }


}
