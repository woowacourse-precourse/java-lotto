package lotto.domain;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;
import lotto.view.Input;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_DIGIT.getErrorMessage());
        }
        Set<Integer> numbersSet= new HashSet<>(numbers);
        if(numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public static List<List<Integer>> makeLottoByRandomNumbers (double countPurchasing) {
        List<List<Integer>> purchasedLotteries = new ArrayList<>();

        for(int i = 0; i<countPurchasing; i++) {
            List<Integer> individualLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(individualLotto);
            purchasedLotteries.add(individualLotto);
        }
        return purchasedLotteries;
    }


    public static List<Integer> getWinningNumbers() {
        //중복,1~45 조건 필요
        String inputWinningNumbers = Input.input();
        List<Integer> winningNumbers = new ArrayList<>();

        String[] inputNumbersArray = inputWinningNumbers.split(",");

        for (String s : inputNumbersArray) {
            winningNumbers.add(parseInt(s));
        }
        new Lotto(winningNumbers);

        return winningNumbers;

    }

    public static Integer getBonusNumber() {
        //중복, 1~45 조건 필요
        String inputBonusNumber = Input.input();
        return parseInt(inputBonusNumber);
    }
}
