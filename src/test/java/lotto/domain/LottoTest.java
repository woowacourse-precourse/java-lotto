package lotto.domain;

import lotto.constants.enums.WinningResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("3개 이상의 번호 일치할때 당첨 결과 반환 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"1,2,3,4,5,6:10:0",
                    "2,3,4,5,6,7:1:1",
                    "2,3,4,5,6,7:10:2",
                    "3,4,5,6,7,8:10:3",
                    "3,5,6,7,8,9:10:4"},
            delimiter = ':'
    )
    void 로또와_당첨번호가_3개이상_일치하는_경우_당첨결과_반환(String lottoNumber, String bonusNumber, int winResultIndex) {
        // given
        List<WinningResultStatus> winningResultStatuses = List.of(
                WinningResultStatus.FIRST,
                WinningResultStatus.SECOND,
                WinningResultStatus.THIRD,
                WinningResultStatus.FOURTH,
                WinningResultStatus.FIFTH
        );
        WinningNumber winningNumber = new WinningNumber(List.of(lottoNumber, bonusNumber));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        WinningResultStatus winningResult = lotto.getWinningResultStatus(winningNumber);

        // then
        assertThat(winningResult).isEqualTo(winningResultStatuses.get(winResultIndex));
    }

    @DisplayName("당첨 번호가 하나도 없을때 결과 반환 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"5,6,7,8,9,10:45",
                    "6,7,8,9,10,11:45",
                    "12,13,14,15,16,17:45",
                    "18,19,20,21,22,23:45",
                    "24,25,26,27,28,29:45"},
            delimiter = ':'
    )
    void 로또와_당첨번호가_3개미만_일치하는_경우_결과반환(String lottoNumber, String bonusNumber) {
        // given
        WinningNumber winningNumber = new WinningNumber(List.of(lottoNumber, bonusNumber));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        WinningResultStatus winningResult = lotto.getWinningResultStatus(winningNumber);

        // then
        assertThat(winningResult).isEqualTo(WinningResultStatus.NOTHING);
    }

}