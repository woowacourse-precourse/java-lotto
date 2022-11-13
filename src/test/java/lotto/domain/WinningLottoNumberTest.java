package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumberTest {

    @DisplayName("입력받은 당첨 번호 숫자 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호_개수_테스트() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,4,5", "1")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호_중복_테스트() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,4,5,5", "1")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호_숫자_테스트() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,4,5,6", "a")).isInstanceOf(
                IllegalArgumentException.class);
    }
}
