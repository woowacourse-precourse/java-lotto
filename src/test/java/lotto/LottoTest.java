package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("당첨 번호를 받아 로또 결과를 반환한다.")
    @Test
    void getResultTest() {
        // Given
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 7;

        Lotto firstRank = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondRank = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdRank = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourthRank = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto fifthRank = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lotto nothing = new Lotto(List.of(1, 10, 11, 12, 13, 14));

        // When
        final LottoResult firstRankResult = firstRank.getResult(winningNumbers, bonusNumber);
        final LottoResult secondRankResult = secondRank.getResult(winningNumbers, bonusNumber);
        final LottoResult thirdRankResult = thirdRank.getResult(winningNumbers, bonusNumber);
        final LottoResult fourthRankResult = fourthRank.getResult(winningNumbers, bonusNumber);
        final LottoResult fifthRankResult = fifthRank.getResult(winningNumbers, bonusNumber);
        final LottoResult nothingResult = nothing.getResult(winningNumbers, bonusNumber);

        // Then
        assertAll("로또 당첨 결과 테스트",
                () -> assertThat(firstRankResult).isEqualTo(LottoResult.FIRST),
                () -> assertThat(secondRankResult).isEqualTo(LottoResult.SECOND),
                () -> assertThat(thirdRankResult).isEqualTo(LottoResult.THIRD),
                () -> assertThat(fourthRankResult).isEqualTo(LottoResult.FOURTH),
                () -> assertThat(fifthRankResult).isEqualTo(LottoResult.FIFTH),
                () -> assertThat(nothingResult).isEqualTo(LottoResult.NOTHING)
        );
    }
}
