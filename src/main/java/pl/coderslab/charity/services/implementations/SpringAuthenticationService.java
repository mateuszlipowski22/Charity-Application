package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.CurrentUser;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.interfaces.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class SpringAuthenticationService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user == null) {throw new UsernameNotFoundException(email); }

        if(user.getEnabled()) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            user.getRoles().forEach(r ->
                    grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
            return new CurrentUser(user.getEmail(), user.getPassword(),
                    grantedAuthorities, user);
        }else {
            throw new UsernameNotFoundException("username not found");
        }
    }
}