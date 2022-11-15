package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    // TODO: 추가 기능 구현
    private void validate(List<Integer> numbers) {
            if (numbers.size() != UniqueFile.MAX_COUNT) {
                throw new IllegalArgumentException(ErrorMessage.isNotMatch(UniqueFile.LOTTO));
            }
            for (int number : numbers) {
                if (number < UniqueFile.MIN || number > UniqueFile.MAX) {
                    throw new IllegalArgumentException(ErrorMessage.isOutOfBounds(UniqueFile.LOTTO));
                }
            }
            Set<Integer> removeRepeatedNumbers = new HashSet<>(numbers);
            if (removeRepeatedNumbers.size() != UniqueFile.MAX_COUNT) {
                throw new IllegalArgumentException(ErrorMessage.isRepeated(UniqueFile.LOTTO));
            }
        }

        public static Lotto createLotto() {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    UniqueFile.MIN, UniqueFile.MAX, UniqueFile.MAX_COUNT
            );
            return new Lotto(numbers);
        }

        public boolean contains(int number) {
            return numbers.contains(number);
        }

        public Rank match(WinNumber winNumber) {
            int matchCount = (int) numbers.stream()
                    .filter(winNumber.winningNumbers::contains)
                    .count();
            boolean matchBonusNumber = numbers.contains(winNumber.bonusNumber);
            return Rank.of(matchCount, matchBonusNumber);
        }

        @Override
        public String toString() {
            return numbers.stream().sorted().collect(Collectors.toList()).toString();
        }
    }