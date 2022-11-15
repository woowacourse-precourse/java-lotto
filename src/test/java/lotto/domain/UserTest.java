package lotto.domain;

import lotto.exception.Exception;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    Exception exception = new Exception();

    @Test
    void 구매금액_천단위_입력_안할_때_예외테스트() {
        String input = "1001";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateIsThousandUnit(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]천 단위로 입력해주세요.")
        );
    }

    @Test
    void 구매금액_1000보다_적을_때_예외테스트() {
        String input = "0";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateIsLessThanThousand(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]구매금액은 1000 이상이어야 합니다.")
        );
    }

    @Test
    void 보너스번호_문자_입력될_때_예외처리_예외테스트() {
        String input = "C";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateIsNumeric(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]숫자만 입력해주세요.")
        );
    }

    @Test
    void 보너스번호_당첨번호와_중복되는지_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        exception.validateIsDuplicatedWithWinningLotto(new Lotto(List.of(1,2,3,4,5,6)),1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]보너스번호가 우승 번호와 중복됩니다.")
        );
    }
}