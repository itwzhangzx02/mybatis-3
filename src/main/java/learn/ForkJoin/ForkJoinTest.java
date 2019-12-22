package learn.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinTest {
  public static void main(String[] args) {
    test();
  }

  public static void test(){
    //统计时间
    long l = System.currentTimeMillis();

    //ForkPool
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    ForkJoinWork task = new ForkJoinWork(0L, 1000000000L);//10亿
    Long invoke = forkJoinPool.invoke(task);
    long l2 = System.currentTimeMillis();

    System.out.println("invoke="+invoke + "time:"+(l2-l));
  }


  public static void test3(){
    //统计时间  mapreduce : 拆分
        /*
            100信息
                   === 20
                   === 20
                   === 20
                   === 20
                   === 20
         */
    long l = System.currentTimeMillis();

    long reduce = LongStream
      .rangeClosed(0, 1000000000L)
      .parallel()
      .reduce(0, Long::sum);

    long l2 = System.currentTimeMillis();

    System.out.println("invoke="+ reduce + "time:"+(l2-l));

    // invoke=500000000500000000time:504
  }


}
