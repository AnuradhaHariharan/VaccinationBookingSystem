package BookMyVax.BookMyVax.Dto.RequestDto;

import BookMyVax.BookMyVax.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorRequestDto {
    int centerId;
    String name;
    int age;
    String emailId;
    Gender gender;
}
