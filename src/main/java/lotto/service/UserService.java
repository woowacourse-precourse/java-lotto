package lotto.service;


import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private int money;
    private Lotto lotto;

    public int buyLotto(String input) {
        buyValidate(input);
        money = Integer.valueOf(input);
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");

        return count;
    }

    private void buyValidate(String input) {
        final String REGEX = "[0-9]+";

//        if (!input.contains(REGEX)) throw new IllegalArgumentException();
        if (Integer.valueOf(input) % 1000 != 0) throw new IllegalArgumentException();
    }

    public Lotto createPlayerNumbers(String inputNums, int bonusNum) {

        List<Integer> inputNumbers = stringToList(inputNums);
        lotto = new Player(inputNumbers, bonusNum);

        return lotto;
    }

    private List<Integer> stringToList(String input) {
        String[] tmp = input.split(",");
        List<String> numbers = new ArrayList<>(Arrays.asList(tmp));
        validateInput(numbers);
        List<Integer> validateNums = numbers.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        return validateNums;
    }

    public void validateInput(List<String> numbers) {
        final String REGEX = "[0-9]+";

        if (numbers.size() != 6) throw new IllegalArgumentException();
//        if (!numbers.contains(REGEX)) throw new IllegalArgumentException();
    }

    public Lotto getLotto() {
        return lotto;
    }

}
