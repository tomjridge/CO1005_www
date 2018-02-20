public class String_insertion_sort {

  void print(Object s) {
    System.out.println(s.toString());
  }
  
  String insert(char c, String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return+c;
      char c2 = s.charAt(0);
      if(c>c2) { to_return = to_return + c2; }
      else { return to_return+c+s; }
      s=s.substring(1);
    }
  }

  String ins_sort(String s) {
    String to_return = "";
    while(true) {
      if(s.equals("")) return to_return;
      char c = s.charAt(0);
      to_return = insert(c,to_return);
      s=s.substring(1);
    }
  }
  
  void main() {
    print(insert('c',"abde"));
    print(ins_sort("thomas"));
  }

  public static void main(String[] args) {
    new String_insertion_sort().main();
  }
  
}
