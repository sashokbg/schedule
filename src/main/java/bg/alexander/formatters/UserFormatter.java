package bg.alexander.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import bg.alexander.model.user.User;
import bg.alexander.services.user.UserService;

@Component("userFormatter")
public class UserFormatter implements Formatter<User>{
	@Autowired
	private UserService userService;
	
	@Override
	public String print(User user, Locale locale) {
		return user.getId().toString();
	}

	@Override
	public User parse(String userId, Locale locale) throws ParseException {
		User user = userService.getUser(Long.valueOf(userId)); 
		return user;
	}
}
