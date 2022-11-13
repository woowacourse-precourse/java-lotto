package lotto.domain;

import java.util.List;

public class Output {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.",lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
