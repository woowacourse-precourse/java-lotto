package lotto;

import lotto.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
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
    void generateLottoTest(){
        setInputValues("2000");
        game.inputLottoCount();
        game.generateLotto();
        setInputValues("1,2,3,4,5,6");
        game.generateAwardLotto();
        setInputValues("7");
        game.generateBonusNumber();
    }

}
