package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {
    final int count;
    final int price;
    Customer() {
        String tmp = Console.readLine();
        price = Integer.parseInt(tmp);
        validate(price);
        this.count = price / 1000;
    }

    private void validate(int price) {
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입은 1,000원 단위로만 가능합니다.");
    }
}
