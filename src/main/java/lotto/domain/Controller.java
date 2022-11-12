package lotto.domain;

import lotto.SystemMessage;
import lotto.Utils;

import java.util.List;

public class Controller {
    Utils utils = new Utils();
    SystemMessage systemMessage = new SystemMessage();
    List<List<Integer>> lottoNumbers;
    List<Integer> winningNumbers;
    int bonusNumber;


    public void run() {
        int money = utils.inputMoney();
        int lottoTicket = utils.countTicket(money);
        createLotto(lottoTicket);
        setWinningNumbers();
        setBonusNumber();
    }

    public void createLotto(int lottoTicket) {
        NumberGenerator numberGenerator = new NumberGenerator();
        lottoNumbers = numberGenerator.createRandomNumbers(lottoTicket);
        systemMessage.printLottoNumbers(lottoNumbers);
    }

    public void setWinningNumbers() {
        winningNumbers = utils.inputWinningNumbers();
        new Lotto(winningNumbers);
    }

    public void setBonusNumber() {
        bonusNumber = utils.inputBonusNumber();
    }
}