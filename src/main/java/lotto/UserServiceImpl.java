package lotto;
import domain.Lotto;
import utils.IllegalInputFormChecker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    private static int cntOfLotto = 0;
    private static List<Integer> userNumList;
    private static int bonus;
    private IllegalInputFormChecker illegalInputFormChecker = new IllegalInputFormChecker();

    @Override
    public int getCntOfLotto(int userPayment) {
        cntOfLotto = userPayment / 1000;
        return cntOfLotto;
    }

    @Override
    public List<Integer> getUserNums(String userInput) {
        List<String> userInputList = Arrays.asList(userInput.split(","));
        userNumList = userInputList.stream()
                .map(string -> Integer.parseInt(string))
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(userNumList);
        return lotto.getNumbers();
    }

    @Override
    public int getUserBonus(String userBonus) {
        bonus = Integer.parseInt(userBonus);
        return bonus;
    }
}
