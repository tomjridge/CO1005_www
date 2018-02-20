import java.util.*;

// mergesort class ----------------------------------------


public class MergeSort extends List_ops<Integer> { // bring in hd, tl etc
  
  // generic functions ----------------------------------------

  int length(List<Integer> l) {
    int to_return = 0;
    while(true) {
      if(l.isEmpty()) return to_return;
      l=tl(l);
      to_return++;
    }
  }

  // return first n elts
  List<Integer> take(int n, List<Integer> l) {
    List<Integer> to_return = nil();
    while(true) {
      if(length(to_return) == n) return to_return;
      to_return = append1(to_return,hd(l));
      l = tl(l);
    }
  }

  // drop first n elts
  List<Integer> drop(int n, List<Integer> l) {
    List<Integer> to_drop = nil();
    while(true) {
      if(length(to_drop) == n) return l;
      to_drop = append1(to_drop,hd(l));
      l = tl(l);
    }
  }

  // merge two sorted lists of ints
  List<Integer> merge(List<Integer> l1, List<Integer> l2) {
    List<Integer> to_return = nil();
    while(true) {
      if(l1.isEmpty()) return append(to_return,l2);
      if(l2.isEmpty()) return append(to_return,l1);
      int i1 = hd(l1);
      int i2 = hd(l2);
      if(i1 < i2) {
        to_return = append1(to_return,i1);
        l1 = tl(l1);
      } else {
        to_return = append1(to_return,i2);
        l2 = tl(l2);
      }
    }
  }

  // mergesort! ----------------------------------------

  List<Integer> mergesort(List<Integer> l) {
    if(length(l) == 0 || length(l)==1) return l; // already sorted
    List<Integer> l1 = take(length(l)/2,l); // first half
    List<Integer> l2 = drop(length(l)/2,l); // second half
    l1 = mergesort(l1);  // sort l1
    l2 = mergesort(l2);  // sort l2
    return merge(l1,l2);  // merge l1 and l2
  }

  // testing ---------------------------------------- 

  void print(String s) {
    System.out.println(s);
  } 

  void main() { 
    List<Integer> l123=cons(1,cons(2,cons(3,nil())));
    List<Integer> l456=cons(4,cons(5,cons(6,nil())));
    List<Integer> l456123 = append(l456,l123);
    print(asString(l456123));
    print(asString(mergesort(l456123)));
  }

  public static void main(String[] args) {
    new MergeSort().main(); // run main functions
  }

}



