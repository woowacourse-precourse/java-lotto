package lotto.view;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MoneyReceiverTest {

    @Test
    public void getMoney() {
        int expected = 8_000;
        String userInput = readLine();
        assertThat(expected).isEqualTo(userInput);
    }
}
