package roomescape.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.domain.reservation.Reservation;
import roomescape.domain.waiting.Waiting;

public record UserReservationResponse(
        Long id,
        String theme,
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
        @JsonFormat(pattern = "HH:mm") LocalTime time,
        String status
) {

    public static UserReservationResponse create(Reservation reservation) {
        return new UserReservationResponse(
                reservation.getId(),
                reservation.getTheme().getThemeName(),
                reservation.getDate(),
                reservation.getTime().getStartAt(),
                "예약"
        );
    }

    public static UserReservationResponse createByWaiting(Waiting waiting) {
        Reservation reservation = waiting.getReservation();
        return new UserReservationResponse(
                reservation.getId(),
                reservation.getTheme().getThemeName(),
                reservation.getDate(),
                reservation.getTime().getStartAt(),
                String.format("%d번째 예약 대기", waiting.getWaitingOrderValue())
        );
    }
}
