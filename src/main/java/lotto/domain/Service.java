package lotto.domain;

import lotto.constant.Message;
import lotto.util.ServiceInput;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Lotto> lottoTickets;

    public Service(int nLottoTickets){
        setLottoTickets(nLottoTickets);
        Message.printNumberLottoTickets(nLottoTickets);
        Message.printLottoTickets(this.lottoTickets);

        Message.printInputWinningNumbers();
    }

    private void setLottoTickets(int nLottoTickets){
        this.lottoTickets = new ArrayList<>();
        for (int i=0; i < nLottoTickets; i++){

            Lotto lotto = new Lotto(ServiceInput.getLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

}
