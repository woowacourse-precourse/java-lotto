package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateLotto {
    private final List<Lotto> lottos;

    public CreateLotto(int cnt) {
        this.lottos = makeLotto(cnt);
    }

    private List<Lotto> makeLotto(int cnt) {
        List<Lotto> listLotto = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            listLotto.add(lotto);
        }

        return listLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(lottos.size()).append("개를 구매했습니다.");

        lottos.stream().map(Lotto::getNumbers)
                .forEach(numbers -> sb.append("\n").append(numbers));

        return sb.toString();
    }
}
