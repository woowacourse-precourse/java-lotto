package lotto;

import lotto.inputtool.ArrayConverter;
import lotto.inputtool.TextConverter;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.WinningLotto;
import lotto.outputview.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultTest {
    
    Result result = new Result();

    @Test
    @DisplayName("당첨 통계 출력")
    void result() {
        Lottos lottos = new Lottos();
        int amount = 8;
        lottos.issuedLottos(amount);

        String[] numberArray = TextConverter.splitComma("1,2,3,4,5,6");
        List<Integer> lottoNumberList = ArrayConverter.toIntegerList(numberArray);
        Lotto lotto = new Lotto(lottoNumberList);
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        result.compare(lottos, winningLotto);
        Statistics.printWin();
    }

}