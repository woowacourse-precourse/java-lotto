package lotto.model;

import lotto.Enum.Number;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicketing {
    private final List<Lotto> lottoTickets;

    public LottoTicketing(int LottoTicketNum){
        List<Lotto> newLottoTicket = setLottoNumbers(LottoTicketNum);
        this.lottoTickets = new ArrayList<>(newLottoTicket);
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }
    private List<Lotto> setLottoNumbers(int NumberOfTickets){
        List<Lotto> newLotto = new ArrayList<>();

        for(int i = 0; i < NumberOfTickets; i++){
            newLotto.add(new Lotto(pickLottoNumbers()));
        }

        return newLotto;
    }

    private List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Number.MIN.getValue(),
                Number.MAX.getValue(),
                Number.SIZE.getValue()
        );
    }

}
