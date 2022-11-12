package lotto;

import lotto.domain.Issue;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 숫자가 1~45 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutofRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 55, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 입력번호를 비교한다")
    @Test
    void compareLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int result = 3;
        assertThat(result).isEqualTo(lotto.compare(List.of(1, 3, 4, 8, 10, 32)));
    }
    @DisplayName("로또 구입 금액이 1000단위가 아니라면 예외 처리 한다")
    @ParameterizedTest
    @CsvSource({"900", "1100", "3", "2001"})
    void convertMoneyByWrongUnit(String input) {
        assertThatThrownBy(() -> new Issue(Integer.parseInt(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 발행에서 예외가 발생한다.")
    @Test
    void issueLottoByException() {
        assertThatThrownBy(() -> new Issue(1000).createLottoNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
