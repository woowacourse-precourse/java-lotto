package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest extends NsTest {

    @DisplayName("보너스 숫자가 로또 번호에 있으면 예외가 발생한다.")
    @Test
    void choiceBonusNumberByLottoNumbers() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 45보다 클 때 예외가 발생한다.")
    @Test
    void choiceBonusNumberOver45() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 56))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 1보다 작을 때 예외가 발생한다.")
    @Test
    void choiceBonusNumberUnder1() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자를 문자로 입력한다.")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "one");
            assertThat(output());
        });
    }

    @DisplayName("사용자의 로또에 보너스가 포함돼있으면 true를 반환한다")
    @Test
    void isUserNumberIncludeBonusNumber() {
        Bonus bonus = new Bonus(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(bonus.checkNumber(Arrays.asList(7, 8, 9, 10, 11, 12))).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
