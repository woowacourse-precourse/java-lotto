package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void userInput() {
        User user = new User();
        String userInput = "1001";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputUserMoney();
        });

        userInput = "500A";
        inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputUserMoney();
        });

        userInput = "3000";
        inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        user.inputUserMoney();
        user.calculateNumOfLotteries();
        assertThat(3).isEqualTo(user.getNumOfLotteries());
    }
}
