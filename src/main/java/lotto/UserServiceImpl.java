package lotto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    private static int cntOfLotto = 0;
    private static List<Integer> userNumList;
    private static int bonus;
    private CheckInputIllegal checkInputIllegal;

    @Override
    public int getCntOfLotto(int userPayment) {
        checkInputIllegal.checkUserPayIllegal(userPayment);
        cntOfLotto = userPayment / 1000;
        return cntOfLotto;
    }

    @Override
    public List<Integer> getUserNums(String userInput) {
        checkInputIllegal.checkUserInputIllegal(userInput);
        List<String> userInputList = Arrays.asList(userInput.split(","));
        userNumList = userInputList.stream()
                .map(string -> Integer.parseInt(string))
                .collect(Collectors.toList());

        checkInputIllegal.checkUserNumListIllegal(userNumList);
        return userNumList;
    }

    @Override
    public int getUserBonus(String userBonus) {
        checkInputIllegal.checkUserBonusIllegal(userBonus);
        bonus = Integer.parseInt(userBonus);
        return bonus;
    }
}
