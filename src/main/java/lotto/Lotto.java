package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplicated(numbers);
        this.numbers = numbers;
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해야 합니다.");
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        Set<Integer> duplicated = new HashSet<>(numbers);

        if (duplicated.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static Lotto generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedLotto = lotto.stream().sorted().collect(Collectors.toList());

        return new Lotto(sortedLotto);
    }

    public static List<Lotto> buyMyLottos(int count) {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> buyLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            buyLottos.add(Lotto.generateLotto());
        }

        for (Lotto buyLotto : buyLottos) {
            buyLotto.printLotto();
        }
        return buyLottos;
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
