package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lotto.reward.Reward;

public class LottoService {
    public int getLottoAmount(String number) {
        int balance = 0;

        try {
            balance = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("구입금액으로 입력된 문자열이 올바르지 않습니다.");
        }

        if (balance % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위이어야 합니다.");
        }

        return balance / 1000;
    }

    public List<Lotto> generateLottos(int amount) {
        List<Lotto> lottoResult = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers = new ArrayList<>(lottoNumbers);
            lottoNumbers.sort(Integer::compareTo);

            lottoResult.add(new Lotto(lottoNumbers));
        }

        return lottoResult;
    }

    public static void validateMatchNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }

        Set<Integer> isNumbersDuplicated = new TreeSet<>(numbers);
        if (isNumbersDuplicated.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    public List<Integer> getMatchNumbers(String matchNumbers) {
        String[] matchNumbersDivideByComma = matchNumbers.split(",");
        List<Integer> result = new ArrayList<>();

        try {
            for (String number : matchNumbersDivideByComma) {
                result.add(Integer.parseInt(number));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("당첨번호로 입력된 문자열이 올바르지 않습니다.");
        }

        validateMatchNumbers(result);
        return result;
    }

    public int getBonusNumber(String bonusNumber, List<Integer> matchNumbers) {
        int result = 0;
        try {
            result = Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("보너스 번호로 입력된 문자열이 올바르지 않습니다.");
        }
        if (matchNumbers.contains(result)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }

        return result;
    }

    public int calculateMatched(Lotto lotto, List<Integer> matchNumbers) {
        int count = 0;
        for (int match : matchNumbers) {
            if (lotto.getNumbers().contains(match)) {
                count++;
            }
        }
        return count;
    }

    public int calculateReward(int matched, boolean isBonusNumberContained) {
        if (matched == 6) {
            return 4;
        }
        if (matched == 5) {
            if (isBonusNumberContained) {
                return 3;
            }
            return 2;
        }
        return matched - 3;
    }

    public int[] calculateRewards(List<Lotto> lottos, List<Integer> matchNumbers, int bonusNumber) {
        int[] rewards = {0, 0, 0, 0, 0};
        for (Lotto lotto : lottos) {
            int matched = calculateMatched(lotto, matchNumbers);
            int rewardIdx = calculateReward(matched, matchNumbers.contains(bonusNumber));
            if (rewardIdx >= 0) {
                rewards[rewardIdx]++;
            }
        }
        return rewards;
    }

    public double getProfitRate(int[] rewards, int lottoAmount) {
        long result = 0L;
        Reward[] rewardAmount = Reward.values();

        for (int i = 0; i < 5; i++) {
            result += rewardAmount[i].getValue() * rewards[i];
        }

        return result / (double) (lottoAmount * 1000);
    }
}
