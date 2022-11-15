package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<Integer> winningNumbers;

    private final Integer bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        Set<Integer> lottoNumbers = convertToSet(winningNumbers);
        checkValidation(lottoNumbers);
        this.winningNumbers = lottoNumbers;

        Integer bonus = convertToBall(bonusNumber);
        checkValidation(bonus);
        this.bonusNumber = bonus;
    }

    public Set<Integer> getWinningNumbers() {
        return Collections.unmodifiableSet(winningNumbers);
    }

    public Rank getRank(Lotto lottoTicket) {
        int count = (int) winningNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
        boolean hasBonus = lottoTicket.contains(bonusNumber);
        return Rank.of(count, hasBonus);
    }

    private Set<Integer> convertToSet(String input) {
        return Arrays.stream(input.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(Integer::new)
                .collect(Collectors.toSet());
    }

    private Integer convertToBall(String input) {
        return new Integer(Integer.parseInt(input));
    }

    private void checkValidation(Set<Integer> lottoNumbers) {
        checkSize(lottoNumbers);
        checkRedundancy(lottoNumbers);
    }

    private void checkValidation(Integer bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("로또 당첨 번호와 보너스 번호가 중복됩니다");
        }
    }

    private void checkSize(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개입니다.");
        }
    }

    private void checkRedundancy(Set<Integer> lottoNumbers) {
        Set<Integer> uniqueSetOfNumbers = new HashSet<>(lottoNumbers);
        if (uniqueSetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 중복될 수 없습니다.");
        }
    }
}