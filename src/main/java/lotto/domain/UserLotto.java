package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class UserLotto {
    private final int userMoney;
    private List<Lotto> userLottos;

    public UserLotto(int userMoney) {
        LottoValidation.canBuyLotto(userMoney);
        this.userMoney = userMoney;
        createLottos();
    }

    public int getUserMoney() {
        return userMoney;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public int countOfPurchasedLotto() {
        return userMoney / LOTTO_BASE_PRICE;
    }

    private void createLottos() {
        int countOfPurchasedLotto = countOfPurchasedLotto();
        userLottos = new ArrayList<>();

        while (userLottos.size() != countOfPurchasedLotto) {
            Lotto lotto = new Lotto(sortLotto(createLotto()));
            userLottos.add(lotto);
        }
    }

    private List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_COUNT_NUMBER);
    }
    private List<Integer> sortLotto(List<Integer> lottoNumbers) {
        List<Integer> sortedLotto = new ArrayList<>( lottoNumbers);
        sortedLotto.sort(Integer:: compareTo);
        return sortedLotto;
    }



}
