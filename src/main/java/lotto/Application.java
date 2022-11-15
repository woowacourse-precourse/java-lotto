package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Ouput ouput = new Ouput();
        Customer customer = new Customer();
        try {
            int money = input.getCustomerMoney();
            customer.purchaseLotto(money);
            ouput.printPurchaseHistory(customer);
            List<Integer> winningNumbers = input.getWinningNumbers();
            int bonusNumber = input.getBonusNumber(winningNumbers);
            List<Rank> rankResult = customer.checkMyLotto(winningNumbers, bonusNumber);
            ouput.printWinningStatistics(rankResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
