package lotto;

import lotto.data.Lotto;
import lotto.data.LottoNumber;
import lotto.data.LottoResult;
import lotto.data.PurchaseResult;
import lotto.data.WinningResult;
import lotto.output.calculation.LottoResultEvaluator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultEvaluatorTest {
    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_1() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(6);
    }

    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_2() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(7);
    }

    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_3() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(0);
    }


    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_4() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(40, 3, 42, 4, 44, 5));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(3);
    }

    @DisplayName("맞춘 숫자별 로또 개수를 세고 그 결과를 배열로 반환한다")
    @Test
    void countLottosByWinningResultTest() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto0 = new Lotto(List.of(40, 3, 42, 4, 44, 5)); // 3
        Lotto purchasedLotto1 = new Lotto(List.of(40, 41, 42, 43, 44, 45)); // 0
        Lotto purchasedLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 7
        Lotto purchasedLotto3 = new Lotto(List.of(40, 42, 44, 5, 1, 2)); // 3
        Lotto purchasedLotto4 = new Lotto(List.of(40, 7, 1, 2, 3, 6)); // 4
        Lotto purchasedLotto5 = new Lotto(List.of(9, 10, 11, 12, 13, 14)); // 0

        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(purchasedLotto0);
        purchasedLottos.add(purchasedLotto1);
        purchasedLottos.add(purchasedLotto2);
        purchasedLottos.add(purchasedLotto3);
        purchasedLottos.add(purchasedLotto4);
        purchasedLottos.add(purchasedLotto5);

        PurchaseResult purchaseResult = new PurchaseResult(6, purchasedLottos);

        int[] winningResults = new int[purchaseResult.getPurchasedAmount()];

        for (int i = 0; i < winningResults.length; i++) {
            winningResults[i] = lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLottos.get(i));
        }
        int[] actualResults = lottoResultEvaluator.countLottosByWinningResult(winningResults);
        int[] expectedResults = new int[]{2, 0, 0, 2, 1, 0, 0, 1};

        for (int i = 0; i < actualResults.length; i++) {
            assertThat(actualResults[i]).isEqualTo(expectedResults[i]);
        }
    }

    @DisplayName("맞춘 숫자별 로또 개수를 세고 그 결과를 배열로 반환한다")
    @Test
    void countLottosByWinningResult() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto0 = new Lotto(List.of(40, 3, 42, 4, 44, 5)); // 3
        Lotto purchasedLotto1 = new Lotto(List.of(40, 41, 42, 43, 44, 45)); // 0
        Lotto purchasedLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 7
        Lotto purchasedLotto3 = new Lotto(List.of(40, 42, 44, 5, 1, 2)); // 3
        Lotto purchasedLotto4 = new Lotto(List.of(40, 7, 1, 2, 3, 6)); // 4
        Lotto purchasedLotto5 = new Lotto(List.of(9, 10, 11, 12, 13, 14)); // 0

        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(purchasedLotto0);
        purchasedLottos.add(purchasedLotto1);
        purchasedLottos.add(purchasedLotto2);
        purchasedLottos.add(purchasedLotto3);
        purchasedLottos.add(purchasedLotto4);
        purchasedLottos.add(purchasedLotto5);

        PurchaseResult purchaseResult = new PurchaseResult(6, purchasedLottos);

        int[] winningResults = new int[purchaseResult.getPurchasedAmount()];

        for (int i = 0; i < winningResults.length; i++) {
            winningResults[i] = lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLottos.get(i));
        }
        int[] actualResults = lottoResultEvaluator.countLottosByWinningResult(winningResults);
        int[] expectedResults = new int[]{2, 0, 0, 2, 1, 0, 0, 1};

        for (int i = 0; i < actualResults.length; i++) {
            assertThat(actualResults[i]).isEqualTo(expectedResults[i]);
        }
    }

    @DisplayName("LottoResult가 상금 액수를 올바르게 반환한다")
    @Test
    void lottoResultGetPrizeTest() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto0 = new Lotto(List.of(40, 3, 42, 4, 44, 5)); // 3
        Lotto purchasedLotto1 = new Lotto(List.of(40, 41, 42, 43, 44, 45)); // 0
        Lotto purchasedLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 7
        Lotto purchasedLotto3 = new Lotto(List.of(40, 42, 44, 5, 1, 2)); // 3
        Lotto purchasedLotto4 = new Lotto(List.of(40, 7, 1, 2, 3, 6)); // 4
        Lotto purchasedLotto5 = new Lotto(List.of(9, 10, 11, 12, 13, 14)); // 0

        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(purchasedLotto0);
        purchasedLottos.add(purchasedLotto1);
        purchasedLottos.add(purchasedLotto2);
        purchasedLottos.add(purchasedLotto3);
        purchasedLottos.add(purchasedLotto4);
        purchasedLottos.add(purchasedLotto5);

        PurchaseResult purchaseResult = new PurchaseResult(6, purchasedLottos);

        int[] winningResults = new int[purchaseResult.getPurchasedAmount()];

        for (int i = 0; i < winningResults.length; i++) {
            winningResults[i] = lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLottos.get(i));
        }
        int[] actualResults = lottoResultEvaluator.countLottosByWinningResult(winningResults);

        LottoResult lottoResult = new LottoResult(actualResults);
        assertThat(lottoResult.getTotalPrizeAmount()).isEqualTo(2 * WinningResult.THREE.getPrizeAmount() +
                1 * WinningResult.FOUR.getPrizeAmount() + 1 * WinningResult.FIVE_AND_BONUS.getPrizeAmount());
    }
}