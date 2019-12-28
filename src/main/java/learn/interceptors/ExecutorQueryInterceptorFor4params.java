package learn.interceptors;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({@Signature(
  type= Executor.class,
  method = "query",
  args = {MappedStatement.class,Object.class
    ,RowBounds.class,ResultHandler.class})
    })
public class ExecutorQueryInterceptorFor4params implements Interceptor {

  /**
   * 重写四个参数的方法，这里面返回的是六个方法的调用
   * 我们对这个方法再做拦截
   * */
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    //人为重写四个参数的方法，在这里调用六个参数的query
    Object[] args = invocation.getArgs();
    MappedStatement ms = (MappedStatement) args[0];
    Object parameter = args[1];
    RowBounds rowBounds = (RowBounds) args[2];
    ResultHandler resultHandler = (ResultHandler) args[3];
    Executor executor = (Executor) invocation.getTarget();
    BoundSql boundSql = ms.getBoundSql(parameter);
    CacheKey cacheKey =executor.createCacheKey(ms, parameter, rowBounds, boundSql);
    return executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, boundSql);
  }
}
