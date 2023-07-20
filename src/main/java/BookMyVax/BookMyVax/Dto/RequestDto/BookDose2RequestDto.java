package BookMyVax.BookMyVax.Dto.RequestDto;

import BookMyVax.BookMyVax.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDose2RequestDto {
    int id;
    DoseType doseType;
    Boolean firstDose;

    {
    }
}