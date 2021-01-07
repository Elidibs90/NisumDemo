package com.nisum.nisum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.nisum.entity.User;
import com.nisum.nisum.exception.NotFoundException;
import com.nisum.nisum.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override

	public List<User> findAll() {
		List<User> listUsers = userRepository.findAll();
		return listUsers;
	}

	@Override
	public User findById(long id) {
		Optional<User> userInDb = this.userRepository.findById(id);
		if (userInDb.isPresent()) {

			return userInDb.get();
		} else {
			throw new NotFoundException("No existe el recurso a actualizar" + userInDb.get());
		}

	}

	@Override
	public User save(User user) {
		return userRepository.save(user);

	}

	@Override
	public User update(User user, long id) {
		Optional<User> userInDb = this.userRepository.findById(user.getId());
		if (userInDb.isPresent()) {
			User userToUpdate = userInDb.get();
			userToUpdate.setId(user.getId());

			userRepository.save(userToUpdate);
			return userToUpdate;
		} else {
			throw new NotFoundException("No existe el recurso a actualizar" + user.getId());
		}
	}

	@Override
	public User deleteById(long id) {
		Optional<User> userInDb = this.userRepository.findById(id);
		if (userInDb.isPresent()) {
			this.userRepository.deleteById(id);
			return userInDb.get();
		} else {
			throw new NotFoundException("No existe el recurso a actualizar" + userInDb.get());
		}

	}

}
