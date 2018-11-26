package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.servlet.ModelAndView;

import com.model.Login;
import com.model.User;

public class UserDao implements InterfaceUserDao {
	
	private JdbcTemplate jdbcTemplate;  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	public int saveUser(User r) {
			String query1 = "select group9_bus_users_seq.nextval from dual";
			int query2 = getSeq(query1);
		 String query="insert into GROUP9_BUS_USERS values("+query2+",'"+r.getFirstName()+"','"+r.getLastName()+"','"+r.getEmailId()+"','"+r.getPassword()+"',"+r.getContactNumber()+")";  
		    return jdbcTemplate.update(query);  
	}

	private int getSeq(String query1) {
		
		int res = jdbcTemplate.queryForObject(query1, Integer.class);
		return res;
	}

	public boolean validateUser(Login l) {
		
		String email= "select GBU_EMAIL_ID from GROUP9_BUS_USERS where GBU_EMAIL_ID='" + l.getEmailId() + "'";
		String password= "select GBU_PASSWORD from GROUP9_BUS_USERS where GBU_PASSWORD='" + l.getPassword() + "'";
		String e = jdbcTemplate.queryForObject(email, String.class);
		System.out.println(e);
	
		String p = jdbcTemplate.queryForObject(password, String.class);
		System.out.println(p);
		
		if(l.getEmailId().equals(e) && l.getPassword().equals(p)) { 
		return true;
		
	}	
		else
			return false;
	
	}
	
	
	
	public List<User> getUser(User s){  
		return jdbcTemplate.query("select GBU_FIRST_NAME,GBU_LAST_NAME from GROUP9_BUS_USERS where GBU_CONTACT_NUMBER =9969004771 ",new ResultSetExtractor<List<User>>(){  
			public List<User> extractData(ResultSet rs) throws SQLException,  
			DataAccessException {  
				List<User> list=new ArrayList<User>();  
				while(rs.next()){  
					User sp=new User();
					sp.setFirstName(rs.getString(1));
					list.add(sp);
				}  
				return list;  
			}  
		});
		

		}

	
}
