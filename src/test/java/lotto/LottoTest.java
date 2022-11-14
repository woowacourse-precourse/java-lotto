package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int inValidPayment = 14123;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.validatePayment(inValidPayment)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("서로 다른 6자리의 로또 번호를 생성한다.")
    @Test
    void generateLottoNumber() {

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int theNumberOfLotto = 6;
        List<List<Integer>> generatedLottoNumber = lotto.generateLottoNumber(6);
        assertThat(generatedLottoNumber.size()).isEqualTo(6);

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

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Integer> threeNumbersMatch = List.of(1, 2, 3, 12, 13, 14);
        List<Integer> fourNumbersMatch = List.of(1, 2, 3, 4, 10, 11);
        List<Integer> fiveNumbersMatch = List.of(1, 2, 3, 4, 5, 9);
        List<Integer> fiveAndBonusNumbersMatch = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> sixNumbersMatch = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getIndividualLottoScore(threeNumbersMatch, bonusNumber)).isEqualTo(3);
        assertThat(lotto.getIndividualLottoScore(fourNumbersMatch, bonusNumber)).isEqualTo(4);
        assertThat(lotto.getIndividualLottoScore(fiveNumbersMatch, bonusNumber)).isEqualTo(5);
        assertThat(lotto.getIndividualLottoScore(fiveAndBonusNumbersMatch, bonusNumber)).isEqualTo(7);
        assertThat(lotto.getIndividualLottoScore(sixNumbersMatch, bonusNumber)).isEqualTo(6);
    }

//    @DisplayName("각 로또의 점수를 계산한 뒤 매칭된 숫자와 보너스 일치 여부를 배열에 담아 리턴한다.")
//    @Test
//    void calculateLottoResult() {
//
//        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
//        int bonusNumber = 7;
//
//        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
//
//        List<Integer> sixNumbersMatch = List.of(1, 2, 3, 4, 5, 6);
//        List<Integer> fiveAndBonusNumbersMatch = List.of(1, 2, 3, 4, 5, 7);
//        List<Integer> fiveNumbersMatch = List.of(1, 2, 3, 4, 5, 9);
//        List<Integer> fourNumbersMatch = List.of(1, 2, 3, 4, 10, 11);
//        List<Integer> threeNumbersMatch = List.of(1, 2, 3, 12, 13, 14);
//        List<List<Integer>> purchaseRecord = List.of(sixNumbersMatch, fiveNumbersMatch, fiveAndBonusNumbersMatch, fourNumbersMatch, threeNumbersMatch);
//
//        List<Integer> winningRecord = new ArrayList<>(); // 3, 4, 5, 5 + bonus, 6
//
//        winningRecord.add(0);
//        winningRecord.add(0);
//        winningRecord.add(0);
//        winningRecord.add(0);
//        winningRecord.add(0);
//
//        for (List<Integer> currentLotto : purchaseRecord) {
//            int indexToIncrease = lotto.getIndividualLottoScore(currentLotto);
//
//            if (indexToIncrease < 0) {
//                continue;
//            }
//
//            int currentIndexCount = winningRecord.get(indexToIncrease);
//            winningRecord.set(indexToIncrease, currentIndexCount + 1);
//        }
//
//        assertThat(lotto.calculateLottoResult(purchaseRecord, winningRecord)).isEqualTo(List.of(1, 1, 1, 1, 1));
//
//    }
//
//    @DisplayName("수익률을 계산한 뒤 그 값을 리턴한다.")
//    @Test
//    void calculateYield() {
//
//        int totalPayment = 14000;
//
//        double prizeOne = 10000;
//        double prizeTwo = 10000000;
//        double prizeThree = 1500000;
//        double prizeFour = 50000;
//
//        String answerOne = String.format("%.1f", prizeOne / totalPayment);
//        String answerTwo = String.format("%.1f", prizeOne / totalPayment);
//        String answerThree = String.format("%.1f", prizeOne / totalPayment);
//        String answerFour = String.format("%.1f", prizeOne / totalPayment);
//
//        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
//
//        assertThat(lotto.calculateYield(prizeOne / totalPayment)).isEqualTo(answerOne);
//        assertThat(lotto.calculateYield(prizeTwo / totalPayment)).isEqualTo(answerTwo);
//        assertThat(lotto.calculateYield(prizeThree / totalPayment)).isEqualTo(answerThree);
//        assertThat(lotto.calculateYield(prizeFour / totalPayment)).isEqualTo(answerFour);
//    }

}
