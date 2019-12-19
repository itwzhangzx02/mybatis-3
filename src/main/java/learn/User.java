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

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private String userCode;
    private String userName;
    private Date createTime;
    private String userType;
    private  String mobile;

    public String getUserCode() {
      return userCode;
    }

    public void setUserCode(String userCode) {
      this.userCode = userCode;
    }

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public Date getCreateTime() {
      return createTime;
    }

    public void setCreateTime(Date createTime) {
      this.createTime = createTime;
    }

    public String getUserType() {
      return userType;
    }

    public void setUserType(String userType) {
      this.userType = userType;
    }

    public String getMobile() {
      return mobile;
    }

    public void setMobile(String mobile) {
      this.mobile = mobile;
    }

    @Override
    public String toString() {
      return "User{" +
        "userCode='" + userCode + '\'' +
        ", userName='" + userName + '\'' +
        ", createTime=" + createTime +
        ", userType='" + userType + '\'' +
        ", mobile='" + mobile + '\'' +
        '}';
    }
  }

