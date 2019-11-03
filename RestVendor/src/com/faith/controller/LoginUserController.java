package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.ILoginUserDao;
import com.faith.model.LoginUser;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginUserController {
   
   @Autowired
   private ILoginUserDao dao;
   
   @RequestMapping(value ="/loginuserdetails",method = RequestMethod.GET)
   public List getLoginUserDeatils(){
	   List list;
	   System.out.println("Get all LoginUser details");
	   list = dao.getAllDetails();
	   return list;
   }
   @RequestMapping(value = "/loginuserdetails/{searchString}",method = RequestMethod.GET)
   public LoginUser getLoginUserDetails(@PathVariable("searchString") String searchString){
	   //List list
	   System.out.println("Get a single loginuser details");
	   LoginUser loginuser = (LoginUser) dao.searchLoginUserDetails(searchString);
	   return loginuser;
   }
   @RequestMapping(value = "/loginuserbyid/{id}",method = RequestMethod.GET)
   public LoginUser getLoginUserByid(@PathVariable("id") int id){
	   LoginUser loginuser = dao.getLoginUserById(id);
	   return loginuser;
   }
   /*--------------------insert----------------------------*/
   @RequestMapping(value = "/insertloginuser", method = RequestMethod.POST)
   public void insertDetails(@RequestBody LoginUser loginuser){
	   dao.insertLoginUserDetails(loginuser);
   }
   
   /*------------------UPDATE------------------------------*/
   @RequestMapping(value = "/updateloginuser", method = RequestMethod.PUT)
   public void updateDetails(@RequestBody LoginUser loginuser){
	   dao.updateLoginUserDetails(loginuser);
   }
   /*---------------------DELETE--------------------------------*/
   @RequestMapping(value = "/disableloginuser/{id}", method = RequestMethod.PUT)
   void disableDetails(@PathVariable("id") int id){
	   dao.disableLoginUser(id);
   }
   
   @RequestMapping (value = "/loginuserdetbyname/{username}/{password}", method = RequestMethod.GET)
	public LoginUser getUserDetails (@PathVariable("username") String username,@PathVariable("password") String password){
		
	   LoginUser loginuser = (LoginUser)dao.searchUserDetails(username,password);
		System.out.println("get all user details by username and password");
		return loginuser;
	}
}
