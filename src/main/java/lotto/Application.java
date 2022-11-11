package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoStand;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1개의 로또 발행시 중복되지 않는 6개의 숫자를 만든다.
        // 무한대로 살수가 있다.그러면 while문이 아닐까


        LottoStand lottoStand = new LottoStand();
        int ticket = lottoStand.salesPerson(50000);

        for (int i = 0; i < ticket; i++) {
            List<Integer> lottoNumbers = null;
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(lottoNumbers);

            System.out.println(i+"번째 티켓"+ lottoNumbers);
        }

    }
}

