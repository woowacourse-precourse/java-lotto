package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
     void 로또_구입_금액_입력(){
        int answer = 14000;
        String userInput = "14000";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        user.setPurchasePrice();

        assertThat(user.purchasePrice).isEqualTo(answer);
    }

    @Test
    void 로또_구입_금액_예외처리(){
        String userInput = "14500";

        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        User user = new User();
        assertThatThrownBy(() -> user.setPurchasePrice()).isInstanceOf(IllegalArgumentException.class);
    }
}