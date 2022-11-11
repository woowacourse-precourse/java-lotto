package lotto;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import lotto.util.RandomUtil;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("로또 생성값 출력")
    void purchaseResultMsg() {

        int lottoPurchaseAmount = 6000;
        int countFromMoney = 6;

        List<List<Integer>> lottoNumbers = RandomUtil.getLottoNumbers(lottoPurchaseAmount);
        OutputView.purchaseResultMsg(lottoNumbers, countFromMoney);
    }
}