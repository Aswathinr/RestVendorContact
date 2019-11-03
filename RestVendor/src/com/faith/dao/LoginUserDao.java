package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.LoginUser;


public class LoginUserDao implements ILoginUserDao {
	

	JdbcTemplate template;
	
	

	public  void setTemplate(JdbcTemplate template) {
		
		this.template = template;
	}



	@Override
	public List<LoginUser> getAllDetails() {
		
		return template
				 .query("select id,username,password,rollId from LoginUser order by id desc",
		            new RowMapper<LoginUser>(){
		            	public LoginUser mapRow(ResultSet rs, int row) throws SQLException{
		            		LoginUser loginuser = new LoginUser();
		               		loginuser.setId(rs.getInt(1));
		            		loginuser.setUsername(rs.getString(2));
		            		loginuser.setPassword(rs.getString(3));
		            		loginuser.setRollId(rs.getInt(4));
		            		
		            		return loginuser;
		            	}
		            	
		            });
		
	}



	@Override
	public LoginUser searchLoginUserDetails(String searchString) {
        String sql = "select id,username,password,rollId"+" from LoginUser where username =?";
		return template.queryForObject(sql, new Object[] {searchString},
				 new BeanPropertyRowMapper<LoginUser>(LoginUser.class));
				
	}



	@Override
	public LoginUser getLoginUserById(int id) {
		String sql = "select id,username,password,rollId"+" from LoginUser where id =?";
		return template.queryForObject(sql, new Object[] {id},
				 new BeanPropertyRowMapper<LoginUser>(LoginUser.class));	
	}
	
	/*--------------------------DELETE---------------------------------*/

	@Override
	public int disableLoginUser(int id) {
		String sql = "update LoginUser set isActive='no' where id=?";
		return template.update(sql, new Object[] { id });

	}

	/*--------------------------INSERT---------------------------------*/

	@Override
	public int insertLoginUserDetails(LoginUser loginuser) {
		
		String sqlOne = "insert into LoginUser(username,password,rollId) values('" + loginuser.getUsername() + "','" 
		+ loginuser.getPassword() + "'," + loginuser.getRollId() + ")";
		
		return template.update(sqlOne);
		
	}
		
	
	/*--------------------------UPDATE---------------------------------*/

	@Override
	public int updateLoginUserDetails(LoginUser loginuser) {
		// to update user table
		String sqlOne = "update LoginUser set username='" + loginuser.getUsername()
				+ "',password='" + loginuser.getPassword() + ",rollId=" + loginuser.getRollId()
				+ " where id=?";
		return template.update(sqlOne, new Object[] { loginuser.getId() });
		
	}
	
	
	@Override
	public LoginUser searchUserDetails(String username,String password) {
        String sql = "select id,username,password,rollId from LoginUser where username =? and password=?";
		return template.queryForObject(sql, new Object[] {username,password},
				 new BeanPropertyRowMapper<LoginUser>(LoginUser.class));
				
	}


	
	

}
