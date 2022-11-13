package lotto.view;

import org.junit.jupiter.api.Test;

import java.util.List;

public class OutputViewTest {
    private static OutputView outputView;

    public OutputViewTest() {
        outputView = new OutputView();
    }

    @Test
    void 결과_출력() {
        List<Integer> list = List.of(0,1, 2, 3, 4, 5, 6, 7);
        outputView.printWinningList(list);
    }
}
