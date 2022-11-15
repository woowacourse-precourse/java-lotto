package lotto.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    // 한장의 로또를 만들어주는 메서드
    private static List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 금액만큼 로또번호를 만들어주는 메서드
    public static List<List<Integer>> createLottos(int receivedMoney) {
        int ticketCount = receivedMoney / 1000;
        List<List<Integer>> lottoTicket = new ArrayList<>();

        while (ticketCount != 0) {
            List<Integer> LottoNumbers = createLottoNumber();
            lottoTicket.add(LottoNumbers);
            ticketCount--;
        }
        return lottoTicket;
    }
}
