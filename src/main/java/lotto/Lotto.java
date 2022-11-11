package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private static void duplicateCheck(List<Integer> result) {
        if(result.stream().distinct().count()!=6){
            throw new IllegalArgumentException("[ERROR] 입력 숫자가 중복되었습니다.");
        };
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
    public void bonusNotIncludeWinningNumbers(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 로또번호에 포함되어 있습니다.");
        }
    }
    public int[] getWinningArray(List<List<Integer>> getPurchaseLottoList, Input input) {
        int[] result = new int[]{0, 0, 0, 0, 0};
        for (List<Integer> lotto : getPurchaseLottoList) {
            int index = getWinningIndex(lotto,input);
            if (index < 0) {
                continue;
            }
            result[index]++;
        }
        return result;
    }

    public int getWinningIndex(List<Integer> lotto, Input input) {
        int result = getMatchingNumber(lotto);
        if (result == 5) {
            ContainStatus status = input.isBonus(lotto);
            result += status.getContain1Value()*2;
        }
        if (result < 3) {
            return -1;
        }

        return result-3;
    }

    // TODO: 추가 기능 구현
}


