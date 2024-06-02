package roomescape.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import roomescape.domain.member.MemberRepository;
import roomescape.domain.reservation.ReservationRepository;
import roomescape.domain.reservationdetail.ReservationDetailRepository;
import roomescape.domain.schedule.ReservationTimeRepository;
import roomescape.domain.theme.ThemeRepository;
import roomescape.helper.DatabaseCleanerExtension;

@ExtendWith(DatabaseCleanerExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class ServiceTest {
    @Autowired
    protected MemberRepository memberRepository;
    @Autowired
    protected ReservationDetailRepository reservationDetailRepository;
    @Autowired
    protected ReservationRepository reservationRepository;
    @Autowired
    protected ThemeRepository themeRepository;
    @Autowired
    protected ReservationTimeRepository reservationTimeRepository;
}

