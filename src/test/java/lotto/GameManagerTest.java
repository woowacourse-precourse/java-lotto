package lotto;

import lotto.views.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    @DisplayName("로또를 사기로한 값으로 몇개를 살 수 있는지 확인하는 테스트")
    @Test
    void changeNumberOfPurchase() {
        GameManager gameManager = new GameManager(new Input());
        int question = 15000;

        int result = 15;

        Assertions.assertThat(gameManager.changeNumberOfLottoToBuy(question))
                .isEqualTo(result);
    }

}