package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {
    WinningNumbers winningNumbers;


    @BeforeEach
    void setUP(){
        winningNumbers = new WinningNumbers();
    }

    @DisplayName("당첨번호가 리스트로 잘 변환되는지 확인")
    @Test
    void finalWinningNumbers(){
        //given
        String winningNumber = "1,2,3,4,5,6,";

        //when
        List<Integer> actual = winningNumbers.finalWinningNumbers(winningNumber);

        //then
        assertThat(actual).contains(1,2,3,4,5,6);
    }
}
