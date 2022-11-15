package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.Statistic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.domain.Statistic.*;
import static lotto.service.LottoService.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // 구입 금액 예외테스트
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_구입_금액이_음수인_경우() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains("[ERROR] 구입 금액에 음수는 입력이 불가능합니다.");
        });
    }

    @Test
    void 예외_테스트_구입_금액에_1000원_단위가_아닌_수_입력() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains("[ERROR] 구입 금액은 1,000원 단위로 입력받을 수 있습니다.");
        });
    }

    @Test
    void 예외_테스트_구입_금액에_매우_큰_수가_입력되는_경우() {
        assertSimpleTest(() -> {
            runException("100000000000");
            assertThat(output()).contains("[ERROR] 구입 금액에 1,000,000,000 미만의 숫자만 입력 가능합니다.");
        });
    }

    // 보너스 번호 예외테스트
    @Test
    void 예외_테스트_보너스_번호에_문자가_입력되는_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        });
    }

    @Test
    void 예외_테스트_보너스_번호가_범위를_벗어나는_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    // 로또 번호 입력 예외테스트
    @Test
    void 예외_테스트_쉼표가_아닌_특수문자를_입력하는_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1!2,3,4,5,6");
            assertThat(output()).contains("[ERROR] ,외의 특수문자는 입력 불가능합니다.");
        });
    }

    @Test
    void 예외_테스트_공백이_입력된_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,,2,3,4,5");
            assertThat(output()).contains("[ERROR] 공백은 입력 불가능합니다.");
        });
    }




    // 나머지 기능
    @Test
    void 로또_값이_일치하는_개수() {
        // given
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(2, 6, 7, 8, 9, 10));

        // when
        int count = countMatchingNumber(lottoA, lottoB);

        // then
        assertEquals(2, count);
    }

    @Test
    void 보너스_포함_여부() {
        // given
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 5;

        // when
        boolean flag = compareBonus(lottoA, bonus);

        // then
        assertEquals(true, flag);
    }

    @Test
    void 일치하는_로또_번호_개수와_보너스_번호_따른_Statistic_반환() {
        // given
        int matchingNumber = 5;
        boolean bonusFlag = true;

        // when
        Statistic statistic = findStatistic(matchingNumber, bonusFlag);

        // then
        assertEquals(Statistic.BONUS, statistic);
    }

    @Test
    void 해당하는_Statistic에_1추가() {
        // given
        Lotto inputLotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        int bonus = 22;

        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<Lotto> issuedLotteries = List.of(lottoA, lottoB);

        HashMap<Statistic, Integer> countStatistic = new HashMap<>();
        initializeCountStatistic(countStatistic);

        // when
        calculateStatistic(inputLotto, bonus, issuedLotteries, countStatistic, 1);

        // then
        assertEquals(1, countStatistic.get(FOUR));
        assertEquals(0, countStatistic.get(THREE));
    }

    @Test
    void 생성된_countStatistic_테스트() {
        // given
        Lotto inputLotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        int bonus = 22;

        Lotto lottoA = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lottoB = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<Lotto> issuedLotteries = List.of(lottoA, lottoB);

        // when
        HashMap<Statistic, Integer> result = generateCountStatistic(inputLotto, bonus, issuedLotteries);

        // then
        assertEquals(1, result.get(FOUR));
        assertEquals(1, result.get(THREE));
    }

    @Test
    void 수익률_테스트() {
        // given
        Lotto inputLotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        int bonus = 22;

        Lotto lottoA = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lottoB = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto lottoC = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> issuedLotteries = new ArrayList<>();
        issuedLotteries.add(lottoA);
        issuedLotteries.add(lottoB);
        for (int i = 0; i < 50; i++) {
            issuedLotteries.add(lottoC);
        }
        HashMap<Statistic, Integer> countStatistic = generateCountStatistic(inputLotto, bonus, issuedLotteries);

        // when
        double result = calculateProfit(issuedLotteries.size(), countStatistic);

        // then
        assertEquals(105.8, result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
