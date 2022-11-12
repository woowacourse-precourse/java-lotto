package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Draw;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.ui.Exception;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(askMoney());
        Integer count = money.getLottoCount();
        List<Lotto> lottos = generateLottos(count);
        viewLottos(lottos);

        Lotto winnerLotto = askWinnerLotto();
        Integer bonusNumber = askBonusNumber();
        Draw draw = new Draw(winnerLotto, bonusNumber);

        Integer winnings = draw.resultLottery(lottos);
        money.viewYield(winnings);
    }

    public static List<Lotto> generateLottos(int count) {
        NumberGenerator generator = new NumberGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generator.createRandomUniqueNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static void viewLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.view();
        }
        System.out.println();
    }

    private static Integer askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Exception.validateInputLottoNumber(input);
        Integer temp = Integer.parseInt(input);
        System.out.println();
        return temp;
    }

    public static Lotto askWinnerLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] dividedNumbers = input.split(",");
        System.out.println();
        List<Integer> temp = new ArrayList<>();
        for (String dividedNumber : dividedNumbers) {
            Exception.validateInputLottoNumber(dividedNumber);
            temp.add(Integer.parseInt(dividedNumber));
        }

        return new Lotto(temp);
    }

    public static Integer askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        Exception.validateInputLottoNumber(input);
        Integer temp = Integer.parseInt(input);
        System.out.println();
        return temp;
    }

}
