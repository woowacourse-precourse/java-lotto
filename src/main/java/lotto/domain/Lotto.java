package lotto.domain;

import lotto.model.ContainStatus;
import lotto.logic.LottoVerifier;
import lotto.model.WinningRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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
        if (result.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력 숫자가 중복되었습니다.");
        }

    }

    public ContainStatus isContainNumber(int LottoNumber) {
        return ContainStatus.setContainStatus(numbers.contains(LottoNumber));
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

    public Map<WinningRank, Integer> getWinningResult(List<List<Integer>> purchaseNumbers, LottoVerifier lottoVerifier) {
        Map<WinningRank, Integer> winResult = new EnumMap<>(WinningRank.class);

        for (List<Integer> lotto : purchaseNumbers) {
            WinningRank winningRank = getWinningRank(lotto, lottoVerifier);
            winResult.put(winningRank, winResult.getOrDefault(winningRank, 0) + 1);
        }
        return winResult;
    }

    public WinningRank getWinningRank(List<Integer> lotto, LottoVerifier lottoVerifier) {
        int result = getMatchingNumber(lotto);

        if (result == 6) {
            return WinningRank.one;
        }
        if (result == 5) {
            ContainStatus status = lottoVerifier.isBonus(lotto);
            if (status.getContain2Value()) {
                return WinningRank.two;
            }
            return WinningRank.three;
        }
        if (result == 4) {
            return WinningRank.four;
        }
        if (result == 3) {
            return WinningRank.five;
        }
        return WinningRank.notThing;
    }
}


