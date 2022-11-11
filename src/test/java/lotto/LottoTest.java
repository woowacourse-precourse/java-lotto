package lotto;

import lotto.application.service.validator.ValueValidator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1() {
        List<Integer> inputValue = List.of(1, 2, 0, 4, 5, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 46, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 로또 당첨번호가 하나의 입력값이 아닌 경우")
    @Test
    void 보너스로또당첨번호입력받기_실패() {
        String inputValue = "1,2,3,4,5,6";
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateIntegerValue(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 로또 당첨번호가 숫자가 아닌경우")
    @Test
    void 보너스로또당첨번호입력받기_실패2() {
        String inputValue = "j";
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateIntegerValue(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 로또 당첨번호가 공백인 경우")
    @Test
    void 보너스로또당첨번호입력받기_실패3() {
        String inputValue = " ";
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateIntegerValue(inputValue);
                }).withMessageContaining("[ERROR]");
    }


    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 1, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 6, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_3() {
        List<Integer> inputValue = List.of(6, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_4() {
        List<Integer> inputValue = List.of(6, 6, 3, 4, 5, 1);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("사용자가 구매한 값을 0으로 입력했을 때")
    @Test
    void 로또구매금액_실패_1() {
        String lottoPurchaseMoney = "0";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("사용자가 구매한 값이 0으로 나누어 떨어지지 않을 때")
    @Test
    void 로또구매금액_실패_1_2() {
        String lottoPurchaseMoney = "1001";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 구매 금액을 Integer 범위를 초과한 입력을 했을 때")
    @Test
    void 로또구매금액_실패_2() {
        String lottoPurchaseMoney = "2147483648";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 갯수와 발급받은 로또 갯수 비교")
    @Test
    void 구매한_로또_갯수와_발급받은_로또_갯수_비교() {
        int purchaseNumber = 11;
        List<List<Integer>> generateLottoNumber = Lotto.generateLottoNumber(purchaseNumber);
        assertThat(generateLottoNumber.size()).isEqualTo(11);
    }

    @DisplayName("수익률 계산")
    @Test
    void 수익률_계산() {
        int purchaseMoney = 8000;
        int winningMoney = 5000;
        double yield = (double) winningMoney / (double) purchaseMoney * 100;

        assertThat(Math.round(yield * 10) / 10.0).isEqualTo(62.5);
    }

    @DisplayName("수익률이 100일때 출력형식 검증")
    @Test
    void 수익률이100일때_출력형식_검증() {
        int purchaseMoney = 5000;
        int winningMoney = 5000;
        double yield = (double) winningMoney / (double) purchaseMoney * 100;

        assertThat(Math.round(yield * 10) / 10.0).isEqualTo(100.0);
    }

    @DisplayName("수익률 소수점 둘째자리에서 반올림")
    @Test
    void 수익률_소수점_둘째자리에서_반올림() {
        int purchaseMoney = 9000;
        int winningMoney = 15000;
        double yield = (double) winningMoney / (double) purchaseMoney * 100;

        assertThat(Math.round(yield * 10) / 10.0).isEqualTo(166.7);
    }
}
