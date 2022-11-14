package lotto.domain;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import lotto.view.Input;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
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
