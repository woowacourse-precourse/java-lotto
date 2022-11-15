package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {
    private static final int CNT_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int UNIT = 1000;
    private static final int INIT = 0;
    private static final String REGEX = "[0-9]+";
    private static List<List> userLotto = new ArrayList<>();

    public UserLotto() {
    }

    public int setPurchaseOfLotto(String purchaseAmount) {
        int lottoCount = INIT;

        validateLetter(purchaseAmount);
        validateUnit(Integer.parseInt(purchaseAmount));

        lottoCount = setNumberOfPurchases(Integer.parseInt(purchaseAmount));
        return lottoCount;
    }

    public int setNumberOfPurchases(int purchaseAmount) {
        return purchaseAmount / UNIT;
    }

    public void setPurchaseLottoNumbers(int lottoCount) {
        while (lottoCount > INIT) {
            setRandomLottoNumber();
            lottoCount--;
        }
    }

    public void setRandomLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, CNT_NUMBER);
        lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        new Lotto(lottoNumbers);

        userLotto.add(lottoNumbers);
    }

    public List<List> getUserLotto() {
        return userLotto;
    }

    public List<Integer> getPurchaseLottoGroup(int index) {
        return userLotto.get(index);
    }

    public void validateLetter(String input) {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR]구입 금액에 숫자외 문자가 존재합니다.");
        }
    }

    public void validateUnit(int amount) {
        if (amount % UNIT != INIT ) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
        }
    }

}
