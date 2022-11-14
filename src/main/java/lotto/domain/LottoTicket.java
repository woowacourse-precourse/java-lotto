package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {


    private int LOTTO_MIN_NUMBER = 1;
    private int LOTTO_MAX_NUMBER = 45;
    private int LOTTO_SIZE = 6;
    private List<List<Integer>> allGameLottoNumbers;
    private List<Integer> oneGameLottoNumbers;
    private List<Integer> lottoNumbers;
    private int lottoTickets;


    private LottoTicket(List<List<Integer>> allGameLottoNumbers, List<Integer> oneGameLottoNumbers, List<Integer> lottoNumbers, int lottoTickets) {
        this.allGameLottoNumbers = allGameLottoNumbers;
        this.oneGameLottoNumbers = oneGameLottoNumbers;
        this.lottoNumbers = lottoNumbers;
        this.lottoTickets = lottoTickets;
    }

    public List<List<Integer>> generateAllGameLottoNumber(int lottoTickets) {
        for (int i = 0; i < lottoTickets; i++) {
            allGameLottoNumbers.add(createLottoOneGameNumber());
        }
        return allGameLottoNumbers;
    }

    private List<Integer> createLottoOneGameNumber() {
        List<Integer> oneGameNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return oneGameNumbers;
    }

}
