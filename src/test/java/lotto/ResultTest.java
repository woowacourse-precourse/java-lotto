package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultTest {
    WinningLotto winLotto=new WinningLotto(List.of(1,2,3,4,5,6));
    Result result=new Result(null,winLotto);

    @DisplayName("모든 등수가 잘 들어가는지 확인")
    @Test
    void inputAllPrize(){
        winLotto.inputBonusNumber(9);
        result.checkPrize(new Lotto(List.of(1,2,3,7,8,9)));
        result.checkPrize(new Lotto(List.of(1,2,3,4,8,9)));
        result.checkPrize(new Lotto(List.of(1,2,3,4,5,8)));
        result.checkPrize(new Lotto(List.of(1,2,3,4,5,9)));
        result.checkPrize(new Lotto(List.of(1,2,3,4,5,6)));
        Assertions.assertEquals(result.result.size(),5);
    }
}
