package lotto.logic;

import lotto.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLogicTest {

    UserLogic userLogic = UserLogic.getInstance();

    User user = userLogic.makeUser(8000);

    @Test
    void userYield() {
        userLogic.increasePrize(user, 5000);
        Assertions.assertThat(userLogic.userYield(user)).isEqualTo(62.5d);
    }
}