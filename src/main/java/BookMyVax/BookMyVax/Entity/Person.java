package BookMyVax.BookMyVax.Entity;

import BookMyVax.BookMyVax.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique =true)
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;
    boolean isDoseOneTaken;
    boolean isDoseTwoTaken;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL) // one person can have multiple does thats y using list
    List<Dose> doses= new ArrayList<>();

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    Certificate certificate;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Appointments>appointments=new ArrayList<>(); //initially appoitmtmts will be zero and one person can have multiple appoitments
}
