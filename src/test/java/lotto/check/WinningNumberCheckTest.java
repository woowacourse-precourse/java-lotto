package lotto.check;

import lotto.check.WinningNumberCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberCheckTest {

    WinningNumberCheck winningNumberCheck;
    @BeforeEach
    void init(){
        winningNumberCheck = new WinningNumberCheck();
    }
    @Test
    void winningNumberTest() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber).isEqualTo(
                winningNumberCheck.check("1,2,3,4,5,6")
        );
    }
}