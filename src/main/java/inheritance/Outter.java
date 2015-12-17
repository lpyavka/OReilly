package inheritance;

/**
 * Created by Bohdan on 27.10.2015.
 */
public class Outter {

    public static void main(String[] args) throws Exception {
        Outter main = new Outter();
         Class1 class1 = new Class1();
         Class2 class2 = new Class2();
        Anonymus[] anonymuses = new Anonymus[2];
        anonymuses[0]= class1;
        anonymuses[1]= class2;
          for (Anonymus anon: anonymuses) {
              doSmth(anon);
          }
    }

    public static void doSmth(Anonymus anonymus) {
        anonymus.shouldImplement();
    }


}
