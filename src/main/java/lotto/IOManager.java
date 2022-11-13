package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;

public class IOManager {
    public static int buyLotto() throws IllegalArgumentException {
        try {
            int price = Integer.parseInt(Console.readLine());

            return price / LottoConfig.LOTTO_PRICE;
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
