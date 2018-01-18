public class String_exercises {

  String remove1(char c, String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return;
      char c2 = s.charAt(0);
      if(c2==c) return to_return+s.substring(1);
      to_return+=c2;
      s=s.substring(1);
    }            
  }

  {
    remove1('a',"bac");
    remove1('a',"baac");
    remove1('a',"bc");
  }


  boolean ab(String s) {
    boolean to_return = true;
    boolean seen_an_a = false;
    while(true) {
      if(s.equals("")) return to_return;
      char c2 = s.charAt(0);
      if(c2=='a') seen_an_a = true; // could just return here
      if(c2=='b') { if(!seen_an_a) return false; }
      s=s.substring(1);
    }
  }

  {
    ab("ccb");
    ab("ccaccb");
    ab("cccc");
    ab("cacccbb");
  }
    

  String reverse(String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return;
      to_return=s.charAt(0)+to_return;
      s=s.substring(1);
    }
  }

  {
    reverse("hello");
  }

  // moving down s1 and s2 at the same time!
  boolean startsWith(String s1, String s2) {
    while(true) {
      if(s1.equals("")) return true;
      if(s2.equals("")) return false;
      if(s1.charAt(0)!=s2.charAt(0)) return false;
      s1=s1.substring(1);
      s2=s2.substring(1);
    }
  }

  {
    startsWith("tom","tomab");
    startsWith("tomc","tomab");
  }


  boolean contains(String s1, String s2) {
    if(s1.equals("")) return true;
    while(true) {
      if(s2.equals("")) return false;
      if(startsWith(s1,s2)) return true;
      s2=s2.substring(1);
    }
    // return false; // unreachable
  }

  {
    contains("wor","hello world!");
    contains("word","hello world!");
  }


  String reverseWords(String s) {
    String to_return = ""; // the string we will finally return
    String current = "";   // the word we are currently working on, reversed!
    while(true) {
      // if there is nothing left to do...
      if(s.equals("")) return to_return + current;
        
      // otherwise look at the first char
      char c = s.charAt(0);
      if(c == ' ') { to_return = to_return+current+" "; current=""; }
      else         { current = c+current; }

      s = s.substring(1);
    }
  }
  

  {
    String hello="Hello you! I like Java";
    reverseWords(hello);
  }

}
