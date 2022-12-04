package view;

import domain.Result;
import lotto.LottoList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    static OutputView outputView;

    @BeforeAll
    public static void setOutputView() {
        outputView = new OutputView();
    }

    @Test
    public void lottoList_test() {
        LottoList lottoList = new LottoList(8000);
        outputView.printLottoList(lottoList);
    }

    @Test
    public void printResult_test() {
        outputView.printResult(new Result());
    }

    @Test
    public void profit_test() {
        outputView.printProfit(12345678.9);
    }
}
