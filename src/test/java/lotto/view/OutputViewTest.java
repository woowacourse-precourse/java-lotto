package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {
    @DisplayName("구매한 로또 티켓 수량과 각 티켓의 번호를 오름차순으로 출력한다.")
    @Test
    void showPurchaseListByAscendingOrder() {
        int purchaseCount = 2;
        List<List<Integer>> tickets = List.of (
                List.of(2, 4, 1, 9, 10, 34),
                List.of(11, 29, 41, 32, 7, 14)
        );

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView.showPurchaseList(purchaseCount, tickets);
        assertThat(out.toString())
                .contains("2개를 구매했습니다.")
                .contains("[1, 2, 4, 9, 10, 34]")
                .contains("[7, 11, 14, 29, 32, 41]");
    }
}
