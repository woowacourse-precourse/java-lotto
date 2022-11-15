package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    /**
     * count 개수만큼 로또를 생성하는 메소드
     */
    public static List<Lotto> create(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while (count-- > 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_COUNT)));
        }

        return lottos;
    }

    /**
     * 로또의 번호 정보들을 문자열로 반환하는 메소드
     */
    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }

    /**
     * 맞는 개수와 보너스 번호의 여부로 등수를 반환하는 메서드
     */
    public Rank getRank(WinningNumber winningNumber) {
        return Rank.of(getMatchingCount(winningNumber), hasBonus(winningNumber));
    }

    /**
     * 당첨 번호와 비교해 맞는 개수를 반환하는 메소드
     */
    private int getMatchingCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::hasNumber)
                .count();
    }

    /**
     * 보너스 번호가 있는지에 대한 여부를 반환하는 메소드
     */
    private boolean hasBonus(WinningNumber winningNumber) {
        return numbers.contains(winningNumber.getBonus());
    }
}
