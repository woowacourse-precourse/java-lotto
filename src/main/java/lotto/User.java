package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class User {

    private static  final int UNIT_PRICE = 1000;
    private int purchasePrice;
    private List<List<Integer>> userLottos;

    User(int purchasePrice){
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;

        int count = purchasePrice / UNIT_PRICE;

        this.userLottos = purchaseLottos(count);
    }

    private void validate(int purchasePrice){
        if (purchasePrice % UNIT_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    private List<List<Integer>> purchaseLottos(int count){
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            lottos.add(Randoms.pickUniqueNumbersInRange(1,45,6));
        }

        return lottos;
    }
}
