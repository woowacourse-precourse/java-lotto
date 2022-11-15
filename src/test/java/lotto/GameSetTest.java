package lotto;

import lotto.domain.GameSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetTest {
    @Test
    @DisplayName("로또 자동생성 테스트")
    void generateLottoTest(){
        GameSet gameSet = new GameSet();
        assertEquals(gameSet, gameSet.getGeneratedLotto());
    }
    @Test
    @DisplayName("당첨 로또 생성 테스트")
    void generateAwardLottoTest(){

    }

}
