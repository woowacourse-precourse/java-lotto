package lotto;

import java.util.List;

public class User {
    private int purchasePrice;
    private List<List<Integer>> userLotto;

    User(int purchasePrice){
        validate(purchasePrice);

    }

    private void validate(int purchasePrice){
        if (purchasePrice % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }
}
