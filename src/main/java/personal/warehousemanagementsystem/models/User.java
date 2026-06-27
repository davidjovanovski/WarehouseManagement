package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.warehousemanagementsystem.models.enums.Role;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
