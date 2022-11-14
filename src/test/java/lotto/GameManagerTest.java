package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.views.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest extends NsTest {

    @DisplayName("로또를 사기로한 값으로 몇개를 살 수 있는지 확인하는 테스트")
    @Test
    void changeNumberOfPurchase() {
        GameManager gameManager = new GameManager(new Input());
        int question = 15000;

        int result = 15;

        Assertions.assertThat(gameManager.changeNumberOfLottoToBuy(question))
                .isEqualTo(result);
    }

    @DisplayName("로또에 대한 당첨금액을 제대로 계산할 수 있어야한다.")
    @Test
    void checkLottoPrize() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 7, 8]",
                            "[1, 2, 3, 7, 8, 9]",
                            "[1, 2, 7, 8, 9, 10]",
                            "[1, 7, 8, 9, 10, 11]",
                            "[1, 2, 3, 4, 5, 8]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 7, 8, 9, 10),
                List.of(1, 7, 8, 9, 10, 11),
                List.of(1, 2, 3, 4, 5, 8)
                );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}