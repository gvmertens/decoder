package br.com.mertens.ead.authuser.models;

import br.com.mertens.ead.authuser.enums.UserStatus;
import br.com.mertens.ead.authuser.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_USERS")
public class UserModel extends RepresentationModel<UserModel> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 255)
    @JsonIgnore
    private String password;
    @Column(nullable = false, length = 150)
    private String fullName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 20)
    private String cpf;
    @Column(length = 20)
    private String imageUrl;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;

    public UserCourseModel convertToUserCourseModel(UUID courseId){
        return new UserCourseModel(null, courseId, this);
    }
}
