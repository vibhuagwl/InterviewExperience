  public class Test {
    static {
        System.out.println("Static Block");
    }
    {
        System.out.println(" Initialization Block");
    }
    Test(){
        System.out.println("Constructor");
    }
    public static void main(String[] args){
        System.out.println("Main Method");
        new Test();
    }
}