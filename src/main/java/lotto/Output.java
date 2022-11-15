package lotto;

import java.util.List;

public class Output {
    public void printIssuedLotto(List<Lotto> issuedLotto) {
        System.out.print(issuedLotto.size() + "개를 구매했습니다.\n");
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto);
        }
    }
}
