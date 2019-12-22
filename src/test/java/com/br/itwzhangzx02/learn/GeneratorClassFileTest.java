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
import java.io.InputStream;
/**
 * 用于查看JDK的动态代理，main方法中第一行，参数修改为true，
 * 会将生成的代理类文件保存到本地
 * 默认 ： com/sun/proxy
 * */
public class GeneratorClassFileTest {

  public static void main(String[] args) {
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    String resource = "mybatis-config.xml";
    SqlSessionFactory sqlSessionFactory;
    try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
      //1、创建SqlSessionFactory
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      //2、获取sqlSession
      SqlSession sqlSession = sqlSessionFactory.openSession();
      User user = getUser(sqlSession);
      System.out.println(user);
    }catch (Exception e){
    }
  }

  private static User getUser(SqlSession sqlSession) {
    //3、获取mapper
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
    userMapper.toString();
    //4、执行数据库操作，并处理结果集
    return userMapper.selectUser("10");
  }

}
