package cinema.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.User;
import cinema.service.UserService;
import cinema.web.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

	@Autowired
	private UserService userService;

	@Override
	public User convert(UserDTO userDTO) {
		User entity = null;

		if (userDTO.getId() == null) {
			entity = new User();
		} else {
			Optional<User> userOptional = userService.findOne(userDTO.getId());
			if (userOptional.isPresent()) {
				entity = userOptional.get();
			}
		}

		if (entity != null) {
			entity.setUsername(userDTO.getUsername());
			entity.seteMail(userDTO.geteMail());
			entity.setFirstName(userDTO.getFirstName());
			entity.setLastName(userDTO.getLastName());
		}

		return entity;
	}

}
