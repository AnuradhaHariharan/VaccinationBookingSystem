package BookMyVax.BookMyVax.Entity;

import BookMyVax.BookMyVax.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String vaccinId;
    @Enumerated(EnumType.STRING)
    DoseType doseType;
    @CreationTimestamp
    Date vaccinationDate;
    @ManyToOne //many is the current class
    @JoinColumn //by default adds primary column to child as foreign key
    Person person;
}
