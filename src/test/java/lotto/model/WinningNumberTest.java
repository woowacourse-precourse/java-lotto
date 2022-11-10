package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호 저장")
    @Test
    void saveWinningNumberTest() {
        String inputWinningNumber = "1,40,27,10,3,33";

        List<Integer> testWinningNumber = List.of(1, 3, 10, 27, 33, 40);

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(inputWinningNumber);

        assertEquals(winningNumber.getWinningNumbers(), testWinningNumber);
    }

    @DisplayName("보너스 번호 저장")
    @Test
    void saveBonusNumberTest() {
        String inputBonusNumber = "12";
        int testBonusNumber = 12;

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setBonusNumber(inputBonusNumber);

        assertEquals(winningNumber.getBonusNumber(), testBonusNumber);
    }

}