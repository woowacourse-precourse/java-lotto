package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Util.Printer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class PrinterTest extends NsTest {

    @DisplayName("당첨내역 출력을 확인한다.")
    @Test
    void printWinnings() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.DEFAULT);

        Printer.printWinnings(ranks);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}