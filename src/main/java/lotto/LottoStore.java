package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static void start() {
        String inputer = LottoPrinter.inputer("구입금액을 입력해 주세요.");
        Money money = new Money(inputer);

        int lottoCount = (int)(money.getMoney() / 1000);
        List<Lotto> lottos = addLotto(lottoCount);
        LottoPrinter.lottosPrint(lottos);
    }

    private static List<Lotto> addLotto(int lottoCount) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
