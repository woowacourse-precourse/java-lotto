package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또를 금액에 맞는 개수만큼 발행한다.")
    @Test
    void createLottos() {
        Money money = new Money(5000);
        List<Lotto> lottos = Application.createLottos(money.getNumberToPublishLottos());
        assertEquals(5, lottos.size());
    }

    @DisplayName("등수별 개수를 구한다.")
    @Test
    void getNumbersOfRanks() {
        LottoGroups lottoGroups = new LottoGroups(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        Numbers numbers = new Numbers(List.of(1, 2, 3, 7, 12, 13), 9);
        Map<Rank, Integer> numbersOfRanks = Application.numbersOfRanks(lottoGroups, numbers);

        assertThat(numbersOfRanks.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(numbersOfRanks.get(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("수익금을 더한다.")
    @Test
    void sumOfProceeds() {
        Map<Rank, Integer> numbersOfRanks = new HashMap<>();
        numbersOfRanks.put(Rank.FIFTH, 2);
        numbersOfRanks.put(Rank.FOURTH, 2);
        numbersOfRanks.put(Rank.THIRD, 0);
        numbersOfRanks.put(Rank.SECOND, 0);
        numbersOfRanks.put(Rank.FIRST, 0);

        assertThat(Application.sumOfProceeds(numbersOfRanks)).isEqualTo(110000);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
