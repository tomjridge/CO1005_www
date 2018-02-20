(sorting.tst

AllSort.java
Ins_sort_ops.java
Ins_sort_ops_typed.java
Ins_sort_simple.java
Ins_sort_typed.java
Intlist_insertion_sort.java
Makefile
MergeSort.java
old
S08.bsh
sorting.tst
String_insertion_sort.java
tmp
Typed_list_functions.java
  
  (section (Overview)
    
    (
      String_insertion_sort.java - strings

      Intlist_insertion_sort.java - integer lists, untyped

      Ins_sort_ops.java - untyped

      Ins_sort_simple.java - untyped

      Typed_ops.java - typed ops interface

      Typed_ins_sort.java - typed insertion sort
      
      Typed_string_ops.java - ops for strings

      Typed_list_functions.java - typed hd, tl etc; don't talk about in lectures?

      Typed_list_ops.java - typed implementation of Ins_sort_ops_typed; abstract
      
      Typed_examples.java - eg
      

AllSort.java - experiments with comparator etc

List_insertion_sort.java.fixme - redundant?

Makefile

MergeSort.java

S08.bsh - revision notes; bubblesort


      )
          

    ) (#overview)

  (Comparison of interfaces

    (String_insertion_sort

      String insert(char c, String s) 
      String ins_sort(String s)


      )

    (Intlist_insertion_sort

      List insert(Integer i, List l0)
      List ins_sort(List l0)

    )


    (Ins_sort_simple

      Object insert(Object o, Object l)
      Object ins_sort(Object l)

      )

    (Typed_ins_sort<E,L>

      L insert(E o, L l)
      L ins_sort(L l)
      
      )


  )