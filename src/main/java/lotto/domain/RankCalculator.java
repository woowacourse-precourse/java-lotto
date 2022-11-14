package lotto.domain;

import java.util.List;
import java.util.Map;

public class RankCalculator {

    private Map<Rank, Integer> rank;

    public RankCalculator(List<Lotto> lottoTickets, UserNumber userNumber) {
        countRank(lottoTickets, userNumber); // 로또 숫자들과 사용자 숫자 비교
    }

    private void countRank(List<Lotto> lottoTickets, UserNumber userNumber) {

        for (Lotto lottoTicket : lottoTickets) {
            compareLottoWithUser();// 로또 숫자와 사용자 숫자 비교
            // 당첨 여부 갱신
        }
    }

    private void compareLottoWithUser() {
        compareBonusNumber(); // 똑같은 숫자가 5개일 경우 보너스 번호 비교
    }

    private void compareBonusNumber() {

    }
}
