package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberIssue {
    private final int purchaseQuantity;

    public LottoNumberIssue(int purchaseQuantity) {
        validate(purchaseQuantity);
        this.purchaseQuantity = purchaseQuantity;
    }

    private void validate(int purchaseQuantity) {
        if (purchaseQuantity == 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> lottoIssue() {
        List<List<Integer>> lottoNumber = createLottoNumber();
        //sortAscending(lottoNumber);
        return lottoNumber;
    }

    private void sortAscending(List<List<Integer>> lottoNumber) {
        for(int i = 0; i < lottoNumber.size(); i++) {
            Collections.sort(lottoNumber.get(i));
        }
    }

    public List<List<Integer>> createLottoNumber() {
        List<List<Integer>> lottoNumber = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoNumber.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoNumber;
    }
}
