package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.LottoFacade;
import lotto.application.LottoFacadeImpl;
import lotto.domain.Lotto;

import java.util.List;

public class LottoController {

    private final LottoFacade lottoFacade = new LottoFacadeImpl();
    public void run() {

        List<Lotto> clientLotto = buyLotto();

    }


    private List<Lotto> buyLotto() {
        String input = getInput(ViewValue.BUY_INFO_MESSAGE.getValue());

        List<Lotto> clientLotto = lottoFacade.buyLotto(Integer.valueOf(input));

        System.out.println(clientLotto.size()+ViewValue.BUY_INFO_DONE.getValue());

        clientLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
        return clientLotto;
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
