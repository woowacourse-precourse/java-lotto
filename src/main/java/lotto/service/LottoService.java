package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Computer;
import lotto.Lotto;
import lotto.validator.Validator;

public class LottoService {

    private final Validator validator;
    private final Computer computer;

    public LottoService(Validator validator, Computer computer) {
        this.validator = validator;
        this.computer = computer;
    }

    public List<Lotto> buy(String in) {
        validator.isValidPrice(in);
        int money = getMoney(in);
        return getLottos(money);
    }

    private int getMoney(String in) {
        return Integer.parseInt(in);
    }

    private List<Lotto> getLottos(int money) {
        int numberOfLotto = money / 1000;
        return IntStream.range(0, numberOfLotto)
            .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)).map(Lotto::new)
            .collect(Collectors.toList());
    }

    public List<Integer> getResult(List<Lotto> lottos, List<Integer> winns, int bonus) {
        return computer.getResult(lottos, winns, bonus);
    }

}
