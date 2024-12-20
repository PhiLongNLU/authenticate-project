package com.nonglam.authentication.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nonglam.authentication.model.User;

@Component
public class UserDaoService implements IService<User>{
	public static int userCount = 1;
	public static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(userCount++, "Adam", LocalDate.now().minusYears(20)));
		users.add(new User(userCount++, "Eva", LocalDate.now().minusYears(15)));
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User save(User t) {
		// TODO Auto-generated method stub
		t.setId(userCount++);
		return users.add(t) ? t : null;
	}

	@Override
	public User findOne(int id) {
		// TODO Auto-generated method stub
		return users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
	}

	@Override
	public User update(int id, User t) {
		// TODO Auto-generated method stub
		User result = null;
		for(var user : users) {
			if(user.getId() == id) {
				user.setBdate(t.getBdate());
				user.setName(t.getName());
			}
		}
		
		return result;
	}
}
