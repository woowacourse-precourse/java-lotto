package lotto.domain;

import lotto.SystemMessage;
import lotto.Utils;

import java.util.List;

public class Controller {
    Utils utils = new Utils();
    SystemMessage systemMessage = new SystemMessage();
    List<List<Integer>> lottoNumbers;
    List<Integer> winningNumbers;
    String inputMoney;
    int bonusNumber;
    int money;

    public void run() {
        try {
            inputMoney = utils.inputMoney();
            money = Integer.parseInt(inputMoney);
            utils.validateMoney(money);
            int lottoTicket = utils.countTicket(money);
            createLotto(lottoTicket);
            setNumbers();
            winningResult();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 숫자만 입력이 가능합니다.");
        }
    }

    public void createLotto(int lottoTicket) {
        NumberGenerator numberGenerator = new NumberGenerator();
        lottoNumbers = numberGenerator.createRandomNumbers(lottoTicket);
        systemMessage.printLottoNumbers(lottoNumbers);
    }

    public void setNumbers() {
        try {
            setWinningNumbers();
            setBonusNumber();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 1부터 45 사이의 숫자만 입력이 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void setWinningNumbers() {
        winningNumbers = utils.inputWinningNumbers();
        new Lotto(winningNumbers);
    }

    public void setBonusNumber() {
        bonusNumber = utils.inputBonusNumber();
    }

    public void winningResult() {
        Judgment judgment = new Judgment(lottoNumbers, winningNumbers, bonusNumber);
        List<Integer> winningResult = judgment.result();
        systemMessage.printResult(winningResult);
        double profitRate = judgment.calculateProfitRate(money);
        systemMessage.printProfitRate(profitRate);
    }
}