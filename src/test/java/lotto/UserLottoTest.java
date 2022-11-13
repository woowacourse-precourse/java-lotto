package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoTest {
    @DisplayName("UserLotto 생성자 테스트")
    @Test
    public void userLottoConstructorTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        UserLotto userLotto = new UserLotto(numbers);

        // then
        assertThat(userLotto.getNumbers()).isEqualTo(numbers);
    }
}
