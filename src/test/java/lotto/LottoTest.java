package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.application.service.validator.ValueValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1() {
        List<Integer> inputValue = List.of(1, 2, 0, 4, 5, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 46, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 정수형이 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1_3() {
        String[] lottoNumbers = Console.readLine().split(",");
        List<String> inputValue = List.of("1", ",", ".", "4", "46", "6");
        List<Integer> convertedLottoNumbers = new ArrayList<>();
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 1, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 6, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_3() {
        List<Integer> inputValue = List.of(6, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_4() {
        List<Integer> inputValue = List.of(6, 6, 3, 4, 5, 1);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구매한 값을 0으로 입력했을 때")
    @Test
    void 로또구매금액_실패_1() {
        String lottoPurchaseMoney = "0";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구매한 값이 0으로 나누어 떨어지지 않을 때")
    @Test
    void 로또구매금액_실패_1_2() {
        String lottoPurchaseMoney = "1001";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액을 Integer 범위를 초과한 입력을 했을 때")
    @Test
    void 로또구매금액_실패_2() {
        String lottoPurchaseMoney = "2147483648";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 갯수 출력")
    @Test
    void 구매한로또갯수출력() {
        System.out.println("구매금액을 입력해 주세요.");
        int inputValue = 110000;
        System.out.printf("%d개를 구매했습니다.", inputValue / 1000);
    }
}
