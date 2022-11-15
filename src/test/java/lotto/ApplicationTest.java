package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void _1000_으로_나누어떨어지지_않는_경우() {
        assertSimpleTest(() -> {
            runException("100020");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_리스트가_숫자가_아닌_경우() {
        List <String> input = Arrays.asList("1","2","23","a","22", "11");
        assertSimpleTest(() -> {
            assertThat(Exception.checkWinningNumbersNumeric(input)).isEqualTo(false);
        });
    }

    @Test
    void test_findLottoResult() {
        List <Integer> lotto = Arrays.asList(12, 15, 25, 26, 43, 44);
        List <Integer> winningNumbers = Arrays.asList(12, 15, 24, 26, 43, 44);
        int bonusNumber = 1;
        int result = 2;
        assertSimpleTest(() -> {
            assertThat(Utility.findLottoResult(lotto, winningNumbers, bonusNumber)).isEqualTo(result);
        });
    }

    @Test
    void test_findTotalLottoResult() {
        List <Lotto> purchaseLotto = new ArrayList<>();
        List <Integer> lottoNumbers1 = Arrays.asList(12, 15, 25, 26, 43, 44);
        List <Integer> lottoNumbers2 = Arrays.asList(12, 15, 23, 25, 43, 44);
        List <Integer> lottoNumbers3 = Arrays.asList(12, 15, 23, 25, 43, 44);
        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        Lotto lotto3 = new Lotto(lottoNumbers3);
        purchaseLotto.add(lotto1);
        purchaseLotto.add(lotto2);
        purchaseLotto.add(lotto3);
        List <Integer> winningNumbers = Arrays.asList(12, 15, 24, 26, 43, 44);
        int bonusNumber = 25;
        List <Integer> result = Arrays.asList(0,1,0,2,0,0);
        assertSimpleTest(() -> {
            assertThat(Utility.findTotalLottoResult(purchaseLotto, winningNumbers, bonusNumber)).isEqualTo(result);
        });
    }

    @Test
    void test_calculateTotalPrizeAmount() {
        List <Integer> lottoResult = Arrays.asList(0, 3, 0, 2, 1, 4);
        long result = 90105000;
        assertSimpleTest(() -> {
            assertThat(Utility.calculateTotalPrizeAmount(lottoResult)).isEqualTo(result);
        });
    }

    @Test
    void test_calculateProfitPercentage() {
        long spentAmount = 10000;
        long totalPrizeAmount = 90105000;
        double result = 901050;
        assertSimpleTest(() -> {
            assertThat(Utility.calculateProfitPercentage(spentAmount, totalPrizeAmount)).isEqualTo(result);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
