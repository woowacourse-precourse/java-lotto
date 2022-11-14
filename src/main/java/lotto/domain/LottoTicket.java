package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {


    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private List<Integer> lottoNumbers;
    private int lottoTickets;


    private LottoTicket(List<Integer> lottoNumbers, int lottoTickets) {
        this.lottoNumbers = lottoNumbers;
        this.lottoTickets = lottoTickets;
    }

    public static List<Integer> createLottoOneGameNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

}
