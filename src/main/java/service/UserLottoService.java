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
}