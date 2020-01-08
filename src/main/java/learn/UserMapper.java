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
package learn;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {

  public User selectUser(String id);

  public User selectUserByIdAndName(String id,String name);

  public User selectUserByArgs(String id,String name);

  public User selectUserByIdFromTable(@Param("id")String id,@Param("tableName")String tableName);

  public User selectUser2(User user);

  public void updateName(@Param("name") String name , @Param("id")String id);

  void insert(User user);

  void batchInsert(List<User> list);

  public List<User> selectUserFromTable(@Param("tableName")String tableName, RowBounds rowBounds);
  //使用注解式的sql注入
  @Select("select * from u_user where usercode = #{简单类型只有一个参数的时候随便写}")
  public  User selectOne(String id);

  //使用注解式的sql注入
  @Select("select * from u_user where usercode = #{param1.userCode}")
  public  User selectOneByUser(@Param("user") User user);

  //使用注解式的sql注入
  @Select("select * from u_user where usercode = #{userCode}")
  public  User selectOneByUser2(User user666);

  //使用注解式的sql注入
  @Select("select * from u_user limit ${index},1")
  public  User selectOneByUser3(@Param("index") int index);

  //使用注解式的sql注入
  @Select("select * from u_user limit ${单个简单类型参数随便写没问题},1")
  public  User selectOneByUser4(Integer index);

  //使用注解式的sql注入
  @Select("select * from u_user where usercode like '%${随便写都可以}%' ")
  public  User selectOneByUser5(String id);

}
