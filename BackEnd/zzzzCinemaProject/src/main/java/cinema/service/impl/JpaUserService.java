package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cinema.enumeration.UserRole;
import cinema.model.User;
import cinema.repository.UserRepository;
import cinema.service.UserService;
import cinema.web.dto.UserChangePasswordDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class JpaUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findOne(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> findAll(int pageNo) {
		return userRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public User save(User user) {
		user.setRole(UserRole.USER);
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findFirstByUsername(username);
	}

	@Override
	public boolean changePassword(Long id, UserChangePasswordDTO userChangePasswordDTO) {
		Optional<User> result = userRepository.findById(id);

		if (!result.isPresent()) {
			throw new EntityNotFoundException();
		}

		User user = result.get();

		boolean passwordsMatch = BCrypt.checkpw(userChangePasswordDTO.getOldPassword(), user.getPassword());
		if (!user.getUsername().equals(userChangePasswordDTO.getUsername()) || !passwordsMatch) {
			return false;
		}

		// dodatak
		String password = userChangePasswordDTO.getPassword();
		if (!userChangePasswordDTO.getPassword().equals("")) {
			password = passwordEncoder.encode(userChangePasswordDTO.getPassword());
		}

		user.setPassword(password);

		userRepository.save(user);

		return true;
	}
}
