package BookMyVax.BookMyVax.Dto.RequestDto;

import BookMyVax.BookMyVax.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CenterRequestDto {
    String name;
    CenterType centerType;
    String address;

}
