package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoConsoleTest extends NsTest {

    private LottoConsole lottoConsole;

    @BeforeEach
    void setup() {
        lottoConsole = new LottoConsole();
    }

    @Test
    void outputLottoListTest() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18))));

        lottoConsole.outputLottoList(lottoList);
        assertThat(output()).contains(
                "3개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]"
        );
    }

    @Test
    void outputResultTest() {
        List<Integer> winningList = new ArrayList<>();
        winningList.add(3);
        winningList.add(0);
        winningList.add(2);
        winningList.add(1);
        winningList.add(10);

        double profit = 55.2222;

        lottoConsole.outputResult(winningList, profit);

        assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 3개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 2개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 10개",
                "총 수익률은 55.2%입니다.");
    }

    @Override
    protected void runMain() {
    }
}