package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        UI ui = new UI();
        ui.printInputMoneyMessage();
        int money = inputManager.inputCustomerMoney();
        Customer customer = new Customer();
        customer.purchaseLotto(money);
        ui.printPurchaseHistory(customer);
    }



    public List<Integer> inputWinningNumber() {
        return null;
    }

    public int inputBonusNumber() {
        return 0;
    }
}
