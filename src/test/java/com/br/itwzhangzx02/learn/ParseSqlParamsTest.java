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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.Reader;

public class ParseSqlParamsTest {

  private static SqlSessionFactory sqlSessionFactory;

  @BeforeAll
  static void initDatabase() throws Exception {
    try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
  }

  @Test
  public  void test01() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
      User user = getUser(sqlSession);
      System.out.println(user);

  }

   private  User getUser(SqlSession sqlSession) {
    //3、获取mapper
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //4、执行数据库操作，并处理结果集
    return userMapper.selectUserByIdFromTable("10","u_user");
  }
}
