package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.userVO;
import ion.kosa.TazanBack.model.Role;
import ion.kosa.TazanBack.model.dto.ReduplicationDto;
import ion.kosa.TazanBack.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ion.kosa.TazanBack.DAO.userDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final userDAO userDAO;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User join(User user){

        String raw = user.getPassWord();
        String enc = encoder.encode(raw);
        user.setPassWord(enc);
        user.setAuth(Role.ROLE_USER);
        return userDAO.save(user);
    }

    public String usernameCheck(ReduplicationDto reduplicationDto){
        User user = userDAO.findByName(reduplicationDto.getUsername());
        if (user==null) {
            return "사용 가능한 메일입니다.";
        }
        return "중복된 이메일 입니다.";
    }
    public String nicknameCheck(ReduplicationDto reduplicationDto){
        User user = userDAO.findByNickName(reduplicationDto.getNickname());
        if (user==null) {
            return "사용 가능한 닉네임입니다.";
        }
        return "중복된 닉네임 입니다.";
    }
    public List<userVO> usermanageList(){
        List<User> users =userDAO.findAll();

        return dataToVO(users);
    }

    public List<userVO>dataToVO(List<User> users){
        Iterator iterator=users.iterator();
        List<userVO> vo = new ArrayList<>();
        while(iterator.hasNext()){
            User user = (User)iterator.next();
            userVO uservo = new userVO();
            uservo.setAuth(user.getAuth());
            uservo.setUserID(user.getUserID());
            uservo.setEmail(user.getEmail());
            uservo.setPassWord(user.getPassWord());
            uservo.setNickName(user.getNickName());
            uservo.setPhoneNumber(user.getPhoneNumber());
            uservo.setName(user.getName());
            vo.add(uservo);
        }
        return vo;
    }
}