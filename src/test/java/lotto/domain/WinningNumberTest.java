package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class WinningNumberTest {

    @Test
    @DisplayName("보너스 숫자가 로또 숫자와 중복될 경우 에러를 발생한다.")
    void test() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        int bonusNumber = 1;

        // then
        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 결과를 정상 반환한다.")
    void prize() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // then
        assertThat(winningNumber.calculateRanking(myLotto)).isEqualTo(Ranking.SECOND);
    }
}