// generic typed list operations ----------------------------------------

import java.util.*;

public class List_ops<E> {
  
  List<E> copy(List<E> l0) {
    List<E> to_return = new LinkedList<E>();
    for(int i=0; i<l0.size(); i++) {
      to_return.add(i,l0.get(i));
    }
    return to_return;
  }

  // the empty list
  List<E> nil() {
    return new LinkedList<E>();
  }

  // add at front of list
  List<E> cons(E o, List<E> l0) {
    List<E> l = copy(l0);
    l.add(0,o);
    return l;
  }


  // head of the list
  E hd(List<E> l) { return l.get(0); }

  // tail of the list
  List<E> tl(List<E> l0) {
    List<E> l = copy(l0);
    l.remove(0);
    return l;
  }

  // add at end of list
  List<E> append1(List<E> l0, E o) {
    List<E> l = copy(l0);
    l.add(l.size(),o);
    return l;
  }

  // join two lists together
  List<E> append(List<E> l01, List<E> l02) {
    List<E> to_return = copy(l01);
    List<E> l2 = copy(l02);
    while(true) {
      if(l2.isEmpty()) return to_return;
      to_return=append1(to_return,hd(l2));
      l2=tl(l2);
    }
  }

  // for debugging
  String asString(List<E> l) {
    String to_return ="[";
    while(true) {
      if(l.isEmpty()) return (to_return+"]");
      if(tl(l).isEmpty()) return (to_return+hd(l)+"]");
      to_return+=hd(l)+",";
      l=tl(l);
    }
  }

}

