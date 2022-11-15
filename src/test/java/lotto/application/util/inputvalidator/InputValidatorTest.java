package lotto.application.util.inputvalidator;

import lotto.application.service.lottonumber.LottoNumberGenerator;
import lotto.application.service.lottonumber.LottoNumberGeneratorImpl;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.application.util.inputvalidator.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator = InputValidatorImpl.getInputValidatorInstance();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGeneratorImpl();

    @DisplayName("사용자가 구매한 값을 0으로 입력했을 때")
    @Test
    void 로또구매금액_실패_1() {
        String lottoPurchaseMoney = "0";
        assertThatThrownBy(() -> inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining(PURCHASE_MONEY_DIVIDABLE.getErrorMessage());
    }

    @DisplayName("사용자가 구매한 값이 0으로 나누어 떨어지지 않을 때")
    @Test
    void 로또구매금액_실패_1_2() {
        String lottoPurchaseMoney = "1001";
        assertThatThrownBy(() -> inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining(PURCHASE_MONEY_DIVIDABLE.getErrorMessage());
    }

    @DisplayName("로또 구매 금액을 Integer 범위를 초과한 입력을 했을 때")
    @Test
    void 로또구매금액_실패_2() {
        String lottoPurchaseMoney = "2147483648";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining(PURCHASE_MONEY_IS_INTEGER.getErrorMessage());
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1() {
        List<Integer> inputValue = List.of(1, 2, 0, 4, 5, 6);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateInputLottoNumbers(inputValue);
                }).withMessageContaining(WINNING_NUMBERS_RANGE.getErrorMessage());
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 46, 6);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateInputLottoNumbers(inputValue);
                }).withMessageContaining(WINNING_NUMBERS_RANGE.getErrorMessage());
    }


    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 중복된 값이 중간에 나타나는 경우 ")
    @Test
    void 로또당첨번호입력받기_실패2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 1, 6);
        assertThatThrownBy(() -> inputValidator.validateInputLottoNumbers(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateInputLottoNumbers(inputValue);
                }).withMessageContaining(WINNING_NUMBERS_ARE_OVERLAPPED.getErrorMessage());
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 마지막 인덱스와 그 직전 인덱스가 중복된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 6, 6);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateInputLottoNumbers(inputValue);
                }).withMessageContaining(WINNING_NUMBERS_ARE_OVERLAPPED.getErrorMessage());
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 첫 번째 인덱스와, 마지막 인덱스가 중복된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_3() {
        List<Integer> inputValue = List.of(6, 2, 3, 4, 5, 6);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateInputLottoNumbers(inputValue);
                }).withMessageContaining(WINNING_NUMBERS_ARE_OVERLAPPED.getErrorMessage());
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 첫 번째 인덱스와, 직후의 인덱스가 중복될 경우")
    @Test
    void 로또당첨번호입력받기_실패2_4() {
        List<Integer> inputValue = List.of(6, 6, 3, 4, 5, 1);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateInputLottoNumbers(inputValue);
                }).withMessageContaining(WINNING_NUMBERS_ARE_OVERLAPPED.getErrorMessage());
    }

    @DisplayName("보너스 로또 당첨번호가 하나의 입력값이 아닌 경우")
    @Test
    void 보너스로또당첨번호입력받기_실패() {
        String inputValue = "1,2,3,4,5,6";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateBonusNumberIsInteger(inputValue);
                }).withMessageContaining(BONUS_NUMBER_IS_INTEGER.getErrorMessage());
    }

    @DisplayName("보너스 로또 당첨번호가 숫자가 아닌경우")
    @Test
    void 보너스로또당첨번호입력받기_실패2() {
        String inputValue = "j";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateBonusNumberIsInteger(inputValue);
                }).withMessageContaining(BONUS_NUMBER_IS_INTEGER.getErrorMessage());
    }

    @DisplayName("보너스 로또 당첨번호가 공백인 경우")
    @Test
    void 보너스로또당첨번호입력받기_실패3() {
        String inputValue = " ";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    inputValidator.validateBonusNumberIsInteger(inputValue);
                }).withMessageContaining(BONUS_NUMBER_IS_INTEGER.getErrorMessage());
    }

    @DisplayName("구매한 로또 갯수와 발급받은 로또 갯수 비교")
    @Test
    void 구매한_로또_갯수와_발급받은_로또_갯수_비교() {
        int purchaseNumber = 11000;
        List<Lotto> generateLottoNumber = lottoNumberGenerator.generateLottoNumber(purchaseNumber);
        assertThat(generateLottoNumber.size()).isEqualTo(11);
    }

    @DisplayName("구매한 로또가 6개의 수로 이루어졌는지 체크")
    @Test
    void 구매한_로또가_6개의_수로_이루어졌는지_체크() {
        int purchaseNumber = 11000;
        List<Lotto> generateLottoNumber = lottoNumberGenerator.generateLottoNumber(purchaseNumber);
        for (Lotto lotto : generateLottoNumber) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }

    @DisplayName("당첨 로또 번호 갯수 검증, 보너스 번호 미포함")
    @Test
    void 당첨_로또_번호_갯수_검증_보너스_번호_미포함() {
        List<Integer> winningLottoNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};

        inputValidator.validateWinningNumbersLengthIsSix(winningLottoNumbers);
        inputValidator.validateInputLottoNumbers(winningLottoNumbers);

        assertThat(winningLottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("당첨 로또 번호 갯수 검증, 보너스 번호 포함")
    @Test
    void 당첨_로또_번호_갯수_검증_보너스_번호_포함() {
        List<Integer> winningLottoNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        inputValidator.validateWinningNumbersLengthIsSix(winningLottoNumbers);
        inputValidator.validateInputLottoNumbers(winningLottoNumbers);

        String inputBonusNumber = "7";
        inputValidator.validateInputBonusLottoNumber(inputBonusNumber, winningLottoNumbers);
        winningLottoNumbers.add(Integer.valueOf(inputBonusNumber));

        assertThat(winningLottoNumbers.size()).isEqualTo(7);
    }
}