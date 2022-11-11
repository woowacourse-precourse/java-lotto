package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputLottoTest {
    static InputLotto inputLotto;

    @BeforeAll
    static void initAll() {
        inputLotto = new InputLotto();
    }

    @DisplayName("숫자가 아닌 값을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputMoneyTest1() {
        String input = "wrong";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputMoney());
    }

    @DisplayName("1000단위 숫자가 아닌 값을 넣으면 IllegalArgumentException 이 발생합니다.")
    @Test
    void inputMoneyTest2() {
        String input = "12450";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputLotto.inputMoney());
    }

    @DisplayName("정확한 값을 넣으면 그 값을 Integer 로 반환합니다.")
    @Test
    void inputMoneyTest3() {
        String input = "12000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputLotto.inputMoney()).isEqualTo(12000);
    }
}