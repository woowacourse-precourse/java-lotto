package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.EnumMap;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) throws IllegalArgumentException {
        checkNumberLength(numbers);

        for (Integer number : numbers) {
            checkNumberRange(number);
        }

        makeSureUniqueNumbers(numbers);
    }

    public void validateBonus(int bonusNumer) throws IllegalArgumentException {
        checkNumberRange(bonusNumer);

        makeSureUniqueNumber(bonusNumer, numbers);
    }

    public List<Integer> countMatches(List<List<Integer>> lottoBundle) {
        Set<Integer> winningNumbers = new HashSet<>(numbers);
        List<Integer> result = new ArrayList<>();

        for (List<Integer> singleLotto : lottoBundle) {
            Set<Integer> mySingleLotto = new HashSet<>(singleLotto);
            mySingleLotto.retainAll(winningNumbers);
            result.add(mySingleLotto.size());
        }

        return result;
    }

    public List<Boolean> matchBonus(int bonusNumber, List<List<Integer>> lottoBundle) throws IllegalArgumentException {
        validateBonus(bonusNumber);
        List<Boolean> result = new ArrayList<>();
        for (List<Integer> singleLotto : lottoBundle) {
            result.add(singleLotto.contains(bonusNumber));
        }

        return result;
    }

    public double calculateRewardRate(int bonusNumber, List<List<Integer>> lottoBundle, long totalMoney) {
        double sum = 0;
        List<Integer> normalNumbers = countMatches(lottoBundle);
        List<Boolean> bonusNumbers = matchBonus(bonusNumber, lottoBundle);

        for (int singleLotto = 0; singleLotto < normalNumbers.size(); singleLotto++){
            int match = normalNumbers.get(singleLotto);
            boolean bonus = bonusNumbers.get(singleLotto);
            sum += WinningNumbers.getMatchedReward(match, bonus);
        }

        return (sum / totalMoney) * 100L;
    }

    public Map<WinningNumbers, Long> countWinningCase(int bonusNumber, List<List<Integer>> lottoBundle) {
        List<Integer> normalNumbers = countMatches(lottoBundle);
        List<Boolean> bonusNumbers = matchBonus(bonusNumber, lottoBundle);
        Map<WinningNumbers, Long> result = new EnumMap<>(WinningNumbers.class);

        for (int singleLotto = 0; singleLotto < normalNumbers.size(); singleLotto++) {
            int match = normalNumbers.get(singleLotto);
            boolean bonus = bonusNumbers.get(singleLotto);
            WinningNumbers keyEnum = WinningNumbers.getEnum(match,bonus);

            result.put(keyEnum,result.getOrDefault(keyEnum,0L) + 1L);
        }

        return result;
    }

    private void checkNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자의 갯수는 6개만 가능합니다.");
        }
    }

    private void checkNumberRange(int number) throws IllegalArgumentException {
        if (!(number>=1 && number <=45)) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45까지만 가능합니다.");
        }
    }

    private void makeSureUniqueNumbers(List<Integer> numbers) throws IllegalArgumentException{
        Set uniqueNumbersCounter = new HashSet(numbers);
        if (uniqueNumbersCounter.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 입력은 불가능 합니다.");
        }
    }

    private void makeSureUniqueNumber(int number, List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 이미 있던 숫자와 중복 할 수 없습니다.");
        }
    }
}
