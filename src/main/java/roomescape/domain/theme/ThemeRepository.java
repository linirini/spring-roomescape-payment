package roomescape.domain.theme;

import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ThemeRepository {

    boolean existsByName(ThemeName name);

    List<Theme> findByReservationTermAndLimit(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("limit") long limit);

    Optional<Theme> findById(long id);

    void deleteById(long id);

    List<Theme> findAll();

    Theme save(Theme theme);
}
