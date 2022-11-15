package lotto;

import lotto.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    @DisplayName("로또 자동생성 테스트")
    void generateLottoTest(){
        Game game = new Game();
        assertEquals(game, game.getGeneratedLotto());
    }
    @Test
    @DisplayName("당첨 로또 생성 테스트")
    void generateAwardLottoTest(){

    }

}
