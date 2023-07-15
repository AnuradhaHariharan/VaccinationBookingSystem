package BookMyVax.BookMyVax.Dto.RequestDto;

import BookMyVax.BookMyVax.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDose1RequestDto {
    int id;
    DoseType doseType;

}
