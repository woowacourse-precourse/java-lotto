package lotto;

import lotto.domain.User;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("개수만큼 Lotto List 를 만든다.")
    @Test
    void createUserLottos() {
        User user = new User(3);
        AssertionsForClassTypes.assertThat(user.getUserLottos().size()).isEqualTo(3);
    }

}
