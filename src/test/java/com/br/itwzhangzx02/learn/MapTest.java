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

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapTest {

  @Test
  public void test01()  {
    Map map = new HashMap<String,String>();

    map.computeIfAbsent("key1",  new Function<String,String>() {
       @Override
      public String  apply(String t) {
        return  t ;
      }
    } );

    map.computeIfAbsent("key2",m->{return m ;});
    map.computeIfAbsent("key3",(m)->{return m;} );

    System.out.println(map.get("key1"));
    System.out.println(map.get("key2"));
    System.out.println(map.get("key3"));
  }
}
