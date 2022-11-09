package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void validateInputValueForMoneyCase1() {
        String input = "1001";
        BuyLotto buyLotto = new BuyLotto();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void validateInputValueForMoneyCase2() {
        String input = "100";
        BuyLotto buyLotto = new BuyLotto();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void validateInputValueForMoneyCase3() {
        String input = "03000";
        BuyLotto buyLotto = new BuyLotto();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void validateInputValueForCharacterCase1() {
        String input = "/001";
        BuyLotto buyLotto = new BuyLotto();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void validateInputValueForCharacterCase2() {
        String input = " 10000";
        BuyLotto buyLotto = new BuyLotto();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void validateInputValueForCharacterCase3() {
        String input = "10,000";
        BuyLotto buyLotto = new BuyLotto();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void validateInputValueForBuyLotto() {
        String input = "10000";
        BuyLotto buyLotto = new BuyLotto();
        int lotto = buyLotto.getLottoPieces(input);
        assertThat(lotto).isEqualTo(10);
        assertThat(output()).doesNotContain(ERROR_MESSAGE);
    }

    @Test
    void buyLotteriesTest() {
        BuyLotto buyLotto = new BuyLotto();
        List<List<Integer>> buyLotteries = buyLotto.buyLotteries("8000");
        assertThat(output()).contains("8개");
        assertThat(buyLotteries.size()).isEqualTo(8);
    }

    @Test
    void createWinningNumberTest() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);
        assertThat(lotto.getNumbers()).isEqualTo(winningNumber);
    }

    @Test
    void validateWinningNumberSize() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6,7");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(winningNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("6자리여야");
     }

    @Test
    void validateWinningNumberRangeCase1() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("0,2,3,4,5,6");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(winningNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("1부터 45 사이");
    }

    @Test
    void validateWinningNumberRangeCase2() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,46");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(winningNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("1부터 45 사이");
    }

    @Test
    void validateWinningNumberDuplicate() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,1");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(winningNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("중복된");
    }

    @Test
    void validateInputValueTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Lotto.sliceWinningNumber("a1, 2,A3,!4,@5,1`"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("숫자와 쉼표(,)만 입력 가능합니다.");
     }

    @Test
    void validateConsecutiveCommas() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Lotto.sliceWinningNumber("1,,2,3,4,5,6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("쉼표(,) 하나로만 나눠야 합니다.");
    }
}
