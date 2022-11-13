package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {

    @DisplayName("당첨 값이 잘 들어가는지 체크")
    @Test
    void getWinningTest() {
        String str = "1,2,3,4,5,6";
        Winning winning = new Winning();
        List<Integer> num = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        winning.setWinnings(str);
        assertThat(winning.getWinnings()).isEqualTo(num);
    }
}
