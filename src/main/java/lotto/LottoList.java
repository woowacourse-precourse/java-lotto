package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottos = new ArrayList<>();
    private int amount;

    public List<Lotto> getLottoList() {
        return lottos;
    }

    public LottoList() {
        this.amount = 0;
    }

    public void generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        appendLotto(new Lotto(numbers));
        amount++;
    }
    public void printLottoList() {
        System.out.println(amount + "개를 구매했습니다.");
        for (var lotto : lottos) {
            lotto.printNumbers();
        }
    }

    private void appendLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }


}
