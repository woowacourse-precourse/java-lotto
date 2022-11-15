package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("User 생성자 테스트")
    @Test
    void userConstructTest() {
        // given
        int price = 1000;


        // when
        User user = new User(price);


        // then
        assertThat(user.getPrice()).isEqualTo(price);
    }
}
