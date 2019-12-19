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
package com.br.itwzhangzx02.learn;


import learn.User;
import learn.UserMapper;
import learn.UserUpdateMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.Reader;
/**
 *事务提交时，将会往二级缓存里加数据
 * 开启事务自动提交的话，在sqlSession关闭的时候，会进行事务提交。
 * */
public class CacheTest {

  private static SqlSessionFactory sqlSessionFactory;

  @BeforeAll
  static void initDatabase() throws Exception {
    try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
  }

  /**
   *     没有使用二级缓存。。。
   * */
  @Test
  public  void testUnCommit() throws Exception {
    SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
    SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
    UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
    UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
    System.out.println(userMapper.selectUser("10"));
    System.out.println(userMapper2.selectUser("10"));
  }
  /**
   *
   *     使用二级缓存。。。
   * */
  @Test
  public  void testCommit() throws Exception {
    SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
    SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
    UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
    UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
    System.out.println(userMapper.selectUser("10"));
    sqlSession1.commit();
    System.out.println(userMapper2.selectUser("10"));
  }

  /**
   *
   *     刷新二级缓存。。。
   * */
  @Test
  public void testCacheWithUpdate() throws Exception {
    SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
    SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
    SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
    UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
    UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
    UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
    System.out.println(userMapper.selectUser("10"));
    sqlSession1.commit();
    System.out.println(userMapper2.selectUser("10"));
    userMapper3.updateName("www","10");
    sqlSession3.commit();
    System.out.println(userMapper2.selectUser("10"));
  }


  @Test
  public void testArgs() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    System.out.println(getUser(sqlSession));
  }


  private  User getUser(SqlSession sqlSession) {
    //3、获取mapper
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //4、执行数据库操作，并处理结果集
     return userMapper.selectUserByArgs("10","www");
  }

}
