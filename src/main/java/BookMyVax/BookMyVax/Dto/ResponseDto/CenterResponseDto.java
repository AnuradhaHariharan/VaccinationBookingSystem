package BookMyVax.BookMyVax.Dto.ResponseDto;

import BookMyVax.BookMyVax.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterResponseDto {
    String name;
    CenterType centerType;
    String address;
}
