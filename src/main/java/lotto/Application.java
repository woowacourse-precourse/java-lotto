package lotto;

import lotto.controller.Generator;
import lotto.domain.Lotto;
import lotto.view.Input;
import lotto.view.Messages;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int Money = Input.askMoney();
        int lottoCount = Input.inputMoney(Money);

        System.out.println(Messages.PRINT_BUY_LOTTO(lottoCount));;

        List<Lotto> lottos = Generator.getLottos(lottoCount);

        System.out.println(Messages.PRINT_LOTTOS(lottos));

    }
}
