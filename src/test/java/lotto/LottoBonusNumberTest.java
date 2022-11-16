package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoBonusNumber;
import org.junit.jupiter.api.Test;


class LottoBonusNumberTest {
    @Test
    void 숫자_이외에_값_입력() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new LottoBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_범위_이외에_값_입력() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new LottoBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}