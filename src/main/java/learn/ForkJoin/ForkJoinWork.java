package learn.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * 定义一个任务
 * */
public class ForkJoinWork extends RecursiveTask<Long> {

  private Long start; //开始值  1
  private Long end; //结束值    10000000
  public  final static Long critcal = 10000L;

  public ForkJoinWork(Long start ,Long end) {
    this.start = start;
    this.end = end;
  }

  public ForkJoinWork(Long start ,Long end,long crital) {
    this.start = start;
    this.end = end;
  }

  //计算，如果不在临界值，进行拆分
  /**
   *
   * 一般逻辑
   *
   * if（临界值）{
   *     计算
   * }else{
   *     继续拆分，直到临界值范围内
   * }
   * */
  @Override
  protected Long compute() {
    //每次都会先拆分，拆分后判断是否满足临界点
    long length = end - start;
    if(length<critcal){
       // 计算 start--end 的求和
      Long sum = 0L;
      for (Long i = start; i <=end; i++) {
        sum += i;
      }
      return sum;
    }else{
        //拆分
      //拆分任务
      Long middle = (end+start)/2;
      ForkJoinWork right = new ForkJoinWork(start, middle); //1. 第一条线
      right.fork(); //分支
      ForkJoinWork left = new ForkJoinWork(middle+1, end); //2. 第二条线
      left.fork(); //分支
      //合并
      return right.join() + left.join();
    }


  }
}
