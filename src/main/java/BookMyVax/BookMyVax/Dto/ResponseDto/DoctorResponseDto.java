package BookMyVax.BookMyVax.Dto.ResponseDto;

import BookMyVax.BookMyVax.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorResponseDto {
    String name;
    String message;
    CenterResponseDto centerResponseDto;
}
