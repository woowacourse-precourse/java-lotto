package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumberTest {
    @Test
    @DisplayName("당첨 번호, 보너스 번호 입력 성공")
    void input_WinningNumber_And_BonusNumber_Success(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "7";

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumber, bonus);
        assertThat(lottoWinningNumber).isNotNull();
    }

    @Test
    @DisplayName("당첨 번호 중복 입력 실패")
    void input_WinningNumber_Duplicated_Fail(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 5);
        String bonus = "7";

        assertThatThrownBy(() -> new LottoWinningNumber(winningNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 개수 부족 실패")
    void input_WinningNumber_CountLack_Fail(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5);
        String bonus = "5";

        assertThatThrownBy(() -> new LottoWinningNumber(winningNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 중복 입력 실패")
    void input_BonusNumber_Duplicated_Fail(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "5";

        assertThatThrownBy(() -> new LottoWinningNumber(winningNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 문자 입력 실패")
    void input_BonusNumber_NoNumber_Fail(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "a";

        assertThatThrownBy(() -> new LottoWinningNumber(winningNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}