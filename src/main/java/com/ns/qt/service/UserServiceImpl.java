package com.ns.qt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Sergey_Samarkin on 12/7/2016.
 */

import com.ns.qt.entities.User;
import com.ns.qt.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UsersRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User client = users.findByUsername(username);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(), client.getPassword(),
                    DummyAuthority.getAuth());
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }

    static class DummyAuthority implements GrantedAuthority
    {
        static Collection<GrantedAuthority> getAuth()
        {
            List<GrantedAuthority> res = new ArrayList<>(1);
            res.add(new DummyAuthority());
            return res;
        }
        @Override
        public String getAuthority() {
            return "ROLE_USER";
        }
    }

	@Override
	public void save(User user) {
		users.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = new ArrayList<>();
    	Iterable<User> userIterator = users.findAll();
    	userIterator.forEach(userList::add);
    	return userList;
	}

	@Override
	public User findOne(long id) {
		User user = users.findOne(id);
		return user;
	}

	@Override
	public void delete(long id) {
		users.delete(id);
	}
}
