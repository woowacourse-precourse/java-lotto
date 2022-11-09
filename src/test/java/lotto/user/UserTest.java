package lotto.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static final String ERROR = "[ERROR]";

    @DisplayName("로또구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByWrongUnits() {
        // given
        String userAmount = "1200";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when then
        assertThatThrownBy(User::buyLotto)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }

    @DisplayName("로또 번호를 입력 후 리스트로 반환한다.")
    @Test
    void inputLottoNumbers() {
        //given
        String userInput = "1,2,3,4,5,6";
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        List<Integer> userNumbers = User.inputLottoNumbers();

        // then
        assertThat(numbers).isEqualTo(userNumbers);
    }
}
