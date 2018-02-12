import java.util.*;


public class CC04 {
  
  List inter(List l1, List l2) {
    Set s = new HashSet(l1);
    List to_ret = nil();
    while(true) {
      if (l2.isEmpty()) return to_ret;
      Object o = hd(l2);
      if (s.contains(o)) to_ret=append1(to_ret,o);
      l2 =  tl(l2);
    }
  }


  char aux(String s, Map m) {
    while(true) {
      if(s.equals("")) return 'a';
      char c = s.charAt(0);
      Integer i = (Integer)(m.get(c));
      if (i==1) return c;
      s=s.substring(1);
    }
  }

  char first_non_repeated(String s0) {
    Map m = new HashMap();
    String s = s0;
    while(true) {
      if(s.equals("")) return aux(s0,m);
      char c = s.charAt(0);
      Integer i = (Integer)(m.get(c));
      if (i==null) { m.put(c,1); } else m.put(c,i+1);
      s=s.substring(1);
    }
  }

  boolean well_bracket(String s) {
    Stack stk = new Stack();
    while(true) {
      if(s.equals("")) {
        if (stk.isEmpty()) return true; else return false;
      }
      char c = s.charAt(0);
      if (c=='(' || c=='[') {
        stk.push(c);
      }
      if (c==')') {
        if (stk.isEmpty()) return false;
        if (!(stk.pop().equals('('))) return false;
      }
      if (c==']') {
        if (stk.isEmpty()) return false;
        if (!(stk.pop().equals('['))) return false;
      }
      s=s.substring(1);
    }
  }









  // List functions ----------------------------------------

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
