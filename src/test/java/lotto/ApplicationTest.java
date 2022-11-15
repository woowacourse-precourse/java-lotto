package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.printHowManyMatches;
import static lotto.Application.rateOfReturn;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또번호_몇개_일치_테스트() {
        List<Integer> nums = new ArrayList<>();
        Lotto input_nums = new Lotto(List.of(1,2,3,4,5,6));
        Lotto win_nums = new Lotto(List.of(7,2,3,11,5,6));
        int result = 4;
        assertThat(result).isEqualTo(input_nums.howManyMatches(win_nums));
    }

    @Test
    void 로또번호_당첨_순위_테스트(){
        List<Integer> nums = new ArrayList<>();
        Lotto input_nums = new Lotto(List.of(1,2,3,23,5,6));
        Lotto win_nums = new Lotto(List.of(1,2,3,11,5,6));
        int bonus = 23;

        int result = 2;
        assertThat(result).isEqualTo(input_nums.rank(win_nums, bonus));
    }

    @Test
    void  당첨내역_출력_테스트(){
        List<Lotto> all_lottery = new ArrayList<>();
        all_lottery.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        all_lottery.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        all_lottery.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        all_lottery.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        all_lottery.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        all_lottery.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        all_lottery.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        Lotto win_nums = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 7;

        printHowManyMatches(all_lottery,win_nums,bonus);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Test
    void 수익률_테스트(){
        int lottery_cnt = 8;
        HashMap<Integer,Integer> lottery_ranks = new HashMap<>();
        lottery_ranks.put(1, 0);
        lottery_ranks.put(2, 0);
        lottery_ranks.put(3, 0);
        lottery_ranks.put(4, 0);
        lottery_ranks.put(5, 1);

        double result = 62.5;

        assertThat(result).isEqualTo(rateOfReturn(lottery_cnt, lottery_ranks));
    }
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
}
