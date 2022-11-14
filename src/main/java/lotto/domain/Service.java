package lotto.domain;

import lotto.constant.Message;
import lotto.util.ServiceInput;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Service(int nLottoTickets){
        setLottoTickets(nLottoTickets);
        Message.printNumberLottoTickets(nLottoTickets);
        Message.printLottoTickets(this.lottoTickets);

        Message.printInputServiceWinningNumbers();
        setWinningNumbers();
        Message.printInputServiceBonusNumber();
        setBonusNumber();
    }

    private void setLottoTickets(int nLottoTickets){
        this.lottoTickets = new ArrayList<>();
        for (int i=0; i < nLottoTickets; i++){

            Lotto lotto = new Lotto(ServiceInput.getLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

    private void setWinningNumbers() {
        this.winningNumbers = ServiceInput.getWinningNumbers();
    }

    private void setBonusNumber(){
        this.bonusNumber = ServiceInput.getBonusNumber();
    }
}
