package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoEnums;
import lotto.lotto.LottoGenerator;
import lotto.user.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Integer userMoney = user.getMoneyInput();
        LottoGenerator generator = new LottoGenerator();

        while (userMoney >= LottoEnums.LOTTO_PRICE.value()) {
            user.buyLotto(generator.getLotto());
            userMoney -= LottoEnums.LOTTO_PRICE.value();
        }
        user.printLottos();

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winner = generator.convert2Lotto(user.getInput());

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        winner.setBonusNumber(user.getInput());

        System.out.println("\n당첨 통계\n---\n");
        winner.printResult(user.getLottos());

    }
}
