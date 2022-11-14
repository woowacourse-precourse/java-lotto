package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Judgment;
import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.domain.Statistics;

/*
* 객체 지향 프로그래밍
* 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
* 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
* 3. 각 결과를 종합한다.
*/

public class Application {
    public static void main(String[] args) {
        try {
            String purchaseAmount = askPurchaseAmount();
            NumberGenerator numberGenerator = new NumberGenerator(purchaseAmount);
            List<Integer> lottoNumbers = askLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            int bonusNumber = lotto.validateBonusNumber(askBonusNumber());
            Judgment judgment = new Judgment(numberGenerator.collectionOfLottoNumbers, lottoNumbers, bonusNumber);
            Statistics statistics = new Statistics(numberGenerator.purchaseAmount, judgment.firstCount, judgment.secondCount, judgment.thirdCount, judgment.fourthCount, judgment.fifthCount);
            System.out.println(statistics.resultMessage);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> askLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List <Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public static int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
