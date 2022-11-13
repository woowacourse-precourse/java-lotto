package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;

public class IOManager {
    public static int buyLotto() throws IllegalArgumentException {
        int price;

        try {
            price = Integer.parseInt(Console.readLine());
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }

        if(price % LottoConfig.LOTTO_PRICE != 0)
            throw new IllegalArgumentException();

        return price / LottoConfig.LOTTO_PRICE;
    }
}
