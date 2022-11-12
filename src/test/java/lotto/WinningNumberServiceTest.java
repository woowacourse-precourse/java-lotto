package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.domain.WinningNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberServiceTest{

    WinningNumberService winningNumberService = new WinningNumberService();

    @DisplayName("숫자가 아닌 input 테스트")
    @Test
    void 숫자가_아닌_경우_에러_테스트(){

        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        String input = "숫자,아님,숫자,아님,숫자,아님";
        assertThatThrownBy(() -> winningNumberService.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
