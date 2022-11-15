package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StatsTest {
    private List<Lotto> makeLottos() {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        return Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8);
    }

    private List<Integer> makeWinLottoNumbers() {
        return Arrays.asList(1,2,3,4,5,6);
    }
    @DisplayName("구매자의 로또들과 당첨 로또, 보너스 번호를 가지고 계산하여 통계를 출력하는지 확인")
    @Test
    void when_compare_Expect_printStats() {
        final int BONUS_NUMBER = 7;
        List<Lotto> lottos = makeLottos();
        List<Integer> winLottoNumbers = makeWinLottoNumbers();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Stats.compare(lottos, winLottoNumbers, BONUS_NUMBER);
        assertThat(outputStream.toString()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다."
        );
    }

    @DisplayName("총 수익률을 계산 확인")
    @Test
    void when_calculate_Expect_printProfit() {
        int amount = 8000;
        //TODO : 할 일
    }
}