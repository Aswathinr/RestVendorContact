package com.faith.dao;

import java.util.List;

import com.faith.model.LoginUser;


public interface ILoginUserDao {
	 public abstract List<LoginUser>getAllDetails();
	   public abstract LoginUser searchLoginUserDetails(String searchString);
	   public abstract LoginUser getLoginUserById(int id);
	   public abstract int disableLoginUser(int id);
	   public abstract int insertLoginUserDetails(LoginUser loginuser);
	   public abstract int updateLoginUserDetails(LoginUser loginuser);
	   public abstract LoginUser searchUserDetails(String username,String password);
	   

}
