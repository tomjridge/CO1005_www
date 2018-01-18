import java.util.*;
// import java.util.List;



public class List_examples {

  void print(Object s) {
    System.out.println(s.toString());
  }

  
  // example reverse method
  List reverse(List s) {
    List to_return = nil();
    while(true) {
      if(s.isEmpty()) return to_return;
      to_return=cons(hd(s),to_return);
      s=tl(s);
    }
  }
  


  // example main method
  void main() {
    List tmpl = nil();
    tmpl=cons(1,cons(2,cons(4,cons(5,nil()))));
    print(list_to_string(tmpl));
    print(list_to_string(append(tmpl,tmpl)));
    print(list_to_string(reverse(cons(1,cons(2,cons(3,nil()))))));
    // etc
  }

  public static void main(String[] args) {
    new List_examples().main(); // run main functions
  }


  //////////////////////////////////////////////////////////////////////
  // cons, nil etc are implemented below this line;
  // you can probably ignore what is below
  
  // most of the following methods could/should be static

  // clone is protected, so we could subclass but...  

  // YOU ARE NOT ALLOWED TO USE THIS COPY FUNCTION!!! IT IS ONLY FOR
  // IMPLEMENTING cons ETC.
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
