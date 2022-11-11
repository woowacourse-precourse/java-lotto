package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.application.service.agent.InputAgent;
import lotto.application.service.validator.ValueValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValueValidator.validateInputLottoNumber(numbers);
    }

    public static List<List<Integer>> generateLottoNumber(int purchaseNumber) {
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();

        for (int number = 0; number < purchaseNumber; number++) {
            generatedLottoNumber.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return generatedLottoNumber;
    }

    public static void getGeneratedLottoNumber(List<List<Integer>> generatedLottoNumber) {
        for (List<Integer> eachLottoPaper : generatedLottoNumber) {
            System.out.println(Arrays.toString(Arrays.stream(eachLottoPaper.toArray()).sorted().toArray()));
        }
    }

    public static List<Integer> inputWinningLottoNumbers() {
        InputAgent inputAgent = new InputAgent();
        List<Integer> inputLottoNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요.");
        inputLottoNumbers.addAll(inputAgent.inputWinningNumbers());
        return inputLottoNumbers;
    }

    public int inputWinningBonusNumber(List<Integer> numbers) {
        InputAgent inputAgent = new InputAgent();
        System.out.println("\n보너스 번호를 입력해주세요.");
        return inputAgent.inputWinningBonusNumber(numbers);
    }
}
