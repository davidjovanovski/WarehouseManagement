package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.*;
import personal.warehousemanagementsystem.models.enums.Role;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String username;

    @ToString.Exclude
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String fullName, String username, String password, Role role){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
