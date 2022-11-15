package lotto;

import lotto.model.WinningRank;
import lotto.view.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {

    @Test
    void 구매목록_출력테스트() {
        View view = new View();
        List<List<Integer>> user = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 11, 12, 13, 14),
                List.of(1, 11, 12, 13, 14, 15),
                List.of(11, 12, 13, 14, 15, 16)
        );
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        view.printPurchaseList(user);
        String output = out.toString();
        assertThat(output).contains(
                "8개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[1, 2, 3, 4, 5, 7]",
                "[1, 2, 3, 4, 5, 8]",
                "[1, 2, 3, 4, 8, 9]",
                "[1, 2, 3, 10, 11, 12]",
                "[1, 2, 11, 12, 13, 14]",
                "[1, 11, 12, 13, 14, 15]",
                "[11, 12, 13, 14, 15, 16]"
        );

    }

    @Test
    void 당첨통계_출력() {
        View view = new View();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Map<WinningRank, Integer> enumMap = new EnumMap<WinningRank, Integer>(WinningRank.class);
        enumMap.put(WinningRank.one, 1);
        view.printWinningStatistics(enumMap);
        String output = out.toString();
        assertThat(output).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }

    @Test
    void 수익률_출력() {
        View view = new View();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        view.printEarningsRate(62.5);
        String output = out.toString();
        assertThat(output).contains("총 수익률은 62.5%입니다.");
    }
}
