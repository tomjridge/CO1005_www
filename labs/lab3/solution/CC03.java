import java.util.*;


public class CC03 {

  List dupn(int i0) {
    List to_return = nil();
    int i = i0;
    while(true) {
      if (i<=0) return to_return;
      to_return = cons(i0,to_return);
      i=i-1;
    }
  }

  boolean list_equals(List l1, List l2) {
    while(true) {
      if(l1.isEmpty() && l2.isEmpty()) return true;
      if(l1.isEmpty() || l2.isEmpty()) return false;
      if(!hd(l1).equals(hd(l2))) return false;
      l1 = tl(l1);
      l2 = tl(l2);
    }
  }

  List upto(int i) {
    List to_return = nil();
    int j = 0;
    while(true) {
      if(j>=i) return to_return;
      to_return = append1(to_return,j);
      j=j+1;      
    }
  }

  List splice(List l1, List l2) {
    List r0 = nil();
    while(true) {
      if(l1.isEmpty()) return append(r0,l2);
      if(l2.isEmpty()) return append(r0,l1);
      r0 = append1(r0,hd(l1));
      r0 = append1(r0,hd(l2));
      l1 = tl(l1);
      l2 = tl(l2);
    }
  }

  boolean contains(Object obj, List l) {
    while(true) {
      if(l.isEmpty()) return false;
      if(obj.equals(hd(l))) return true;
      l=tl(l);
    }
  }

  
  List diff(List l1, List l2) {
    List r0 = nil();
    while(true) {
      if(l1.isEmpty()) return r0;
      if(!contains(hd(l1),l2)) r0 = append1(r0,hd(l1));
      l1 = tl(l1);
    }
  }

  // assume the strings are not equal
  boolean lexcompare(String s1, String s2) {
    while(true) {
      if(s1.equals("")) return true;
      if(s2.equals("")) return false;
      if(s1.charAt(0) < s2.charAt(0)) return true;
      if(s1.charAt(0) > s2.charAt(0)) return false;
      s1=s1.substring(1);
      s2=s2.substring(1);
    }
  }


  void print(Object s) {
    System.out.println(s.toString());
  }

  void print_list(List l) {
    print(list_to_string(l));
  }
  
  public void main() {
    print_list(dupn(3));
    print(list_equals(cons(1,nil()),cons(1,nil())));
    print_list(upto(3));

    List tmpl = cons(1,cons(2,cons(4,cons(5,nil()))));
    List tmph = cons("a",cons("b",cons("d",cons("e",nil()))));
    print_list(splice(tmpl,tmph));

    print_list(diff(tmpl,cons(2,cons(4,nil()))));
    
    print(lexcompare("dog","dogmatic"));
    print(lexcompare("cannot","cant"));
    print(lexcompare("dog","cat"));

  }

  public static void main(String[] args) {
    new CC03().main();
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
