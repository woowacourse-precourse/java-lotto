package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.END_NUMBER;
import static lotto.constant.LottoConstant.START_NUMBER;
import static lotto.constant.MessageConstant.PURCHASE_MESSAGE;

public class LottoNumber {

    private List<List<Integer>> userAllLotto = new ArrayList<>();
    private final int lottoCount;

    public LottoNumber(int lottoCount) {
        this.lottoCount = lottoCount;
        createCountOfLotto();
        printUserAllLotto();
    }

    public void createLottoNumber() {
        List<Integer> myLotto = Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(),6);
        userAllLotto.add(myLotto);
    }

    public void createCountOfLotto() {
        for (int count = 0; count < lottoCount; count++) {
            createLottoNumber();
        }
    }

    public List<List<Integer>> getUserAllLotto() {
        return userAllLotto;
    }

    public void printUserAllLotto() {
        System.out.println(String.format(PURCHASE_MESSAGE.getMessage(), lottoCount));
        for (List<Integer> lotto: userAllLotto) {
            System.out.println(lotto);
        }
    }
}
