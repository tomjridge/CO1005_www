import java.util.*;

// first methods are from AllList; the sorting stuff comes after

public class AllSort {



  ////////////////////////////////////////////////////////////////////////////////
  // ALLSORT

  class Person {
    String first = "";
    String last = "";
    public Person(String f, String l) { first=f; last=l; }
    public String toString() { return first+" "+last; }
  }

  void main() {
    List tmph, tmpj, tmpk, tmpl;
    final Comparator c,d,e,f,g,h; // N.B. why final?
    Person alf,bert,charlie;

    tmpl = cons(1,cons(3,cons(4,cons(2,nil()))));

    tmph = copy(tmpl);

    Collections.sort(tmph); // this sorts in place! tmph is changed!!!

    c = new Comparator() {
        public int compare(Object o1, Object o2) {
          boolean b1 = o1.getClass().equals(Integer.class);
          boolean b2 = o2.getClass().equals(Integer.class);
          if(b1 && b2) {
            return ((Integer)o1).intValue() - ((Integer)o2).intValue();
          }
          return 0; // should really throw an exception - don't expect
                    // to be called on non-Integers
        }
      };

    c.compare(new Integer(2),new Integer(3));
    c.compare(new Integer(5),new Integer(1));

    tmph = copy(tmpl);

    Collections.sort(tmph,c);

    d = new Comparator() {
        public int compare(Object o1, Object o2) {
          return (-1) * c.compare(o1,o2);
        }
      };

    tmph = copy(tmpl);

    Collections.sort(tmph,d);

    // some more examples


    tmpk = cons("bert",cons("charlie",cons("alf",nil())));

    tmph = copy(tmpk);

    Collections.sort(tmph);

    e = new Comparator() {
        public int compare(Object o1, Object o2) {
          boolean b1 = o1.getClass().equals(String.class);
          boolean b2 = o2.getClass().equals(String.class);
          if(b1 && b2) {
            return ((String)o1).compareTo((String)o2);
          }
          return 0; // should really throw an exception - don't expect
                    // to be called on non-Integers
        }
      };

    e.compare("bert","alf");

    tmph = copy(tmpk);

    Collections.sort(tmph,e);

    f = new Comparator() {
        public int compare(Object o1, Object o2) {
          return (-1) * e.compare(o1,o2);
        }
      };

    tmph = copy(tmpk);

    Collections.sort(tmph,f);

    // example using our own class!
    alf = new Person("alf","michaels");
    bert = new Person("bert", "koala");
    charlie = new Person("charlie", "pickens");

    tmpj = cons(bert,cons(charlie,cons(alf,nil())));

    tmph = copy(tmpj);

    //Collections.sort(tmph); // this would throw an exception

    // sort on first name
    g = new Comparator() {
        public int compare(Object o1, Object o2) {
          String a = ((Person)o1).first;
          String b = ((Person)o2).first;
          return a.compareTo(b);
        }
      };

    Collections.sort(tmph,g);

    // sort on last name
    h = new Comparator() {
        public int compare(Object o1, Object o2) {
          String a = ((Person)o1).last;
          String b = ((Person)o2).last;
          return a.compareTo(b);
        }
      };

    Collections.sort(tmph,h);

    System.out.println(asString(tmph));


  }


  public static void main(String[] args) {
    new AllSort().main(); // run main functions
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
