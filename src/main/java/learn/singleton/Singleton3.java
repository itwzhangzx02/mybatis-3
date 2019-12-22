package learn.singleton;

public class Singleton3 {

  private Singleton3(){
  }
  public static class InnerSingleton3{
    private  final static  Singleton3 singleton3 = new Singleton3();

    public static Singleton3 getSingleton3() {
      return singleton3;
    }
  }

}
