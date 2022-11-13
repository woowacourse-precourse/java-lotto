package lotto.domain;

import lotto.util.ServiceInput;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Lotto> lottoTickets;

    public Service(int nLottoTickets){
        setLottoTickets(nLottoTickets);
    }

    private void setLottoTickets(int nLottoTickets){
        this.lottoTickets = new ArrayList<>();
        for (int i=0; i < nLottoTickets; i++){

            Lotto lotto = new Lotto(ServiceInput.getLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

}
