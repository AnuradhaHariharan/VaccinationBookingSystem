package BookMyVax.BookMyVax.Dto.RequestDto;

import BookMyVax.BookMyVax.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPersonRequestDto {
    String name;
    int age;
    String emailId;
    Gender gender;
}
