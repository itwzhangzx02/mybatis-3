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
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.io.InputStream;

public class ConnectionTest {

  private static SqlSession sqlSession;

  @BeforeAll
  public static void getSqlSession() throws IOException {
    String resource = "resources/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //1、创建SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //2、获取sqlSession
     sqlSession = sqlSessionFactory.openSession(true);
  }

  @Test
  public  void test01() throws IOException {

      User user = getUser(sqlSession);
      System.out.println(user);

  }

  private  User getUser(SqlSession sqlSession) {
    //3、获取mapper
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //4、执行数据库操作，并处理结果集
    return userMapper.selectUser("10");

  }

  @Test
  public void testUpdate() throws IOException {
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    userMapper.updateName("zzx","10");
  }


}
