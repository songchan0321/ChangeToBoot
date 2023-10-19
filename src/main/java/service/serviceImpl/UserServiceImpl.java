package service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.Search;
import service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	///Field
	@Autowired
	@Qualifier("userDaoImpl")
	private UserService userService;
	public void setUserDao(UserService userService) {
		this.userService = userService;
	}
	
	///Constructor
	public UserServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addUser(User user) throws Exception {
		userService.addUser(user);
	}

	public User getUser(String userId) throws Exception {
		return userService.getUser(userId);
	}

	public Map<String , Object > getUserList(Search search) throws Exception {
		List<User> list= userService.getUserList(search);
		int totalCount = userService.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public void updateUser(User user) throws Exception {
		userService.updateUser(user);
	}

	public boolean checkDuplication(String userId) throws Exception {
		boolean result=true;
		User user=userService.getUser(userId);
		if(user != null) {
			result=false;
		}
		return result;
	}
}