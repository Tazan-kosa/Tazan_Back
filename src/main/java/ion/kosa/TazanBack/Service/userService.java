package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.model.dto.ReduplicationDto;
import ion.kosa.TazanBack.model.User;
import org.springframework.transaction.annotation.Transactional;


public interface userService {


    @Transactional
    public User join(User user);

    public String usernameCheck(ReduplicationDto reduplicationDto);
    public String nicknameCheck(ReduplicationDto reduplicationDto);

}
