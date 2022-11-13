package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Output {
    private final String MESSAGE_TO_PRINT_COUNT = "개를 구매했습니다.";

    // user의 로또 출력하기
    public void printUserLottos(UserLottos userLottos) {
        printLottosCount(userLottos);
        System.out.println( sortLottos(userLottos) );
    }

    public void printLottosCount(UserLottos userLottos) {
        int count = userLottos.getLottoCount();
        System.out.println("\n" + count + MESSAGE_TO_PRINT_COUNT);
    }

    //출력 위해 로또 정렬하기 - 서비스 로직
    public Set<Lotto> sortLottos(UserLottos userLottos) {
        Set<Lotto> lottoSet = userLottos.getUserLottos();

        for (Lotto lotto : lottoSet) {
            List<Integer> copyLotto = new ArrayList<>(lotto.getNumbers());
            System.out.println(copyLotto);
        }
        return lottoSet;
    }

}
