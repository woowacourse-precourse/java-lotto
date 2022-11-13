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

        // TODO: 발행한 로또 번호 출력
        //Message.printLottoTickets(this.lottoTickets);
    }

    private void setLottoTickets(int nLottoTickets){
        this.lottoTickets = new ArrayList<>();
        for (int i=0; i < nLottoTickets; i++){

            Lotto lotto = new Lotto(ServiceInput.getLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

}
