package lotto;
import domain.Lotto;
import utils.IllegalInputChecker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    private final IllegalInputChecker illegalInputChecker = new IllegalInputChecker();

    @Override
    public int getCntOfLotto(int userPayment) {
        int cntOfLotto = userPayment / 1000;
        return cntOfLotto;
    }

    @Override
    public List<Integer> getUserNums(String userInput) {
        List<String> userInputList = Arrays.asList(userInput.split(","));
        List<Integer> userNumList = userInputList.stream()
                .map(string -> Integer.parseInt(string))
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(userNumList);
        return lotto.getNumbers();
    }

    @Override
    public int getUserBonus(String userBonus) {
        int bonus = Integer.parseInt(userBonus);
        return bonus;
    }
}