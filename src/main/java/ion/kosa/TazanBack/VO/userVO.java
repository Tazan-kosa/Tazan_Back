package ion.kosa.TazanBack.VO;

import ion.kosa.TazanBack.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
public class userVO {

    private Long userID;
    private String nickName;
    private String phoneNumber;
    private String email;
    private String passWord;
    private Role auth;
    private String name;

}


