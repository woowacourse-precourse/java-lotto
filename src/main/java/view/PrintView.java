package view;

import java.util.HashMap;
import java.util.List;
import model.Lotto;
import model.Purchase;
import model.Result;
import model.User;
import model.WinningStatic;
import util.message.ConsoleMessage;
import util.message.ErrorMessage;

public class PrintView {

    public static void purchaseLotto() {
        System.out.println(ConsoleMessage.MESSAGE_PURCHASE_LOTTO);
    }

    public static void error(String message){
        System.out.println(ErrorMessage.PREFIX_ERROR + message);
    }

    public static void infoBoughtLotto(User user) {
        Purchase usersPurchase = user.getPurchase();
        int purchaseCount = usersPurchase.getMoney() / Lotto.PER_PRICE_LOTTO;
        List<Lotto> boughtLottos = user.getBoughtLottos();

        System.out.println("\n"+purchaseCount + "개를 구매했습니다.");
        for (Lotto lotto : boughtLottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    public static void winNum() {
        System.out.println(ConsoleMessage.WIN_LOTTO_NUMBER);
    }

    public static void bonusNum() {
        System.out.println(ConsoleMessage.BONUS_NUMBER);
    }

    public static void winningStatic(WinningStatic winningStatic){
        System.out.println(ConsoleMessage.WINNING_STATIC_MESSAGE);
        staticList(winningStatic);
        totalYield(winningStatic);
    }

    private static void staticList(WinningStatic winningStatic){
        HashMap<Result, Integer> resultStatic = winningStatic.getResultStatic();

        List<Result> resultsWithoutLost = Result.getResultsWithoutLost();
        for (Result result : resultsWithoutLost) {
            Integer coincideCount = resultStatic.get(result);
            if (coincideCount == null) {
                coincideCount=0;
            }
            System.out.printf(ConsoleMessage.WINNING_STATIC,
                    result.getCoincideCount(),
                    getBonus(result),
                    result.getPrice(),
                    coincideCount
            );
        }
    }

    private static void totalYield(WinningStatic winningStatic) {
        String yield = String.format("%.1f", winningStatic.getYield());
        System.out.printf(ConsoleMessage.TOTAL_YIELD, yield);
    }

    private static String getBonus(Result result) {
        if (result.isBonus()) {
            return ConsoleMessage.BONUS_BALL;
        }
        return "";
    }




}
