package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.console.Console;
import lotto.console.MoneyInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final String PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO = "개를 구매했습니다.";
    private final Console moneyInput = new MoneyInput();
    private int lottoAmount;
    private List<Lotto> lottos = new ArrayList<>();

    public void payLotto() {
        System.out.println(PLEASE_INPUT_MONEY);
        calculateLottoAmount(moneyInput.getUserInput());
        System.out.println();
    }

    private void calculateLottoAmount(String input) {
        lottoAmount = Integer.parseInt(input) / 1000;
    }

    public void buyLotto() {
        System.out.println(lottoAmount + BUY_LOTTO);
        lottos.clear();
        lottos = Stream.generate(this::makeLotto)
                .filter(this::isExistLotto)
                .limit(lottoAmount)
                .collect(Collectors.toList());
        printLottos(lottos);
    }

    private Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private boolean isExistLotto(Lotto lotto) {
        for (Lotto existLotto : lottos) {
            if (existLotto.equals(lotto))
                return false;
        }
        return true;
    }

    private void printLottos(List<Lotto> lottos){
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
