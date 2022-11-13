package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private final int moneyUnit = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public List<Integer> createLotto() {
        List<Integer> lottoNumber;

        while (true) {
            lottoNumber = createLottoNumber();

            if (isDistinctNumber(lottoNumber)) {
                break;
            }
        }
        return lottoNumber;
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private boolean isDistinctNumber(List<Integer> number) {
        Set<Integer> reuslt = new HashSet<>(number);

        return number.size() == reuslt.size();
    }

    public List<LottoNumber> saveLotto(int money) {
        List<LottoNumber> buyList = new ArrayList<>();

        validMoney(money);

        int buyCount = money / moneyUnit;

        for (int cnt = 0; cnt < buyCount; cnt++) {
            buyList.add(new LottoNumber(createLotto()));
        }
        return buyList;
    }

    private void validMoney(int money) {
        if (money < moneyUnit || money % moneyUnit != 0) {
            throw new IllegalArgumentException();
        }
    }


}
