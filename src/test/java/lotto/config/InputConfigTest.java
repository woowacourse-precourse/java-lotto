package lotto.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputConfigTest {

    private String errorStartMsg = InputConfig.ERROR_MESSAGE;

    @Test
    @DisplayName("구매 금액의 유효성 테스트_가격으로 나누어지지 않음")
    void purchase_input_test_not_divide() {
        String input = "2001";
        assertThatThrownBy(() -> InputConfig.checkPurchaseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("구매 금액의 유효성 테스트_long 범위 초과")
    void purchase_input_test_more_than_long_range() {
        String input = "10000000000000000000000000000";
        assertThatThrownBy(() -> InputConfig.checkPurchaseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("구매 금액의 유효성 테스트_숫자가 아님")
    void purchase_input_test_not_number() {
        String input = "sdfsdf";
        assertThatThrownBy(() -> InputConfig.checkPurchaseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("구매 금액의 유효성 테스트_0보다 작음")
    void purchase_input_test_less_than_zero() {
        String input = "-1000";
        assertThatThrownBy(() -> InputConfig.checkPurchaseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("구매 금액의 유효성 테스트_정상 입력")
    void purchase_input_test() {
        String input = "22000";
        assertDoesNotThrow(() -> InputConfig.checkPurchaseInput(input));
    }

    @Test
    @DisplayName("당첨 로또 유효성 확인_중복입력")
    void prize_lotto_test_overlap() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);       // 중복됐다 가정
        int bonus = 10;
        assertThatThrownBy(() -> InputConfig.checkPrizeLotto(set, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("당첨 로또 유효성 확인_초과 입력")
    void prize_lotto_test_over_size() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6, 7);
        int bonus = 10;
        assertThatThrownBy(() -> InputConfig.checkPrizeLotto(set, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("당첨 로또 유효성 확인_보너스 번호 중복")
    void prize_lotto_test_bonus_overlap() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        int bonus = 1;
        assertThatThrownBy(() -> InputConfig.checkPrizeLotto(set, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("당첨 로또 유효성 확인_범위 초과")
    void prize_lotto_test_over_value_range() {
        int rangeOverNum = InputConfig.END_INCLUSIVE + 1;
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, rangeOverNum);
        int bonus = 10;
        assertThatThrownBy(() -> InputConfig.checkPrizeLotto(set, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(errorStartMsg);
    }

    @Test
    @DisplayName("당첨 로또 유효성 확인_정상입력")
    void prize_lotto_test() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;

        assertDoesNotThrow(() -> InputConfig.checkPrizeLotto(set, bonus));
    }
}