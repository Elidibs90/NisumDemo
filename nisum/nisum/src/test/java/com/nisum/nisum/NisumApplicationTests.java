package com.nisum.nisum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.nisum.nisum.entity.User;
import com.nisum.nisum.exception.NotFoundException;
import com.nisum.nisum.repository.UserRepository;
import com.nisum.nisum.service.UserService;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class NisumApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void getUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User("Jess", "jess@hotmail.com", "jess12345"), new User("Ben", "ben@hotmail.com", "bin6789")).collect(Collectors.toList()));
		assertEquals(2, userService.findAll().size());
	}
	
	@Test
	public void updateUserTest() {
		User user = new User("Ben", "ben@hotmail.com", "bin6789");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.save(user));
	}

	@Test
	public void saveUserTest() {
		User user = new User("Ben", "ben@hotmail.com", "bin6789");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.save(user));
	}

	@Test
	public Object deleteUserTest() {
		Long id = (long) 0;
		Optional<User> userInDb = this.userRepository.findById(id);
		if (userInDb.isPresent()) {
			userService.deleteById(id);
			verify(userRepository, times(1)).deleteById(id);
			return userInDb.get();
		} else {
			throw new NotFoundException("No existe el recurso a actualizar" + userInDb.get());
		}
		
		
	}

}
