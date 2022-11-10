package lotto;

import java.util.List;
import lotto.domain.LottoSystem;
import lotto.domain.Lotto;
import lotto.domain.Message;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();

        try {
            List<Lotto> lottoBundle = lottoSystem.buy();
        } catch (IllegalArgumentException exception) {
            System.out.println(Message.ERROR_MESSAGE + exception.getMessage());
        }
    }
}
