package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.publisher.Lotto;
import lotto.publisher.WinnerLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusDuplicationFilterTest {

    private final WinnerLotto lotto = WinnerLotto.getInstance();

    @BeforeEach
    void init() {
        lotto.setWinnerLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("보너스 번호가 기존 로또 당첨번호와 중복될 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsDuplicated() {
        assertThatThrownBy(() -> new BonusDuplicationFilter().doFilter("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 기존 로또 당첨번호와 중복되지 않는 경우 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new BonusDuplicationFilter().doFilter("7"));
    }
}