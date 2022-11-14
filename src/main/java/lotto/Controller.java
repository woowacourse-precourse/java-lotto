package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Judgment;
import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.domain.Statistics;

public class Controller {
    public void run() {
        String purchaseAmount = askPurchaseAmount();
        NumberGenerator numberGenerator = new NumberGenerator(purchaseAmount);
        List<Integer> lottoNumbers = askLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        int bonusNumber = lotto.validateBonusNumber(askBonusNumber());
        Judgment judgment = new Judgment(numberGenerator.collectionOfLottoNumbers, lottoNumbers, bonusNumber);
        Statistics statistics = new Statistics(numberGenerator.purchaseAmount, judgment.firstCount,
                judgment.secondCount, judgment.thirdCount, judgment.fourthCount, judgment.fifthCount);
        System.out.println(statistics.resultMessage);
    }

    private String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private List<Integer> askLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    private String askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
