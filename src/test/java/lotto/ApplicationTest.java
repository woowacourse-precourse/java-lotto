package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("입력 값이 천원으로 딱 나눠 나머지가 있으면 에러가 발생한다. 1")
    @Test
    void validateInputValueForMoneyCase1() {
        String input = "1001";
        AutomaticLottery buyLotto = new AutomaticLottery();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("입력 값이 천원으로 딱 나눠 나머지가 있으면 에러가 발생한다. 2")
    @Test
    void validateInputValueForMoneyCase2() {
        String input = "100";
        AutomaticLottery buyLotto = new AutomaticLottery();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("입력 값이 0으로 시작하면 에러가 발생한다.")
    @Test
    void validateInputValueForMoneyCase3() {
        String input = "03000";
        AutomaticLottery buyLotto = new AutomaticLottery();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("입력 값에 문자가 들어가면 에러가 발생한다. 1")
    @Test
    void validateInputValueForCharacterCase1() {
        String input = "/001";
        AutomaticLottery buyLotto = new AutomaticLottery();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("입력 값에 문자가 들어가면 에러가 발생한다. 2")
    @Test
    void validateInputValueForCharacterCase2() {
        String input = " 10000";
        AutomaticLottery buyLotto = new AutomaticLottery();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("입력 값에 문자가 들어가면 에러가 발생한다. 3")
    @Test
    void validateInputValueForCharacterCase3() {
        String input = "10,000";
        AutomaticLottery buyLotto = new AutomaticLottery();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> buyLotto.getLottoPieces(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("조건에 맞게 입력하면 정상적으로 구매할 로또의 수를 반환한다.")
    @Test
    void validateInputValueForBuyLotto() {
        String input = "10000";
        AutomaticLottery buyLotto = new AutomaticLottery();
        int lotto = buyLotto.getLottoPieces(input);
        assertThat(lotto).isEqualTo(10);
        assertThat(output()).doesNotContain(ERROR_MESSAGE);
    }

    @DisplayName("조건에 맞게 입력하면 정상적으로 로또를 구매하여 번호가 담긴 리스트를 반환한다.")
    @Test
    void buyLotteriesTest() {
        AutomaticLottery buyLotto = new AutomaticLottery();
        List<List<Integer>> buyLotteries = buyLotto.buyLotteries("8000");
        assertThat(output()).contains("8개");
        assertThat(buyLotteries.size()).isEqualTo(8);
    }

    @DisplayName("조건에 맞게 입력하면 정상적으로 당첨 번호를 반환한다.")
    @Test
    void createWinningNumberTest() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);
        assertThat(lotto.getNumbers()).isEqualTo(winningNumber);
    }

    @DisplayName("당첨 번호를 6개 초과로 입력하면 에러가 발생한다.")
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

    @DisplayName("당첨 번호가 1 ~ 45가 아니면 에러가 발생한다.(0 입력)")
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

    @DisplayName("당첨 번호가 1 ~ 45가 아니면 에러가 발생한다. (46 입력)")
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

    @DisplayName("중복된 당첨 번호를 입력하면 에러가 발생한다.")
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

    @DisplayName("숫자와 쉼표(,) 외에 다른 값을 입력하면 예외가 발생한다.")
    @Test
    void validateInputValueTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Lotto.sliceWinningNumber("a1, 2,A3,!4,@5,1`"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("숫자와 쉼표(,)만 입력 가능합니다.");
     }

    @DisplayName("쉼표(,)를 중복으로 입력하면 예외가 발생한다.")
    @Test
    void validateConsecutiveCommas() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Lotto.sliceWinningNumber("1,,2,3,4,5,6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("쉼표(,) 하나로만 나눠야 합니다.");
    }

    @DisplayName("정상적인 보너스 번호를 입력한다.")
    @Test
    void createBonusNumberTest() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);
        lotto.inputBonusNumber("7");
        List<Integer> allNumbers = lotto.getNumbers();
        assertThat(allNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
    }

    @DisplayName("당첨 번호에 있는 보너스 번호를 입력한다.")
    @Test
    void validateContainsBonusNumberTest() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> lotto.inputBonusNumber("6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("당첨 번호에 있는 번호는 보너스 번호로 입력할 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1 ~ 45가 아니면 에러가 발생한다. (46 입력)")
    @Test
    void validateRangeBonusNumberTestCase1() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> lotto.inputBonusNumber("46"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1 ~ 45가 아니면 에러가 발생한다. (0 입력)")
    @Test
    void validateRangeBonusNumberTestCase2() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> lotto.inputBonusNumber("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThat(output()).contains(ERROR_MESSAGE);
        assertThat(output()).contains("1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("경계값 테스트 : 보너스 번호로 45를 입력한다.")
    @Test
    void validateRangeBonusNumberTestCase3() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("2,3,4,5,6,7");
        Lotto lotto = new Lotto(winningNumber);
        lotto.inputBonusNumber("45");
        List<Integer> allNumbers = lotto.getNumbers();

        assertThat(allNumbers).isEqualTo(List.of(2, 3, 4, 5, 6, 7, 45));
    }

    @DisplayName("경계값 테스트 : 보너스 번호로 1을 입력한다.")
    @Test
    void validateRangeBonusNumberTestCase4() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("2,3,4,5,6,7");
        Lotto lotto = new Lotto(winningNumber);
        lotto.inputBonusNumber("1");
        List<Integer> allNumbers = lotto.getNumbers();

        assertThat(allNumbers).isEqualTo(List.of(2, 3, 4, 5, 6, 7, 1));
    }

    @DisplayName("정상적인 보너스 번호를 입력한다.")
    @Test
    void validateCharacter() {
        List<Integer> winningNumber = Lotto.sliceWinningNumber("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumber);
        String number = "7";
        lotto.inputBonusNumber(number);
        List<Integer> allNumbers = lotto.getNumbers();
        assertThat(allNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
    }

    @DisplayName("Enum 출력 테스트")
    @Test
    void enumPrintTest() {
        double rightNumber = 3; // 3개 맞춤(5등)
        for (int seq = 0; seq < 3; seq++) { // 세번 맞춤(5등 세번)
            if (rightNumber == WinnersCase.FIFTH.getRightNumber()) {
                WinnersCase.FIFTH.addCount();
            }
        }
        Integer count = WinnersCase.FIFTH.getCount(); // 몇번 맞췄는지
        WinnersCase.FIFTH.totalPrizeMoney(5000L, count); // 총 당첨 금액 저장
        String ranking = WinnersCase.FIFTH.getRanking(); // 출력을 위한
        Long prizeMoney = WinnersCase.FIFTH.getPrizeMoney(); // 총 당첨 금액 get
        System.out.println(ranking + count + "개"); // 출력

        assertThat(output()).contains("3개 일치");
        assertThat(prizeMoney).isEqualTo(15000L);
     }
}
