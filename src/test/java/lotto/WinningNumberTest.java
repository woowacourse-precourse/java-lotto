package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    WinningNumber winningNumber = new WinningNumber();

    @DisplayName("당첨 번호 입력 테스트")
    @Test
    void createLuckyNumberTest() {
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> luckyNumbers = winningNumber.createLuckyNumber();
        assertThat(luckyNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Test
    void createBonusNumberTest() {
        List<Integer> luckyNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int BonusNumbers = winningNumber.createBonusNumber(luckyNumbers);
        assertThat(BonusNumbers).isEqualTo(7);
    }
}