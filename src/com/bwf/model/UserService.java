package com.bwf.model;

import com.bwf.bean.User;

public class UserService {
	//验证用户
	public boolean valid(User user){
		//处理业务,并返回
		if (null == user || user.getPassword() == null || user.getPassword() == null) {
			return false;
		}else if(user.getUsername().equals("a") && user.getPassword().equals("a")){
			return true;
		}else{
			return false;
		}
	}

}
