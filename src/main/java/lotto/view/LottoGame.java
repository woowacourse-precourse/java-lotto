package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.Lotto;
import lotto.LottoAnalyzer;
import lotto.controller.LottoGameController;
import lotto.message.GameMessage;
import lotto.message.WinningMessage;

public class LottoGame {

    private final LottoGameController lottoGameController;
    private int lottoTicketCount;
    private String userInput;
    private List<Lotto> userLottoTickets;
    private LottoAnalyzer lottoAnalyzer;

    public LottoGame() {
        this.lottoGameController = new LottoGameController();
    }

    public void start() {
        inputPurchaseAmount();
        showLottoTickets();
        inputWinningNumbers();
        inputBonusNumber();
        showStatistics();
    }

    private void inputPurchaseAmount(){
        System.out.println(GameMessage.PURCHASE_AMOUNT.getMessage());
        userInput = Console.readLine();
        lottoTicketCount = lottoGameController.buyLottoTickets(userInput);
    }

    private void showLottoTickets() {
        System.out.println(lottoTicketCount + GameMessage.NUMBER_OF_PURCHASES.getMessage());
        userLottoTickets = lottoGameController.saveLottoTickets(lottoTicketCount);
        printLottoTickets();
    }

    private void inputWinningNumbers() {
        System.out.println(GameMessage.WINNING_NUMBER.getMessage());
        userInput = Console.readLine();
        lottoGameController.pickWinningNumbers(userInput);
    }

    private void inputBonusNumber(){
        System.out.println(GameMessage.BONNUS_NUMBER.getMessage());
        userInput = Console.readLine();
        lottoGameController.pickBonusNumber(userInput);
    }

    private void showStatistics(){
        System.out.println(GameMessage.WINNIG_STATISTICS.getMessage());
        System.out.println(GameMessage.LINE.getMessage());
        lottoAnalyzer = lottoGameController.lookUpLotto();
        printWinningDetails();
        printEarningsRate();
    }

    private void printLottoTickets() {
        for (Lotto lotto : userLottoTickets) {
            List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
            lottoNumbers.sort(Comparator.naturalOrder());
            System.out.println(lottoNumbers);
        }
    }

    private void printWinningDetails() {
        WinningMessage winningMessage[] = WinningMessage.values();
        int[] rankCount = lottoAnalyzer.getRankCount();
        for (int i = 0; i < 5; i++) {
            System.out.println(winningMessage[i].getMessage() + rankCount[i] + "개");
        }
    }

    private void printEarningsRate() {
        String earningsRate = lottoGameController.calculateRate(lottoAnalyzer);
        System.out.println(GameMessage.WHOLE_EARNINGS_RATE.getMessage() + earningsRate + "입니다.");
    }
}
