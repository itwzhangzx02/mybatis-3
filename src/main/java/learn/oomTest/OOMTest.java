/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package learn.oomTest;


import learn.User;
import learn.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 由于，使用junit时，我们的vm监测不到，所以改用main方法
 *
 * */
public class OOMTest {

  private static SqlSessionFactory sqlSessionFactory;


  public static void main(String[] args) throws Exception{

    new Thread(()->{
      try {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
       // List<User> list = new ArrayList<User>();
       while(true) {
          List<User> list = new ArrayList<User>();
          User user = getUser(sqlSession);
          User user2 = getUser2(sqlSession);
          System.out.println(user);
          System.out.println(user2);
          list.add(user);
          list.add(user2);
        }
      }catch(Exception e){

      }
    }).start();
  }

    static   User getUser(SqlSession sqlSession) {
    //3、获取mapper
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //4、执行数据库操作，并处理结果集
    return userMapper.selectUser("10");
  }

  static   User getUser2(SqlSession sqlSession) {
    //3、获取mapper
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //4、执行数据库操作，并处理结果集
    return userMapper.selectUser("11");
  }
}
