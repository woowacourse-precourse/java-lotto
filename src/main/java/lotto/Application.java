package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buyLotto(2000);
        lottoMachine.printLottosInfo(lottos);

    }


}
