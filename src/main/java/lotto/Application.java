package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Input input = new Input();
            Ouput ouput = new Ouput();
            int money = input.getCustomerMoney();
            Customer customer = new Customer();
            customer.purchaseLotto(money);
            ouput.printPurchaseHistory(customer);
            List<Integer> winningNumbers = input.getWinningNumbers();
            int bonusNumber = input.getBonusNumber(winningNumbers);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
