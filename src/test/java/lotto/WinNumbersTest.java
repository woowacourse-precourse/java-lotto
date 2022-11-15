package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinNumbersTest {
    @Test
    @DisplayName("생성자 생성 성공")
    void testWinNumberTest() {
        List<Integer> winNumberList = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 9;
        WinNumbers winNumbers = new WinNumbers(winNumberList, bonusNumber);

        assertThat(winNumbers.getWinNumbers()).isEqualTo(winNumberList);
        assertThat(winNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
