package lotto.service;


import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

public class UserService {
    private int money;
    private Lotto lotto;

    public int buyLotto(String input) {
        int count = 0;
        buyValidate(input);

        money = Integer.valueOf(input);
        count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    private void buyValidate(String input) {
        final String REGEX = "[0-9]+";

        if (!input.matches(REGEX)) throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        if (Integer.valueOf(input) % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
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

        if (numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 6개의 번호만 쉼표로 구분해 입력해 주세요.");
        for (String validate:numbers) {
            if(!Pattern.matches(REGEX, validate))
                throw new IllegalArgumentException("[ERROR] 문자가 아닌 번호만 공백 없이 입력해 주세요.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

}
