package BookMyVax.BookMyVax.Entity;

import BookMyVax.BookMyVax.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    int id;
    String name;
    int age;
    @Column(unique =true)
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;

}