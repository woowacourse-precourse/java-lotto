package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {
    final static String TICKET_BOUGHT = "개를 구매했습니다.";
    public List<Lotto> generate(Integer money) {
        List<Lotto> lottoTickets = new ArrayList<Lotto>();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해야 합니다.");
        }
        Integer ticketCount = money.intValue() / 1000;
        System.out.println(ticketCount + TICKET_BOUGHT);
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(randomNumbers));
        }
        return lottoTickets;
    }

    public void printGeneratedLotto(List<Lotto> generatedLotto) {
        for (Lotto lotto : generatedLotto) {
            System.out.println(lotto.getLottoNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }
}
