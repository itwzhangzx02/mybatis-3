package com.br.itwzhangzx02.learn;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.br.itwzhangzx02.learn.POJO.User;

public class StreamTest {

  /**
   * 1.id全部满足是偶数
   * 2.年龄大于10
   * 3.用户名大写
   * 4.用户名字母倒排序
   * 5.只输出一个用户名
   *
   *
   * */
  @Test
  public void testStream(){
    List<User> list = new ArrayList<User>(){
      {
        add(new User(1l,"q",10, "清华大学"));
        add(new User(2l,"f",12, "清华大学"));
        add(new User(3l,"b",15, "清华大学"));
        add(new User(4l,"a",12, "清华大学"));
        add(new User(5l,"d",25, "北京大学"));
        //add(new User(6l,"c",16, "北京大学"));
        add(new User(7l,"t",14, "北京大学"));
        //add(new User(8l,"g",14, "浙江大学"));
        add(new User(9l,"j",17, "浙江大学"));
        add(new User(10l,"l",10, "浙江大学"));
      }
    };
    list.stream()
      .filter(user -> user.getId()%2==0)
      .filter(user -> user.getAge()>10)
      .map(user -> user.getName().toUpperCase())
      //.sorted((o1, o2) -> {
      //  System.out.println(o1);
      //  System.out.println(o2);
      //  return 1;
      //})
      //.sorted()
      .sorted((o1, o2) ->{return 1;})
      //.sorted((o1, o2) -> {return o1.compareTo(o2);})
      //.sorted((o1,o2)->{return Integer.valueOf(o1)-Integer.valueOf(o2);})
      .forEach(System.out::println);

    //sorted 方法中，我们重写了compare方法：如果return是1，则是正排序。-1则是降序
    //
  }
   /**          a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.**/

   @Test
   public void testArray(){
     int[] arr ={1,2,4,3,9,5,7,8,10};
     Arrays.sort(arr,0,8);
     System.out.println(arr[2]);
     Arrays.stream(arr).forEach(o->System.out.println());
   }


  @Test
  public void testStreamOf(){
    Stream
      .of(1,2,4,5,3,9,8,10,7)
      .sorted()
      .forEach(i -> System.out.println(i));
      //.forEach(System.out::println) ;
  }


  @Test
  public void collectTest() {
    List<String> list = Stream
      .of("hello", "world", "hello", "java")
      .collect(Collectors.toList());
    list.forEach(x -> System.out.print(x + " "));
    System.out.println();
    System.out.println();
    String resultStr = Stream
      .of("hello", "world", "hello", "java")
      .collect(Collectors.joining(","));
    System.out.println(resultStr);

    Stream
      .of("hello", "world", "hello", "java")
      .collect(Collectors.toSet())
      .forEach(r-> System.out.println(r));
  }

  @Test
  public void orElseTest() {
    String id = "4" ;
    String id2 = Optional.ofNullable(id).orElse("3");
    System.out.println(id2);
  }
}
