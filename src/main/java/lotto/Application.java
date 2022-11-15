package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //사용자에게 금액 입력 받기
        int userMoney = IOUtil.moneyInput();
        // 입력 받은 만큼 로또 발행
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = userMoney / 1000;
        while (lottos.size() < lottoCount) {
            Lotto lotto = Lotto.publishLotto();
            lottos.add(lotto);
        }
        IOUtil.printLottos(lottos);

    }
}
