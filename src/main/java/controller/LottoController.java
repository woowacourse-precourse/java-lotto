package controller;

import model.*;
import view.UserOutput;
import view.UserInput;

public class LottoController {
    private final UserInput userInput = new UserInput();
    private final UserOutput userOutput = new UserOutput();
    LottoResultBoard lottoResultBoard = new LottoResultBoard();
    LottoManager lottoManager = new LottoManager();
    private Lotto lotto;
    private LottoBonus lottoBonus;
    private WinningLotto winningLotto;

    public void lottoStart() {
        lottoManager.makeRandomLottoNumber(getLottoTicketCount());
        userOutput.printRandomLottoList(lottoManager.getRandomLottoNumber());
        makeLottoWinningNumberByInput();
        makeLottoBonusNumberByInput();
        lottoManager.calculateLottoRank(winningLotto, lottoResultBoard, lottoManager.getRandomLottoNumber());
        userOutput.printWinningStats();
    }

    public int getLottoTicketCount() {
        Money money = new Money(userInput.inputMoney());
        userOutput.printLottoCount(money.getTicketCount());
        return money.getTicketCount();
    }

    public void makeLottoWinningNumberByInput() {
        winningLotto = new WinningLotto(userInput.inputWinningNumber());
        lotto = new Lotto(winningLotto.getWinningNumbers());
    }

    public int makeLottoBonusNumberByInput() {
        lottoBonus = new LottoBonus(userInput.inputBonusNumber(), winningLotto.getWinningNumbers());
        return lottoBonus.getBonusNumber();
    }

}