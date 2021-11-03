package ion.kosa.TazanBack.config.auth;

import ion.kosa.TazanBack.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// /login요청시 동작
@Service
@RequiredArgsConstructor
public class PrincipalDetailSerivce implements UserDetailsService {

    private final ion.kosa.TazanBack.DAO.userDAO userDAO;
    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User userEntity = userDAO.findByName(username);
        User userEntity = userDAO.findByEmail(email);
        return new PrincipalDetails(userEntity);
    }
}
