package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    private List<Lotto> lottoTickets;

    public Service(int nLottoTickets){

        setLottoTickets(nLottoTickets);
    }

    private void setLottoTickets(int nLottoTickets){
        this.lottoTickets = new ArrayList<>();
        for (int i=0; i < nLottoTickets; i++){

            // TODO: 로또 6개 랜덤 번호 생성 구현
            Lotto lotto = new Lotto(Arrays.asList(0,0,0,0,0,0));
            lottoTickets.add(lotto);
        }
    }

}
