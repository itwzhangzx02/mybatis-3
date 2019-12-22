package learn.singleton;

public class Singleton1 {

  private  final static Singleton1 singleton1 = new Singleton1();

  public static Singleton1 getSingleton1(){
    return  singleton1;
  }
  private Singleton1(){
  }

}
