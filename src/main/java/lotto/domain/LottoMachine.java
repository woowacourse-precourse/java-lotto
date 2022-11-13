package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Const.*;

public class LottoMachine {

    private final int count;
    private final List<Lotto> lottos;

    public LottoMachine(int count) {
        this.count = count;
        this.lottos = order(count);
    }

    private List<Lotto> order(int count){
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() != count){
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private static Lotto makeLotto() {
        return new Lotto(getSortedNumbers(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE)));
    }

    private static List<Integer> getSortedNumbers(List<Integer> numbers) {
        return new ArrayList<>(numbers)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
