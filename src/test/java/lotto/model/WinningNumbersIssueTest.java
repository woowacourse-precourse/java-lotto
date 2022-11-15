package lotto.model;

import lotto.model.Issue.WinningNumbersIssue;
import lotto.model.Issue.WinningNumbersIssueImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumbersIssueTest {

    @Test
    @DisplayName("당첨 번호 발행 성공")
    void case1(){
        //given
        String systemInput = "1,2,3,4,5,6";
        String bonusInput = "45";
        WinningNumbersIssue winningNumbersIssue = new WinningNumbersIssueImpl(systemInput,bonusInput);
        //when
        WinningNumbers result = winningNumbersIssue.getWinningNumbers();
        //then
        Assertions.assertThat(result.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        Assertions.assertThat(result.getBonusNumber()).isEqualTo(45);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 번호 있음")
    void case2(){
        //given
        String systemInput = "1,2,3,4,5,5";
        String bonusInput = "45";

        //when
        //then
        Assertions.assertThatThrownBy(()->{
            WinningNumbersIssue winningNumbersIssue = new WinningNumbersIssueImpl(systemInput,bonusInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
