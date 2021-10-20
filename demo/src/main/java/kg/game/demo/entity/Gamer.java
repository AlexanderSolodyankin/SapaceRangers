package kg.game.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="gamer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Gamer extends AbstractBaseEntity{
    @Column(name = "full_name")
    private String fullName;
    private Long age;
    private String gender;
}
