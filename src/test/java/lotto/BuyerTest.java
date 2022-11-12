package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {
    private static int validMoney;
    private static List<Integer> validNumbers;
    private static int validBouns;

    @BeforeAll
    private static void createValidData() {
        validMoney = 8_000;
        validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        validBouns = 9;
    }

    @DisplayName("돈이 구매 최소 단위로 안나누어지면 예외가 발생한다.")
    @Test
    void createMoneyByNotUnit() {
        assertThatThrownBy(() -> new Buyer(7500, validNumbers, validBouns))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Buyer(validMoney, List.of(1, 2, 3, 4, 5, 6, 7), validBouns))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복이 발생하면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Buyer(validMoney, List.of(1, 2, 3, 4, 5, 5), validBouns))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Buyer(validMoney, List.of(1, 2, 3, 4, 5, 46), validBouns))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복이 발생하면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplication() {
        assertThatThrownBy(() -> new Buyer(validMoney, validNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange() {
        assertThatThrownBy(() -> new Buyer(validMoney, validNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
