package Security.Service;

import com.IOE.cs.city_sync.Repos.UserDetailsRepository;
import com.IOE.cs.city_sync.entities.CSUsers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CSUsers> user = userRepo.findByUsername();
        if(user.isPresent())

        return null;
    }

    /*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<RSCUser> user = userRepo.findByUsernameAndIsActive(username,true);
		UserDetails userDetails = null;
		if (user.isPresent()) {

			List<String> roles = user.get().getRoles().stream().map(role -> role.getRole().toString().toUpperCase())
					.collect(Collectors.toList());


			userDetails = User.withUsername(user.get()
					                            .getUsername())
					                            .password(user.get().getPassword())
					                            .roles(roles.toArray(new String[roles.size()]))
					                            .build();

		} else {
			throw new UsernameNotFoundException("User is not Present in the DB");
		}
		return userDetails;

	}
*/
}
