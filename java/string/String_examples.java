// compile this file: javac String_examples.java
//
// run this file: java String_examples

public class String_examples {

  void print(Object s) {
    System.out.println(s.toString());
  }
  
  { // interactive
    try { // we have to wrap the following in a try ... catch
      // ... block otherwise the compiler complains; ignore try
      // and catch for now

      String sfoo = "Tom";
            
      print(sfoo.substring(1));
    
      print(sfoo.equals(""));
    
      print("".equals(sfoo));

      print("Before");
      print(sfoo.charAt(3)); // something goes wrong! nothing printed
      print("After"); // this isn't printed either!
      
      /* don't actually do this
         while(true) {
         print("I love programming!");
         }
      */

    } catch(Exception e) { } // catch block
  }

  
  int somefun(String s) {
    int to_return = 0;
    while(true) {
      if(s.equals("")) return to_return;
      to_return++;
      s=s.substring(1);
    }
  }


  int somefun_2(String s) { 
    if(s.equals("")) return 0;
    else return 1+somefun_2(s.substring(1));
  }

    
  boolean occurs(char c, String s) {
    boolean to_return = false;
    while(true) {
      if(s.equals("")) return to_return;
      // s is not the empty string at this point
      char c2 = s.charAt(0);
      if(c==c2) { to_return = true; }
      s=s.substring(1);
    }
    // return to_return; // unreachable
  }

  {
    print(occurs('a',"hello"));
    print(occurs('e',"hello"));
  }

  

  String removeAll(char c, String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return;
      // at this point s is not ""
      char c2 = s.charAt(0);
      if(c2!=c) { to_return += c2; }
      s=s.substring(1);
    }
    // return to_return; // won't be reached; you may have to
    // uncomment this line depending on Java version
  }

  { // interactive
    print(removeAll('o',""));
    print(removeAll('o',"aobocod"));
  }



  
  /*
    int len = 0;

    while(!s.equals("")) {
    print(s);
    s=s.substring(1);
    len=len+1;
    }

    print("Length is " + len);
  */

  ////////////////////////////////////////
  // as a function

  
  int myLength(String s) {
    int len = 0;
    while(!s.equals("")) {
      s=s.substring(1);
      len=len+1;
    }
    return len;
  }

  {
    print(myLength("Thomas"));
  }



  ////////////////////////////////////////
  // the template

  /*
    int template(String s0) {
    int to_return = 0; // the string we will finally return
    String s_done = "";    // the part of s0 that we have done so far
    String s_todo = s0;    // the part of s0 that we have to do
    while(true) {
    // if there is nothing left to do...
    if(s_todo.equals("")) return to_return;

    // otherwise look at the first char
    char c = s_todo.charAt(0);
    if(c == ???) { ... }  // ?????? what to do here ???
    else { ... }  // ??????? and here????
    s_todo = s_todo.substring(1);
    s_done = s_done+c;
    }
    }
  */


  public String reverse(String s)  {
    String to_return = "";
    while(true) {
      if (s.equals("")) return to_return;
      // s is not empty
      char c = s.charAt(0);
      to_return = c+to_return;
      s=s.substring(1);
    }
  }
  

  public String reverse_words(String s) {
    String to_return="";
    String str = ""; // stores the current word *in reverse*
    while(true) {
      if(s.equals("")) return to_return+str;
      char c = s.charAt(0);
      if(c == ' ') {
        to_return = to_return+str+' ';
        str="";
      } else {
        str=c+str;
      }
      s=s.substring(1);
    }    
  }




  
  // a main function

  public static void main(String[] args) {
    new String_examples();
  }
  
}
