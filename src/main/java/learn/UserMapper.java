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

import java.util.List;

public interface UserMapper {

  public User selectUser(String id);

  public User selectUserByIdAndName(String id,String name);

  public User selectUserByArgs(String id,String name);

  public User selectUser2(User user);

  public void updateName(@Param("name") String name , @Param("id")String id);

  void insert(User user);

  void batchInsert(List<User> list);
}
