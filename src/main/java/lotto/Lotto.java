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

    public boolean isContainNumber(int LottoNumber) {
        return numbers.contains(LottoNumber);
    }

    public int getMatchingNumber(List<Integer> LottoNumbers) {
        int result = 0;

        for (Integer lottoNumber : LottoNumbers) {
            ContainStatus status = ContainStatus.NotContain;
            if (isContainNumber(lottoNumber))
            {
                status = ContainStatus.Contain;
            }
            result += status.getContain1Value();
        }
        return result;

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


