package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {
    @DisplayName("로또 구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void ValidatePurchaseAmountTest1() {
        Integer purchaseAmount = 4500;
        assertThatThrownBy(() -> Controller.ValidatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 보다 작은 경우 예외가 발생한다.")
    @Test
    void ValidatePurchaseAmountTest2() {
        Integer purchaseAmount = 900;
        assertThatThrownBy(() -> Controller.ValidatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행한 로또를 분석하는 메소드를 테스트한다.")
    @Test
    void AnalyzePlayerNumbersTest1() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<List<Integer>> publishedLottoArray = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        assertEquals(1, Controller.AnalyzePlayerNumbers
                (numbers, publishedLottoArray).get(1));
    }

    @DisplayName("발행한 로또를 분석하는 메소드를 테스트한다.")
    @Test
    void AnalyzePlayerNumbersTest2() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<List<Integer>> publishedLottoArray = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 8, 7)));
        assertEquals(1, Controller.AnalyzePlayerNumbers
                (numbers, publishedLottoArray).get(2));
    }
}