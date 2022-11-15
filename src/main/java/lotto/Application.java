package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static int purchaseAmount = 0;
    private static List<Lotto> lotto = new ArrayList<>();
    private static List<Integer> winningNum = new ArrayList<>();
    private static Map<Winnings, Integer> winningTickets = new LinkedHashMap<>();

    public static void main(String[] args) {
        try {
            Application game = new Application();
            game.playLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void playLotto() {

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
