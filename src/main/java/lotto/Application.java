package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 로또 구입 금액을 입력 받는다.
        System.out.println("구입금액을 입력해 주세요.");
        Price price = new Price(Console.readLine());
        // 1-3. 로또 구입 갯수 n(로또 구입 금액에서 1000원으로 나누어 떨어지는 몫)을 구한다.
        Integer n = price.getLottoNum();

        // 2. 로또 번호를 n장 만큼 구한다.
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }
}
