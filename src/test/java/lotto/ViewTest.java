package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.View;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ViewTest extends NsTest{

    @Test
    void 로또_번호_생성_확인() {
        View view = new View();

        final List<List<Integer>> lottos = List.of(
                List.of(1,4,6,9,15,7),
                List.of(5,19,21,37,40,45),
                List.of(3,8,10,31,40,41),
                List.of(10,14,21,30,38,43),
                List.of(2,14,16,17,29,30),
                List.of(5,24,29,32,41,44),
                List.of(2,3,4,5,6,7)
        );
        view.printUncheckedLotto(lottos);

        assertThat(output()).contains(
                "7개를 구매했습니다.",
                "[1, 4, 6, 9, 15, 7]",
                "[5, 19, 21, 37, 40, 45]",
                "[3, 8, 10, 31, 40, 41]",
                "[10, 14, 21, 30, 38, 43]",
                "[2, 14, 16, 17, 29, 30]",
                "[5, 24, 29, 32, 41, 44]",
                "[2, 3, 4, 5, 6, 7]"
        );
    }
    @Test
    void 로또_결과_확인() {
        View view = new View();

        final HashMap<Integer, Integer> prizeRankings = new HashMap<>();
        prizeRankings.put(1, 0);
        prizeRankings.put(2, 0);
        prizeRankings.put(3, 0);
        prizeRankings.put(4, 0);
        prizeRankings.put(5, 1);
        double profitRate = 0.83333;

        view.printResult(prizeRankings, profitRate);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 83.3%입니다."
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
