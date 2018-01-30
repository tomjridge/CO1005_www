/*
  
  Insertion sort on integer lists.

*/

import java.util.*;

public class Intlist_isort {

  void print(Object s) {
    System.out.println(s.toString());
  }
  
  List insert(Integer i, List l0) {
    List to_return = nil();
    while(true) {
      if(l0.isEmpty()) return append1(to_return,i);
      Integer i2 = (Integer)(hd(l0)); // note cast!!!
      if(i>i2) { to_return = append1(to_return,i2); }
      else { return append(append1(to_return,i),l0); }
      l0=tl(l0);
    }
  }

  List ins_sort(List l0) {
    List to_return = nil();
    while(true) {
      if(l0.isEmpty()) return to_return;
      Integer i = (Integer)(hd(l0)); // note cast!!!
      to_return = insert(i,to_return);
      l0=tl(l0);
    }
  }


  void main() {
    print(insert(3,cons(1,cons(2,cons(4,cons(5,nil()))))));
    print(ins_sort(cons(5,cons(3,cons(4,cons(2,cons(1,nil())))))));
  }


  public static void main(String[] args) {
    new Intlist_isort().main();
  }
  
  
  //////////////////////////////////////////////////////////////////////
  // cons, nil etc are implemented below this line;
  // you can probably ignore what is below
  
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

  String list_to_string(List l) {
    String to_return ="[";
    while(true) {
      if(l.isEmpty()) return (to_return+"]");
      if(tl(l).isEmpty()) return (to_return+hd(l)+"]");
      to_return+=hd(l)+",";
      l=tl(l);
    }
  }


}
