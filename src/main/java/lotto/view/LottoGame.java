package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.controller.LottoGameController;
import lotto.message.GameMessage;

public class LottoGame {

    private final LottoGameController lottoGameController;
    private int lottoTicketCount;
    private String userInput;
    private Lotto winningNumbers;
    private List<Lotto> userLottoTickets;

    public LottoGame() {
        this.lottoGameController = new LottoGameController();
    }

    public void start() {
        System.out.println(GameMessage.PURCHASE_AMOUNT.getMessage());
        userInput = Console.readLine();
        lottoTicketCount = lottoGameController.buyLottoTickets(userInput);

        System.out.println(lottoTicketCount + GameMessage.NUMBER_OF_PURCHASES.getMessage());
        lottoGameController.printLottoTickets(lottoTicketCount);

        System.out.println(GameMessage.WINNING_NUMBER.getMessage());
        userInput = Console.readLine();
        winningNumbers = lottoGameController.pickWinningNumbers(userInput);
    }
}
