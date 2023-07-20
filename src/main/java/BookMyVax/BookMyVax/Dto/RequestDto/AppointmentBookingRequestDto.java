package BookMyVax.BookMyVax.Dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentBookingRequestDto {
int personId;
int doctorId;
}
