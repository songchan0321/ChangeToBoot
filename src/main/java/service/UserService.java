package service;

import java.util.Map;

import common.Search;
import domain.User;



public interface UserService {
	

	public void addUser(User user) throws Exception;
	

	public User getUser(String userId) throws Exception;
	

	public Map<String , Object> getUserList(Search search) throws Exception;

	public void updateUser(User user) throws Exception;
	

	public boolean checkDuplication(String userId) throws Exception;
	
}