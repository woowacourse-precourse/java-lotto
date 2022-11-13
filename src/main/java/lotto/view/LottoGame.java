package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoAnalyzer;
import lotto.controller.LottoGameController;
import lotto.message.GameMessage;

public class LottoGame {

    private final LottoGameController lottoGameController;
    private int lottoTicketCount;
    private String userInput;
    private Lotto winningNumbers;
    private int bonusNumber;
    private List<Lotto> userLottoTickets;
    private LottoAnalyzer lottoAnalyzer;

    public LottoGame() {
        this.lottoGameController = new LottoGameController();
    }

    public void start() {
        System.out.println(GameMessage.PURCHASE_AMOUNT.getMessage());
        userInput = Console.readLine();
        lottoTicketCount = lottoGameController.buyLottoTickets(userInput);

        System.out.println(lottoTicketCount + GameMessage.NUMBER_OF_PURCHASES.getMessage());
        userLottoTickets = lottoGameController.saveLottoTickets(lottoTicketCount);
        printLottoTickets();

        System.out.println(GameMessage.WINNING_NUMBER.getMessage());
        userInput = Console.readLine();
        winningNumbers = lottoGameController.pickWinningNumbers(userInput);

        System.out.println(GameMessage.BONNUS_NUMBER.getMessage());
        userInput = Console.readLine();
        bonusNumber = lottoGameController.pickBonusNumber(userInput);

        System.out.println(GameMessage.WINNIG_STATISTICS.getMessage());
        System.out.println(GameMessage.LINE.getMessage());
        lottoAnalyzer = lottoGameController.lookUpLotto();
    }

    private void printLottoTickets() {
        for (Lotto lotto : userLottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
