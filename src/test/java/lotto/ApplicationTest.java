package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.getBonus;
import static lotto.Application.getTheNumberOfLottoesAsMuchThePurchaseAmount;
import static lotto.Application.getWinningNumbers;
import static lotto.Application.match;
import static lotto.Application.renew;
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

    @Test
    void getTheNumberOfLottoesAsMuchThePurchaseAmountTest() {
        String purchaseAmount = "14000";
        Integer numberOfLottoes = getTheNumberOfLottoesAsMuchThePurchaseAmount(
                Integer.parseInt(purchaseAmount)
        );

        assertThat(numberOfLottoes).isEqualTo(14);
    }

    @Test
    void createLottoesTest() {
        List<Lotto> lottoes = new ArrayList<>();
        int numberOfLottoes = 5;

        for (int i = 0; i < numberOfLottoes; i++) {
            List<Integer> arr = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoes.add(new Lotto(arr));
            assertThat(lottoes.get(i).getNumbers()).isEqualTo(arr);
        }
    }

    @Test
    void getWinningNumberTest() {
        String str = "1,2,3,4,5,6";
        List<Integer> winningNumbers = getWinningNumbers(str);

        assertThat(winningNumbers).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void getBonusTest() {
        String str = "5";
        Integer bonus = getBonus(str);

        assertThat(bonus).isEqualTo(5);
    }

    @Test
    void findTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winning = List.of(1,2,3,6,7,8);
        Integer bonus = 10;

        Grade grade = Grade.find(match(lotto, winning, bonus));

        assertThat(grade.toString()).isEqualTo("4등");
    }

    @Test
    void matchTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winning = List.of(1,2,3,6,7,8);
        Integer bonus = 10;
        List<Integer> matching = Arrays.asList(lotto.compareTo(winning), lotto.compareToAdditional(bonus));

        assertThat(matching).isEqualTo(List.of(4,0));
    }

    @Test
    void makeStatsTest() {
        List<Lotto> lottoes = new ArrayList<>();
        lottoes.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottoes.add(new Lotto(List.of(1,2,6,7,3,4)));
        lottoes.add(new Lotto(List.of(7,5,4,2,1,3)));
        List<Integer> winning = List.of(1,2,3,4,5,6);
        Integer bonus = 7;
        List<Integer> stats = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            stats.add(0);
        }

        for (int i = 0; i < lottoes.size(); i++) {
            Grade grade = Grade.find(match(lottoes.get(i), winning, bonus));
            stats = renew(stats, grade.toString());
        }

        assertThat(stats).isEqualTo(List.of(1,2,0,0,0));
    }





    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
