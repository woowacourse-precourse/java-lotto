package lotto;

import lotto.ui.Ready;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Customer {
    private static final int UNIT = 1000;
    private int amount;

    public void inputAmount() {
        System.out.println(Ready.INSERT_AMOUNT.getValue());
        String amount = readLine();
        if (validateAmount(amount)) {
            this.amount = Integer.parseInt(amount);
        }
    }

    public int getAmount() {
        return amount;
    }
    
    private boolean validateAmount(String amount) {
        if (!Util.isInteger(amount) || Integer.parseInt(amount) % UNIT != 0)
            throw (new IllegalArgumentException());
        return true;
    }

}
