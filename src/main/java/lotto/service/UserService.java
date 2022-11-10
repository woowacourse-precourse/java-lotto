package lotto.service;


import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private Lotto lotto;

    public int buyLotto(String input) {

        int money = Integer.valueOf(input);

        buyValidate(money);
        int count = money / 1000;

        return count;
    }

    private void buyValidate(int money) {
        if (money % 1000 != 0) throw new IllegalArgumentException();
    }

    public Lotto createPlayerNumbers(String inputNums, int bonusNum) {

        List<Integer> inputNumbers = stringToList(inputNums);
        lotto = new Player(inputNumbers, bonusNum);

        return lotto;
    }

    private List<Integer> stringToList(String input) {
        String[] tmp = input.split(",");
        List<String> validateNums = new ArrayList<>(Arrays.asList(tmp));

        validateInput(validateNums);

        List<Integer> numbers = validateNums.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return numbers;
    }

    public void validateInput(List<String> validateNums) {
        final String REGEX = "[0-9]+";

        if (validateNums.size() != 6) throw new IllegalArgumentException();
        if (!validateNums.contains(REGEX)) throw new IllegalArgumentException();
    }

    public Lotto getLotto() {
        return lotto;
    }
}
