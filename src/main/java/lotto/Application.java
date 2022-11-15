package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        lottoSystem(new Input(), new Output(), new Customer());
    }

    public static void lottoSystem(Input input, Output output, Customer customer) {
        try {
            output.printGetMoneyMessage();
            int money = input.getCustomerMoney();
            customer.purchaseLotto(money);
            output.printPurchaseHistory(customer);
            output.printGetWinningNumbersMessage();
            List<Integer> winningNumbers = input.getWinningNumbers();
            output.printGetBonusNumberMessage();
            int bonusNumber = input.getBonusNumber(winningNumbers);
            List<Rank> rankResult = customer.checkMyLotto(winningNumbers, bonusNumber);
            output.printWinningStatistics(rankResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
