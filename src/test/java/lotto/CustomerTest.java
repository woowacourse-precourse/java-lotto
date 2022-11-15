package lotto;

import lotto.enumeration.LottoRankInformation;
import lotto.user.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("입력값이 숫자인 경우 Customer 객체를 생성한다.")
    @Test
    void validateUnit() {
        assertThat(new Customer("1000"))
                .isInstanceOf(Customer.class);
    }

    @DisplayName("입력값이 숫자가 아닌 아닌 경우 예외가 발생한다.")
    @Test
    void validateUnitException() {
        assertThatThrownBy(() -> new Customer("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매내역을 출력한다.")
    @Test
    void printOutLottoList() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("1000");
            String result = "1개를 구매했습니다.\n" + List.of(1, 2, 3, 4, 5, 6);

            assertThat(input.toLottoString()).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨번호와 비교 후 맞는 번호 개수를 출력한다.")
    @Test
    void countTheDuplicateLottoNumbers() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("2000");
            List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> result = List.of(6, 4);

            assertThat(input.matchWinNumbers(winNumber)).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8));
    }

    @DisplayName("보너스 번호가 있는지 출력한다.")
    @Test
    void countTheDuplicateBonusNumber() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("3000");
            int bonusNumber = 1;
            List<Boolean> result = List.of(true, false, false);

            assertThat(input.matchBonusNumber(bonusNumber, List.of(5, 5, 4))).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8), List.of(1, 2, 3, 4, 5, 9));
    }

    @DisplayName("당첨 번호와 보너스 번호를 기준으로 등수를 매긴다.")
    @Test
    void createRankings() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Map<LottoRankInformation, Integer> input = new Customer("2000")
                    .createWinnings("1,2,3,4,5,7", "6");
            List<Integer> result = List.of(1, 1);

            assertThat(List.of(input.get(LottoRankInformation.SECOND), input.get(LottoRankInformation.FOURTH)))
                    .isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8));
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외를 출력한다.")
    @Test
    void validateDuplicationBetweenWinNumbersAndBonusNumber() {
        Customer input = new Customer("3000");
        assertThatThrownBy(() -> input.matchBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최종 통계를 출력한다.")
    @Test
    void printResult() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("2000");
            input.createWinnings("1,2,3,4,5,7", "6");
            String result = "당첨 통계\n" +
                    "---\n" +
                    "3개 일치 (5,000원) - 0개\n" +
                    "4개 일치 (50,000원) - 1개\n" +
                    "5개 일치 (1,500,000원) - 0개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                    "6개 일치 (2,000,000,000원) - 0개\n" +
                    "총 수익률은 1502500.0%입니다.";

            assertThat(input.toResultString())
                    .isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8));
    }

}
