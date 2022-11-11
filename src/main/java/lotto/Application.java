package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoUI;
import lotto.domain.Lotto;
import lotto.domain.Message;

public class Application {
    public static void main(String[] args) {
        LottoUI lottoUI = new LottoUI();
        try {
            List<Lotto> lottoBundle = lottoUI.buy();
            lottoUI.printLottoBundle(lottoBundle);
            lottoUI.inputWinningNumbers();
        } catch (IllegalArgumentException exception) {
            System.out.println(Message.ERROR_MESSAGE + exception.getMessage());
        }
    }
}
