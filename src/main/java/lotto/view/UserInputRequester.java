package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.User;
import lotto.exception.UserPriceInputException;

public class UserInputRequester {

    private UserPriceInputException userPriceInputException = new UserPriceInputException();

    public User setLottoNumbers() {
        printLottoPriceQuestion();
        String lottoPriceInput = getLottoPriceInput();
        userPriceInputException.isUserPriceValid(lottoPriceInput);
        User user = new User(Integer.valueOf(lottoPriceInput));
        List<List<Integer>> userLottoNumberGroup = user.getUserLottoNumberGroup();
        printLottoNumberCount(userLottoNumberGroup);
        printLottoNumberGroup(userLottoNumberGroup);
        return user;
    }

    private void printLottoPriceQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private String getLottoPriceInput() {
        return Console.readLine();
    }

    private void printLottoNumberCount(List<List<Integer>> lottoNumberGroup) {
        System.out.println(lottoNumberGroup.size() + "개를 구매했습니다.");
    }

    private void printLottoNumberGroup(List<List<Integer>> lottoNumberGroup) {
        for (int i = 0; i < lottoNumberGroup.size(); i++) {
            System.out.println(lottoNumberGroup.get(i));
        }
    }
}
