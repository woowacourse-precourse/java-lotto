package lotto;

import lotto.domain.Issue;
import lotto.domain.Lotto;
import lotto.service.CoincideNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
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

    @DisplayName("당첨 번호의 숫자와 보너스 번호의 숫자가 중복이 있다면 예외가 발생한다.")
    @Test
    void createBonusNumByDuplicatedWinNum() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.addBonusNum("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 입력번호를 비교한다")
    @Test
    void compareLottoNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = 3;
        assertThat(result).isEqualTo(lotto.compare(new Lotto(Arrays.asList(
        1, 3, 4, 8, 10, 32))));
    }
    @DisplayName("로또 구입 금액이 1000단위가 아니라면 예외 처리 한다")
    @ParameterizedTest
    @CsvSource({"900", "1100", "3", "2001"})
    void convertMoneyByWrongUnit(String input) {
        assertThatThrownBy(() -> new Issue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨통계가 정상적으로 계산되는지 확인한다")
    @Test
    void calculateWinStaticics() {
        CoincideNumber.plusCountOfRank(5);
        int count = 1;
        assertThat(count).isEqualTo(CoincideNumber.FIVE_BONUS_COINCIDE.count());
    }

    @DisplayName("수익률이 정상적으로 계산되는지 확인한다")
    @Test
    void calculateRevenue() {
        Issue issue = new Issue("5000");
        double result = (100000/5000)*100;
        assertThat(result).isEqualTo(issue.revenue(100000));
    }


}
