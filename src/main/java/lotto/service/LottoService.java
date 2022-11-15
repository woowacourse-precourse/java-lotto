package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Computer;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.validator.Validator;

public class LottoService {

    private final Validator validator;
    private final Computer computer;
    private int money;

    public LottoService(Validator validator, Computer computer) {
        this.validator = validator;
        this.computer = computer;
    }

    public List<Lotto> buy(String in) {
        validator.isValidPrice(in);
        money = getMoney(in);
        return getLottos();
    }

    private int getMoney(String in) {
        return Integer.parseInt(in);
    }

    private List<Lotto> getLottos() {
        int numberOfLotto = money / 1000;
        return IntStream.range(0, numberOfLotto)
            .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)).map(Lotto::new)
            .collect(Collectors.toList());
    }

    public LottoResult getResult(List<Lotto> lottos, String winns, String bonus) {
        validator.isValidWinAndBonus(winns, bonus);
        String[] split = winns.split(",");
        List<Integer> a = new ArrayList<>();
        for (String s:split) {
            a.add(Integer.parseInt(s));
        }
        List<Integer> result = computer.getResult(lottos, a, Integer.parseInt(bonus));
        return new LottoResult(money, result);
    }
}
