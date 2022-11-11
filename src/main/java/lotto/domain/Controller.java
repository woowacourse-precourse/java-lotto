package lotto.domain;

import lotto.SystemMessage;
import lotto.Utils;

import java.util.List;

public class Controller {
    Utils utils = new Utils();
    SystemMessage systemMessage = new SystemMessage();

    public void run() {
        int money = utils.inputMoney();
        int lottoTicket = utils.countTicket(money);
        createLotto(lottoTicket);
    }

    public void createLotto(int lottoTicket) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<List<Integer>> lottoNumbers = numberGenerator.createRandomNumbers(lottoTicket);
        systemMessage.printLottoNumbers(lottoNumbers);
    }
}