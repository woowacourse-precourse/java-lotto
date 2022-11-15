package lotto;

import java.util.*;


/**
 * Driver class for Java-Lotto game.
 *
 * @author Davin An
 * @version 2.0
 */
@SuppressWarnings("checkstyle:SummaryJavadoc")
public class Application {
    private static int purchaseAmount = 0;
    private static List<Lotto> lotto = new ArrayList<>();
    private static List<Integer> winningNum = new ArrayList<>();
    private static Map<Winnings, Integer> winningTickets = new LinkedHashMap<>();

    Input input;
    Output output;
    TicketHandler ticketHandler;


    public Application() {
        input = new Input();
        output = new Output();
        ticketHandler = new TicketHandler();
    }


    /**
     * Game starts here. Catches all IllegalArgumentExceptions.
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        try {
            Application game = new Application();
            game.playLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }


    /**
     * Control flow of overall game.
     */
    public void playLotto() {
        purchaseAmount = input.purchaseAmount();
        lotto = ticketHandler.generateTickets();
        output.printTickets();
        winningNum = input.winningNumbers();
        int bonusNum = input.bonusNumber();
        ticketHandler.compareTickets(winningNum, bonusNum);
        output.printWinnings();
    }


    // Getter methods
    public static int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static List<Lotto> getLotto() {
        return lotto;
    }

    public static List<Integer> getWinningNum() {
        return winningNum;
    }

    public static Map<Winnings, Integer> getWinningTickets() {
        return winningTickets;
    }


    // Setter methods
    public static void setLotto(List<Lotto> lotto) {
        Application.lotto = lotto;
    }

    public static void setWinningTickets(Map<Winnings, Integer> winningTickets) {
        Application.winningTickets = winningTickets;
    }

}
