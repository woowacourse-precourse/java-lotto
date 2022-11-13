package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ModelTest{

    @DisplayName("사용자가 입력한 돈이 100단위 이하의 돈이나, 문자를 포함하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {15300, 15123})
    void inputMoneyHas100Units(int money) {
        Model model = new Model();
        assertThatThrownBy(() -> model.setUserMoney(money))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
