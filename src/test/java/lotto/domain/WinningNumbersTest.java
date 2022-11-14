package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumbersTest {
    @Test
    @DisplayName("중복 문자")
    void DuplicateNumber() {
        // given
        Lotto lottoNumbers = new Lotto("1,2,3,4,5,6");

        // when
        int bonusNumber = 1;

        // then
        assertThatThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD"
            , "1,2,3,4,8,9:FOURTH", "1,2,3,8,9,10:FIFTH"}, delimiter = ':')
    @DisplayName("n등 당첨 결과 반환")
    void RankPrice(String input, LottoRank expect) {
        // given
        Lotto lottoNumbers = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(input);

        // then
        assertThat(winningNumbers.calculateRanking(myLotto)).isEqualTo(expect);
    }
}