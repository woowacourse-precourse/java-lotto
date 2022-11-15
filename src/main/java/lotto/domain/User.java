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
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }
    
    private int calculateLottoCnt() {
        return price / 1000;
    }

    public int getLottoCnt() {
        return lottoCnt;
    }
}
