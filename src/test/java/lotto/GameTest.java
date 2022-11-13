package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Game.makeWinning;
import static lotto.Game.winning;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    @Test
    void makeWinningTest(){
        makeWinning("1,2,3,4,5,6");
        assertThat(winning).isEqualTo(
                List.of(1,2,3,4,5,6)
        );
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
