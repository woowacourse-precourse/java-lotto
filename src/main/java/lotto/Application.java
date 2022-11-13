package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static int ticketAmount;

    public static void main(String[] args) {
        buyLotto();
        showDrawNumber();
        pickLuckySix();
        pickLuckyBonus();
        showWinningResult();
        showProfit();
    }

    private static void buyLotto() {
        System.out.println(GameMessage.PRICE_MESSAGE.getMessage());
        String inputPrice = Console.readLine();
        Purchase userPurchase = new Purchase(inputPrice);
        ticketAmount = userPurchase.calculateCount();
    }

    private static void showDrawNumber() {
        System.out.println(ticketAmount + GameMessage.PURCHASE_MESSAGE.getMessage());
        DrawNumber userDrawNumber = new DrawNumber(ticketAmount);
    }

    private static void pickLuckySix() {
        System.out.println(GameMessage.LUCKY_NUMBER_MESSAGE.getMessage());
        String inputLuckySix = Console.readLine();
        LuckySix userLuckySix = new LuckySix(inputLuckySix);
    }

    private static void pickLuckyBonus() {
        System.out.println(GameMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String inputLuckyBonus = Console.readLine();
        LuckyBonus userLuckyBonus = new LuckyBonus(inputLuckyBonus);
    }

    private static void showWinningResult() {
        Winning userWinning = new Winning(ticketAmount);
    }

    private static void showProfit() {
        Profit userProfit = new Profit(ticketAmount * 1000);
    }


}
