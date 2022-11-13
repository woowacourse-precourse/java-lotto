package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validatePaymentTest() {
        int validPayment = 140000;
        int inValidPayment = 14123;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.validatePayment(validPayment)).isEqualTo(true);
        assertThat(lotto.validatePayment(inValidPayment)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("두 개의 숫자가 일치하는지 여부를 리턴한다.")
    @Test
    void checkNumbersMatch() {
        int target = 1;
        int matchCase = 1;
        int notMatchCase = 2;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(lotto.checkNumberMatch(target, matchCase)).isEqualTo(1);
        assertThat(lotto.checkNumberMatch(target, notMatchCase)).isEqualTo(0);
    }

    @DisplayName("입력된 로또 하나의 점수를 계산하여 점수에 해당하는 인덱스를 리턴한다.")
    @Test
    void getIndividualLottoScore() {

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        List<Integer> threeNumbersMatch = List.of(1, 2, 3, 12, 13, 14);
        List<Integer> fourNumbersMatch = List.of(1, 2, 3, 4, 10, 11);
        List<Integer> fiveNumbersMatch = List.of(1, 2, 3, 4, 5, 9);
        List<Integer> fiveAndBonusNumbersMatch = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> sixNumbersMatch = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getIndividualLottoScore(threeNumbersMatch)).isEqualTo(0);
        assertThat(lotto.getIndividualLottoScore(fourNumbersMatch)).isEqualTo(1);
        assertThat(lotto.getIndividualLottoScore(fiveNumbersMatch)).isEqualTo(2);
        assertThat(lotto.getIndividualLottoScore(fiveAndBonusNumbersMatch)).isEqualTo(3);
        assertThat(lotto.getIndividualLottoScore(sixNumbersMatch)).isEqualTo(4);
    }

    @DisplayName("각 로또의 점수를 계산한 뒤 매칭된 숫자와 보너스 일치 여부를 배열에 담아 리턴한다.")
    @Test
    void calculateLottoResult() {

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        List<Integer> sixNumbersMatch = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> fiveAndBonusNumbersMatch = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> fiveNumbersMatch = List.of(1, 2, 3, 4, 5, 9);
        List<Integer> fourNumbersMatch = List.of(1, 2, 3, 4, 10, 11);
        List<Integer> threeNumbersMatch = List.of(1, 2, 3, 12, 13, 14);
        List<List<Integer>> purchaseRecord = List.of(sixNumbersMatch, fiveNumbersMatch, fiveAndBonusNumbersMatch, fourNumbersMatch, threeNumbersMatch);

        List<Integer> winningRecord = List.of(0, 0, 0, 0, 0); // 3, 4, 5, 5 + bonus, 6

        assertThat(lotto.calculateLottoResult(purchaseRecord, winningRecord)).isEqualTo(List.of(1, 1, 1, 1, 1));

    }

}
