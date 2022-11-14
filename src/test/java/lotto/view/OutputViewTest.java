package lotto.view;

import lotto.service.WinningHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Nested
    @DisplayName("당첨 내역 테스트")
    class winningHistoryTest {
        @Test
        void case1() {
            OutputView outputView = new OutputView();
            WinningHistory.FIFTH_PLACE.addQuantity();
            WinningHistory.FIFTH_PLACE.addQuantity();
            WinningHistory.FOURTH_PLACE.addQuantity();
            WinningHistory.SECOND_PLACE.addQuantity();
            outputView.winningHistoryPrint();
        }
    }
}
