package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoCalculator;
import lotto.error.InputError;
import lotto.input.Input;
import lotto.output.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = inputValues();
        LottoCalculator lottoCalculator = new LottoCalculator(input);
        lottoCalculator.checkHit();
        Output output = new Output(lottoCalculator.getWinningLotto());
        output.printWinningHistory();
        output.printEarn(lottoCalculator.calculateEarn());
    }

    public static Input inputValues() {
        int inputPurchaseAmount = inputPurchaseAmount();
        List<Integer> winningNumbers = inputWinningNumber();
        Collections.sort(winningNumbers);
        int bonusNumber = inputBonusNumber();
        return new Input(inputPurchaseAmount, winningNumbers, bonusNumber);
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = 0;
        try {
            purchaseAmount = parseInt(Console.readLine());
        } catch (Exception e) {
            System.out.println("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
            //throw new IllegalArgumentException();
        }
        return purchaseAmount;
    }

    private static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        return typeChange(numbers);
    }

    private static List<Integer> typeChange(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(parseInt(number));
        }
        return winningNumbers;
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return parseInt(Console.readLine());
    }

}
