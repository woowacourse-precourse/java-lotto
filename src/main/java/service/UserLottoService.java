package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.UserLotto;

import java.util.ArrayList;
import java.util.List;

public class UserLottoService {
    private final List<List<Integer>> randomNumbers = new ArrayList<>();

    public UserLotto createUserLotto(int purchaseNumber) {
        while(randomNumbers.size() < purchaseNumber) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomNumbers.add(numbers);
        }

        return new UserLotto(randomNumbers);
    }

    public String getUserLottoHistory(UserLotto userLotto) {
        StringBuilder userLottoHistory = new StringBuilder();

        for(int count = 0; count < userLotto.getUserLottoSize(); count++){
            userLottoHistory.append(userLotto.getUserLottoNumbers(count)).append("\n");
        }
        return userLottoHistory.toString();
    }
}