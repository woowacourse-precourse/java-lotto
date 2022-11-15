package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.exception.BuyMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoTest extends NsTest {
    private BuyLotto buyLotto;

    @BeforeEach
    public void setUp() {
        buyLotto = new BuyLotto();
    }

    @Test
    @DisplayName("구매_금액_단위")
    public void buyMoney() {
        assertThatThrownBy(() -> new BuyMoneyException().notDivideThousands("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또_구매_개수")
    public void buyLottos() {
        int quantity = 5;
        assertThat(buyLotto.getMyLottoNumbers(quantity).size())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("정렬_테스트")
    void sortTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]"
                    );
                },
                List.of(21, 8, 41, 23, 42, 43)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
