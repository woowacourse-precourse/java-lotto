package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    @DisplayName("구입금액만큼 로또번호를 받고 출력하는 테스트")
    public void lottoGenerateAndPrint() {
        game.getLottoNumbers(5);
        game.printLottoNumbers();
    }
}
