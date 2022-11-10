package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public ContainStatus isContainNumber(int LottoNumber) {
        if(numbers.contains(LottoNumber))
        {
            return ContainStatus.Contain;
        }

        return ContainStatus.NotContain;
    }

    public int getMatchingNumber(List<Integer> LottoNumbers) {
        int result = 0;

        for (Integer lottoNumber : LottoNumbers) {
            ContainStatus status = isContainNumber(lottoNumber);
            result += status.getContain1Value();
        }

        return result;
    }

//    public int[] getWinningArray(List<List<Integer>> getPurchaseLottoList, int bonus) {
//        int[] result = new int[]{0, 0, 0, 0, 0};
//        for (List<Integer> lotto : getPurchaseLottoList) {
//            int index = getWinningIndex(lotto, bonus);
//        }
//    }

    private int getWinningIndex(List<Integer> lotto, int bonus) {
        int result = getMatchingNumber(lotto);
        if (result == 5) {
            ContainStatus status = isContainNumber(bonus);
            result += status.getContain1Value()*2;
        }
        if (result < 3) {
            return -1;
        }

        return result-3;
    }

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<List<Integer>> getPurchaseLottoList(int purchaseNumber) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            result.add(getLottoNumbers());
        }
        return result;
    }

    // TODO: 추가 기능 구현
}


