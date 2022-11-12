package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lotto.constant.PriceConstant;

public class UserLottos {
    private List<Lotto> userLottos = new ArrayList<>();

    public UserLottos(Integer price) {
        setUserLottos(price);
    }

    private void setUserLottos(Integer price) {
        int lottoNums = calculateLottoNums(price);
        for (int i = 0; i < lottoNums; i++) {
            userLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));

        }
    }

    private Integer calculateLottoNums(Integer price) {
        return price / PriceConstant.LOTTO_PRICE;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
