package lotto;

import lotto.UI.User;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

class UserTest {
    OutputStream out = new ByteArrayOutputStream();
    InputStream in = System.in;

    @Test
    void lotteryPurchaseAmount() {
    }

    @Test
    void winningNumber() {
        String input = "1,2,3,4,57,6";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User user = new User();

        assertThat(user.winningNumber()).isEqualTo(List.of(1, 2, 3, 4, 57, 6));


    }
}