package lotto.view;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    private InputView input = new InputView();

    @Test
    void getAmount() {
        assertThat(input.getAmount("2")).isEqualTo(2);
    }

   @Test
   void getWinningNumber() {
        assertThat(input.getWinningNumber("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
   }
}
