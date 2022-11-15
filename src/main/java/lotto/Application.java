package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoComparator;
import lotto.lotto.LottoEnums;
import lotto.lotto.LottoGenerator;
import lotto.user.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            User user = new User();
            Integer userMoney = user.getMoneyInput();
            LottoGenerator generator = new LottoGenerator();
            LottoComparator comparator = new LottoComparator();

            while (userMoney >= LottoEnums.LOTTO_PRICE.value()) {
                user.buyLotto(generator.getLotto());
                userMoney -= LottoEnums.LOTTO_PRICE.value();
            }
            user.printLottos();

            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            Lotto winn = generator.convert2Lotto(user.getInput());

            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            winn.setBonusNumber(user.getInput());

            System.out.println("\n당첨 통계\n---\n");
            comparator.printStatistics(winn, user.getLottos());

            Double rate = comparator.getProfitRate(winn, user.getLottos());
            System.out.printf("\n총 수익률은 %.1f%%입니다.\n", rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
