package roomescape.dto.reservationtime;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import roomescape.domain.ReservationTime.ReservationTime;

public record ReservationTimeResponse(
        Long id,

        @JsonFormat(pattern = "HH:mm")
        LocalTime startAt
) {

    public static ReservationTimeResponse from(ReservationTime reservationTime) {
        return new ReservationTimeResponse(
                reservationTime.getId(),
                reservationTime.getStartAt()
        );
    }
}
