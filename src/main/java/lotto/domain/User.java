package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int price;
    private static int lottoCnt;
    private static final String regex = "^\\d+$";

    public User() {
    }
    
    public void payMoney() {
        String money = Console.readLine();
        validate(money);
        price = Integer.parseInt(money);
    }

    public void buyLotto() {
        lottoCnt = calculateLottoCnt();
    }

    private void validate(String price) {
        if (!price.matches(regex)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(price) % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
    
    private int calculateLottoCnt() {
        return price / 1000;
    }

    public int getLottoCnt() {
        return lottoCnt;
    }
}
