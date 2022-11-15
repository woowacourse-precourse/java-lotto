package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class LottoGameTest {
    LottoGame lottoGame;
    @BeforeEach
    public void 테스트_전_LottoGame_초기화(){
        lottoGame = new LottoGame();
    }

    @DisplayName("정상 당첨 문자열을 파싱하면 아무 일도 일어나지 않는다.")
    @Test
    public void 정상당첨문자열_파싱(){
        assertThat(lottoGame.parseWinningLottoNumbers("1,2,3,4,5,6"));
    }

    @DisplayName("당첨 문자열의 구분자가 ,이 아닌 경우 예외를 던진다.")
    @Test
    public void 구분자오류_당첨문자열_파싱(){
        assertThatThrownBy(()->lottoGame.parseWinningLottoNumbers("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("당첨 문자열이 숫자가 아닌 경우 예외를 던진다.")
    @Test
    public void 숫자오류_당첨문자열_파싱(){
        assertThatThrownBy(()->lottoGame.parseWinningLottoNumbers("1,2,ㄱ,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("정상 당첨 번호들과 정상 보너스 번호를 입력하면 아무 일도 일어나지 않는다.")
    @Test
    public void 정상당첨번호와_정상보너스번호_검증(){
        lottoGame.validateWinningNumbersAndBonusNumber(Arrays.asList(1,2,3,4,5,6), 7);
    }

    @DisplayName("오류 당첨 번호들과 정상 보너스 번호를 입력하면 예외를 던진다.")
    @Test
    public void 잘못된_당첨번호와_정상보너스번호_검증(){
        assertThatThrownBy(()->lottoGame.validateWinningNumbersAndBonusNumber(Arrays.asList(1,2,3,4,5,5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("정상 당첨 번호들과 오류 보너스 번호를 입력하면 예외를 던진다.")
    @Test
    public void 정상_당첨번호와_오류보너스번호_검증(){
        assertThatThrownBy(()->lottoGame.validateWinningNumbersAndBonusNumber(Arrays.asList(1,2,3,4,5,6), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("정상 당첨 번호들에 정상 보너스 번호가 중복되면 예외를 던진다.")
    @Test
    public void 정상_당첨번호와_중복된_정상보너스번호_검증(){
        assertThatThrownBy(()->lottoGame.validateWinningNumbersAndBonusNumber(Arrays.asList(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("입력값이 숫자인 경우 아무일도 일어나지 않는다.")
    @Test
    public void 정상보너스번호_파싱(){
        lottoGame.parseBonusNumber("3");
    }

    @DisplayName("입력값이 숫자가 아닌 경우 예외를 던진다.")
    @Test
    public void 오류보너스번호_파싱(){
        assertThatThrownBy(()->lottoGame.parseBonusNumber("ㄱ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}