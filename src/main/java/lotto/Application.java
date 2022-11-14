package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    public List<Integer> getLottoResult(List<LottoNumber> buyList, List<Integer> winningLotto, int bonusNumber) {
        boolean bonus = isContainBonusNumber(winningLotto, bonusNumber);
        List<Integer> lottoResult = Arrays.asList(0, 0, 0, 0, 0);
        int equalNumberCount = 0;

        for (LottoNumber lottoNumber : buyList) {
            equalNumberCount = compareLotto(lottoNumber.getNumbers(), winningLotto);

            if (isWinning(equalNumberCount)) {
                int index = changeLottoResultNumber(equalNumberCount, bonus);
                lottoResult.set(index, lottoResult.get(index) + 1);
            }
        }
        return lottoResult;
    }

    private boolean isWinning(int equalNumberCount) {
        return equalNumberCount >= 3;
    }

    private int compareLotto(List<Integer> lottoNumber, List<Integer> winningLotto) {
        int equalNumberCount = 0;

        for (Integer number : lottoNumber) {
            if (winningLotto.contains(number)) {
                equalNumberCount += 1;
            }
        }
        return equalNumberCount;
    }

    private boolean isContainBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        return winningLotto.contains(bonusNumber);
    }

    private int changeLottoResultNumber(int count, boolean bonus) {
        if (count == 6) {
            return 0;
        }
        if (count == 5 && bonus) {
            return 1;
        }
        if (count == 5) {
            return 2;
        }
        if (count == 4) {
            return 3;
        }
        return 4;
    }

}
