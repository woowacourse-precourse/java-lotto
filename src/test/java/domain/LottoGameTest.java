package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    void matchCount() {


        List<Integer> winningLottoList = Arrays.asList(1,2,3,4,5,6);
        List<Integer> nowBuyLottoList = Arrays.asList(4,5,6,7,8,9);
        int bonusNumber=10;
        LottoGame game = new LottoGame();
        Integer integer = game.matchCount(winningLottoList, nowBuyLottoList, bonusNumber);

        Assertions.assertThat(integer).isEqualTo(3);

    }
}