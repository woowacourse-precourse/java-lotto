package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.user.LottoGenerator;
import lotto.user.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Integer userMoney = user.getInput();
        LottoGenerator generator = new LottoGenerator();

        while (userMoney >= LottoEnums.LOTTO_PRICE.value()) {
            user.buyLotto(generator.getLotto());
            userMoney -= LottoEnums.LOTTO_PRICE.value();
        }
        user.printLottos();
    }
}
