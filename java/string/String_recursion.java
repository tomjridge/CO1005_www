public class String_recursion {

  void print(Object s) {
    System.out.println(s.toString());
  }

  
  String rev(String s) {
    return rev2(s,""); // refers to *next* function
  }

  
  String rev2(String s, String to_return) {
    while(true) { // X1
      if(s.equals("")) return to_return;
      char c = s.charAt(0);
      to_return = c + to_return;
      s=s.substring(1);
    } // goto X1
  }

  {
    print(rev2("abc","123"));
  }

  
  String rev2_rec(String s, String to_return) {

    if(s.equals("")) return to_return;
    char c = s.charAt(0);
    to_return = c + to_return;
    s=s.substring(1);

    return rev2_rec(s,to_return);

  }

  {
    print(rev2_rec("abc","123"));
  }


  int somefun(String s, int to_return) { 
    // while(true) {
    if(s.equals("")) return to_return;
    to_return++;
    s=s.substring(1);
    //}
    return somefun(s,to_return);
  }

  {
    somefun("hello",0); 
  }


  String removeAll_while(char c, String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return;
      // at this point s is not ""
      char c2 = s.charAt(0);
      if(c2!=c) { to_return += c2; }
      s=s.substring(1);
    }
    // return to_return; // won't be reached
  }

  {
    print(removeAll_while('o',"hello"));
  }

  
  String removeAll_rec(char c, String s, String to_return) {
    if(s.equals("")) return to_return;
    // at this point s is not ""
    char c2 = s.charAt(0);
    if(c2!=c) { to_return += c2; }
    s=s.substring(1);
    return removeAll_rec(c, s, to_return);
  }

  {
    print(removeAll_rec('o',"hello",""));
  }

  
  // a final version using recursion
  String removeAll(char c, String s) {
    return removeAll_rec(c,s,"");
  }

  {
    print(removeAll('o',"hello"));
  }
  
}
