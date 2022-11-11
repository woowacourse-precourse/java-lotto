package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
        if (!hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복이 존재합니다.");
        }
        if (!hasValidScope(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(winningNumbers);
    }

    public static void validateBonusNumber(int bonusNumber, Lotto winningNumbers) {
        if (winningNumbers.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 존재합니다.");
        }
    }

    public static boolean hasDuplication(List<Integer> numbers) {
        Set<Integer> elements = new HashSet<>(numbers);
        return elements.size() == 6;
    }

    public static boolean hasValidScope(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(0 < number && number < 46)) {
                return false;
            }
        }
        return true;
    }

    public static List<Lotto> getLottoList(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < money / 1000; index++) {
            lottoList.add(generateLottoList());
        }
        return lottoList;
    }

    private static Lotto generateLottoList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public static int compareNumbers(Lotto winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer number : winningNumbers.numbers) {
            if (lotto.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasBonusNumber(int bonusNumber, Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }

    @Override
    public  String toString() {
        return numbers.toString();
    }
}
