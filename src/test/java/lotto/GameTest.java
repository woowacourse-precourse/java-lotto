package lotto;

import lotto.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest{
    Game game;
    @BeforeEach
    void beforeEach(){
        game = new Game();
    }
    void setInputValues(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
    @Test
    @DisplayName("로또 게임 생성 테스트")
    void generateGameTest(){
        setInputValues("2000");
        game.inputLottoCount();
        game.generateLotto();
        setInputValues("1,2,3,4,5,6");
        game.generateAwardLotto();
        setInputValues("7");
        game.generateLottoBonusNumber();
    }
    @Test
    @DisplayName("로또 게임 예외 테스트 - 보너스 번호")
    void bonusSizeOverExceptionTest(){
        setInputValues("2000");
        game.inputLottoCount();
        game.generateLotto();
        setInputValues("1,2,3,4,5,6");
        game.generateAwardLotto();
        setInputValues("7,8");
        assertThatThrownBy(() -> game.generateLottoBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 게임 예외 테스트 - 정확한 숫자인지")
    void numberUnCorrectExceptionTest(){
        setInputValues("2000");
        game.inputLottoCount();
        game.generateLotto();
        setInputValues("1,2,3,4,5,6");
        game.generateAwardLotto();
        setInputValues("46");
        assertThatThrownBy(() -> game.generateLottoBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 게임 예외 테스트 - 중복 숫자 검사")
    void mutualInputExceptionTest(){
        setInputValues("2000");
        game.inputLottoCount();
        game.generateLotto();
        setInputValues("1,2,3,4,5,6");
        game.generateAwardLotto();
        setInputValues("5");

        assertThatThrownBy(() -> game.generateLottoBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 게임 예외 테스트 - 가격 범위")
    void unCorrectMoneyRangeExceptionTest(){
        setInputValues("100");
        assertThatThrownBy(() -> game.inputLottoCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 게임 예외 테스트 - 가격값")
    void unCorrectMoneyInputExceptionTest(){
        setInputValues("2000k");
        assertThatThrownBy(() -> game.inputLottoCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
