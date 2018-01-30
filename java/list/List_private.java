// this is private - store functions that we have yet to do here
import java.util.*;

public class List_private extends List_examples {


  String reverse(String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return;
      char c = s.charAt(0);
      to_return = c + to_return;
      s=s.substring(1);
    }
  }
  
  // buggy! ?
  List reverse(List l0) {
    List l = copy(l0); // don't want to mess up the original list
    List to_return = new LinkedList();
    while(true) {
      if(l.isEmpty()) return to_return;
      Object o = l.get(0);
      to_return.add(0,o);
      l.remove(0); // error
    }
  }

  
  public boolean string_equals(String s1, String s2) {
    while(true) {
      if(s1.equals("") && s2.equals("")) return true;
      if(s1.equals("")) return false;
      if(s2.equals("")) return false;
      char c1 = s1.charAt(0);
      char c2 = s2.charAt(0);
      if(c1==c2) {
        s1=s1.substring(1);
        s2=s2.substring(1);
      } else {
        return false;
      }
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

  public List lexsort(List l) {
    Comparator c = new Comparator() {
        public int compare(Object o1, Object o2) {
          String s1 = (String)o1;
          String s2 = (String)o2;
          if(string_equals(s1,s2)) return 0;
          else if(lexcompare(s1,s2)) return -1; 
          else return 1;
        }
      };
    Collections.sort(l,c);
    return l;
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


  
  List splice(List l1, List l2) {
    List to_return = nil();
    while(true) {
      if(l1.isEmpty()) return append(to_return,l2);
      if(l2.isEmpty()) return append(to_return,l1);
      to_return = append1(to_return,hd(l1));
      to_return = append1(to_return,hd(l2));
      l1 = tl(l1);
      l2 = tl(l2);
    }
  }



  List yz(Integer i, List l) {
    List to_return = nil();
    while(true) {
      if(l.isEmpty()) return append1(to_return,i);
      Integer j = (Integer)(hd(l));
      if(i<j) {
        to_return=append1(to_return,i); 
        return append(to_return,l);
      }
      to_return=append1(to_return,j);
      l=tl(l);
    }
  }
  
  List ya(List l) {
    List to_return = nil();
    while(true) {
      if(l.isEmpty()) return to_return;
      to_return = yz((Integer)(hd(l)),to_return);
      l=tl(l);
    }
  }

  
  
  /* L02B.bsh
     List insert(int i, List l) {

     List to_return = nil();

     while(true) {
     if(l.isEmpty()) return append1(to_return,i);

     Integer j = hd(l);
     if(i<j.intValue()) {
     to_return=append1(to_return,i); // insert i here
     to_return=append(to_return,l); // don't forget the rest of the list
     return to_return;
     }

     // i >= hd(l)
     to_return=append1(to_return,j);
     l=tl(l);
     }

     }

     // ints are different from Integers; int is a primitive type; Integer is
     // a class; Lists hold objects (which have a class) not ints (which
     // don't have a class)
     int i = 1;
     Integer i = new Integer(1);

     tmpl=cons(1,cons(2,cons(4,cons(5,nil()))));

     insert(3,tmpl);

     insert(3,nil());


     // how does this execute?
     insert(3,[1,2,4,5]) -> [1,2,3,4,5]


     to_return     i       l
     []            3       [1,2,4,5]
     [1]           3       [2,4,5]
     [1,2]         3       [4,5]
     [1,2,3,4,5]


     List sort(List l) {
     List to_return = nil();
     while(true) {
     if(l.isEmpty()) return to_return;
     to_return = insert(hd(l),to_return);
     l=tl(l);
     }
     }


     sort(cons(9,cons(3,cons(1,nil())))); // returns [1,3,9] as expected




     // recursive version; this is probably simplest - no to_return (kept implicit)
     List insert(int i, List l0) { 
     List l = l0.clone(); // careful

     // either l is empty
     if(l.isEmpty()) return cons(new Integer(i), nil());

     // or ...
     Integer j = (Integer)(hd(l));

     // we may want to add i into the list here
     if(i<j.intValue()) return cons(new Integer(i), l);

     // else make recursive call, but list arg is now smaller
     else return cons(j, insert(i,tl(l)) ); 

     }

     insert(3,tmpl);
  */



  /* CC02.bsh
  // remember that you have to copy these into the file AllList.java to
  // get Java to compile them

  boolean contains(Object obj, List l) {

  while(true) {
  if(l.isEmpty()) return false;

  if(obj.equals(hd(l))) return true;
        
  l=tl(l);

  }
  }


  tmpl = cons(1,cons(2,cons(4,cons(5,nil()))));
  tmph = cons("a",cons("b",cons("d",cons("e",nil()))));

  splice(tmpl,tmph);

  List diff(List l1, List l2) {
  List to_return = nil();
  while(true) {
  if(l1.isEmpty()) return to_return;
  if(!contains(hd(l1),l2)) to_return = append1(to_return,hd(l1));
  l1 = tl(l1);
  }
  }

  diff(tmpl,cons(2,cons(4,nil())));


  // almost idential to insert
  List lexinsert(String i, List l) {
  List to_return = nil();

  while(true) {
  if(l.isEmpty()) return append1(to_return,i);

  String j = (String)(hd(l));
  if(lexcompare(i,j)) {
  to_return=append1(to_return,i); // insert i here
  to_return=append(to_return,l); // don't forget the rest of the list
  return to_return;
  }

  // i >= hd(l)
  to_return=append1(to_return,j);
  l=tl(l);
  }

  }

  lexinsert("c",tmph);

  // almost identical to sort
  List lexsort(List l) {
  List to_return = nil();
  while(true) {
  if(l.isEmpty()) return to_return;
  to_return = lexinsert((String)(hd(l)),to_return);
  l=tl(l);
  }
  }

  lexsort(cons("bert",cons("alf",cons("charlie",nil()))));

  */


  /* list.bsh

     import java.util.*;

     // basic lists
     tmpl = new LinkedList();
     tmpl.add(0,"hello ");
     tmpl.add(1,"world!");
     tmpl;
     tmpl.remove(0);
     tmpl;

     tmph = tmpl.clone(); // changes to tmph don't affect tmpl


     // the empty list
     List nil() {
     return new LinkedList();
     }

     // add at front of list
     List cons(Object o, List l0) {
     List l = l0.clone();
     l.add(0,o);
     return l;
     }

     // head of the list
     Object hd(List l) { return l.get(0); }

     // tail of the list
     List tl(List l0) {
     List l = l0.clone();
     l.remove(0);
     return l;
     }

     nil();

     world = cons("world!",nil());

     hello_world = cons("hello ", world);

     hd(world);
     tl(hello_world);


     List reverse(List l0) {
     List l = l0;
     List to_return = nil();

     while(true) {
     if(l.isEmpty()) return to_return;

     to_return = cons(hd(l),to_return);
     l=tl(l);
     }

     }

     // add at end of list
     List append1(List l0, Object o) {
     List l = l0.clone();
     l.add(l.size(),o);
     return l;
     }

     // join two lists together
     List append(List l01, List l02) {
     List to_return = l01.clone();
     List l2 = l02.clone();

     while(true) {
     if(l2.isEmpty()) return to_return;
     to_return=append1(to_return,l2.get(0));
     l2=tl(l2);
     }

     }

     append1(hello_world," again!");
     append(hello_world,hello_world);

     // probably pointless if we have clone, but gets us used to stepping
     // through a list
     List copy(List l0) {

     List to_return = nil();
     List l = l0.clone();
     while(true) {
     if(l.isEmpty()) return to_return;
     to_return = append1(to_return, l.get(0));
     l=tl(l);
     }

     }


     // is this correct?
     List insert(int i, List l) {
     List to_return = nil();
    
     while(true) {
     if(l.isEmpty()) return append1(to_return, new Integer(i));

     Integer j = (Integer)(hd(l));
     if(i<j.intValue()) {
     // we want to add i into the list here
     to_return=append1(to_return, new Integer(i));
     return append(to_return, l);
     }
     to_return=append1(to_return, j);
     l=tl(l);
     }

     }

     tmpl=cons(1,cons(2,cons(4,cons(5,nil()))));
     insert(3,tmpl);
     insert(3,nil());

     // let rec insert i xs = if xs = [] then [i] else if i < hd xs then i::xs else (hd xs)::(insert i (tl xs))


     // recursive version; this is probably simplest - no to_return (kept implicit)
     List insert(int i, List l) { 

     // either l is empty
     if(l.isEmpty()) return cons(new Integer(i), nil());

     // or ...
     Integer j = (Integer)(hd(l));

     // we may want to add i into the list here
     if(i<j.intValue()) return cons(new Integer(i), l);

     // else make recursive call, but list arg is now smaller
     else return cons(j, insert(i,tl(l)) ); 

     }

     insert(3,tmpl);

  */


  /* S02.bsh

  // Surgery S02

  List dup(List l) {

  List to_return = nil();

  while(true) {
  if(l.isEmpty()) return to_return;

  to_return = append1(to_return,hd(l));
  to_return = append1(to_return,hd(l));

  l=tl(l);

  }

  }


  boolean contains(Object obj, List l) {

  while(true) {
  if(l.isEmpty()) return false;

  if(obj.equals(hd(l))) return true;
        
  l=tl(l);

  }
  }


  List remdups(List l) {

  List to_return = nil();
    
  while(true) {
  if(l.isEmpty()) return to_return;

  if(!contains(hd(l),to_return)) { to_return = append1(to_return,hd(l)); }
        
  l=tl(l);

  }

  }
  */


  /* sumlist.bsh

     l = new LinkedList();

     l.add(1);
     l.add(2);
     l.add(3);

     sum=0;

     while(true) {
     if(l.isEmpty()) break;
     sum=sum+l.elementAt(0);
     l=l.remove(0);    
     }


  */



  
}



