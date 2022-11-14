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
        Lotto winLotto = inputWinLotto();

    }


    private List<Lotto> buyLotto() {
        String moneyInput = getInput(ViewValue.BUY_INFO_MESSAGE.getValue());

        List<Lotto> clientLotto = lottoFacade.buyLotto(Integer.valueOf(moneyInput));

        System.out.println(clientLotto.size()+ViewValue.BUY_INFO_DONE.getValue());

        clientLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
        return clientLotto;
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private Lotto inputWinLotto() {
        String lottoNumberInput = getInput(ViewValue.INSERT_NUMBER_INFO.getValue());
        return lottoFacade.registerWinLotto(lottoNumberInput);
    }
}
