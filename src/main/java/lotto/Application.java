package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.exception.IllegalBaseException;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.ResultLotto;
import lotto.util.Printer;
import lotto.util.RandomLottoGenerator;

public class Application {
    private static final int LOTTO_SIZE = 6;

    private static final int MONEY_UNIT = 1000;
    private static final int SPECIAL_NUMBER_SIZE = 1;

    private static final String DELIMITER = ",";


    public static void main(String[] args) {
        try {
            final Money money = makeMoney();
            final List<Lotto> expectedLottos = getRandomLottos(money);
            Printer.println(expectedLottos);
            List<Rank> ranks = Rank.getRanks(expectedLottos, makeResultLotto());
            Map<Rank, Long> statistics = Rank.getStatistics(ranks);
            Printer.println(statistics);
            Printer.printlnEarningMoney(money, statistics);
        } catch (IllegalBaseException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ResultLotto makeResultLotto() {
        Printer.println("당첨 번호를 입력해 주세요.");
        String lottoNumbers = Console.readLine();
        Printer.println("보너스 번호를 입력해 주세요.");
        String specialNumbers = Console.readLine();
        return new ResultLotto(lottoNumbers, DELIMITER, LOTTO_SIZE, specialNumbers, SPECIAL_NUMBER_SIZE);
    }

    private static List<Lotto> getRandomLottos(Money money) {
        Printer.newLine();
        Printer.println(money.getPayLottos() + "개를 구매했습니다.");
        List<Lotto> expectedLottos = RandomLottoGenerator.getRandomLottos(money, LOTTO_SIZE);
        return expectedLottos;
    }

    private static Money makeMoney() {
        Printer.println("구입금액을 입력해 주세요.");
        return new Money(Console.readLine(), MONEY_UNIT);
    }
}
