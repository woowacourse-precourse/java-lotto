package lotto;

import lotto.service.RankService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    RankService rankService = new RankService();

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void generateWinningLotto(){
        String winningNumbers = "1,2,3,4,5,6";
        String bonus = "7";
        assertThatCode(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).doesNotThrowAnyException();
        System.out.println(rankService.generateWinningLotto(winningNumbers, bonus));
    }

    @Test
    @DisplayName("\',\'로 구분되지 않는 경우 예외 처리")
    void generateWinningLottoException(){
        String winningNumbers = "1 2 3 4 5 6";
        String bonus = "7";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위를 넘어가는 경우 예외 처리1")
    void generateWinningLottoException2(){
        String winningNumbers = "1 2 3 4 5 6";
        String bonus = "100";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위를 넘어가는 경우 예외 처리2")
    void generateWinningLottoException3(){
        String winningNumbers = "1 2 3 4 5 100";
        String bonus = "7";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
