package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoDto {
    private final List<Lotto> lottos;

    public LottoDto(int money) {
        validate(money);

        this.lottos = createLottoList(money / 1000);
    }

    private List<Lotto> createLottoList(int size) {
        List<Lotto> newLottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> newNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(newNumbers);

            newLottos.add(lotto);
        }

        return newLottos;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public List<Lotto> getLottoList() {
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
