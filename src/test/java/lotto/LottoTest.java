package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("구매 금액에 문자가 들어간 경우 예외가 발생한다.")
    @Test
    void errorMessageTestInputPurchaseAmountIncludeCharacter() {
        assertSimpleTest(() -> {
            run("1000a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void errorMessageTestInputPurchaseAmountIsNotMultipleOf1000() {
        assertSimpleTest(() -> {
            run("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 1과 45사이에 없는 경우 예외가 발생한다.")
    @Test
    void errorMessageTestNumbersAreNotBetween1And45() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 중복인 경우 예외가 발생한다.")
    @Test
    void errorMessageTestNumbersAreDuplicate() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void errorMessageTestNumbersCountIsNot6() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호는 당첨 번호에 있는 경우 예외가 발생한다.")
    @Test
    void errorMessageTestBonusInWinNumbers() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,6","6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 1과 45사이에 없는 경우 예외가 발생한다.")
    @Test
    void errorMessageTestBonusIsNotBetween1And45() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,6","0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 문자가 있는경우 예외가 발생한다.")
    @Test
    void errorMessageTestBonusIncludeCharacter() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,6","0a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIsMultipleOf1000() {
        assertThatThrownBy(() -> Validation.isMultipleOf1000("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 문자가 포함됐을 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIncludeCharacter() {
        assertThatThrownBy(() -> Validation.isIncludeNotNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1미만이거나 45 초과할 경우 예외가 발생한다.")
    @Test
    void numbersAreNotBetween1And45() {
        assertThatThrownBy(() -> Validation.isLottoBetween1And45(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 8000원, 수익금 5000원의 수익률 계산 테스트")
    @Test
    void getProfitRateWhenPurchase8000AndEarn5000() {
        assertThat(Calculation.getProfitRate(8000, 5000))
                .isEqualTo("62.5%");
    }

    @DisplayName("구매 금액 5000, 수익금 5000원의 수익률 계산 테스트")
    @Test
    void getProfitRateWhenPurchase5000AndEarn5000() {
        assertThat(Calculation.getProfitRate(5000, 5000))
                .isEqualTo("100.0%");
    }

    @DisplayName("로또 1등 당첨 테스트")
    @Test
    void lottoRankIs1() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(5);
    }

    @DisplayName("로또 낙첨 테스트")
    @Test
    void lottoLosingTicket() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(8, 9, 10, 11, 12, 13)))
                .isEqualTo(0);
    }

    @DisplayName("로또 당첨 결과 1, 0, 0, 0, 0으로 62.5% 수익인 경우 당첨 결과 테스트")
    @Test
    void notificationLottoResult() {
        System.out.println(String.format(Notification.LOTTO_RESULT.getMessage(), 1, 0, 0, 0, 0, "62.5%"));
    }
}
