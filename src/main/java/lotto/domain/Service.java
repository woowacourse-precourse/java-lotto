package lotto.domain;

import lotto.constant.Message;
import lotto.util.ServiceInput;
import lotto.util.Validator;

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
        Message.printNextLine();

        Message.printInputServiceWinningNumbers();
        setWinningNumbers();
        Message.printNextLine();

        Message.printInputServiceBonusNumber();
        setBonusNumber();
        Message.printNextLine();
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
        int bonusNumber = ServiceInput.getBonusNumber();
        validateBonusNumberInWinningNumbers(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInWinningNumbers(int bonusNumber){

        for (int i=0; i< this.winningNumbers.size(); i++){
            validateDuplicateBonusNumber(bonusNumber, this.winningNumbers.get(i));
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber, int winningNumber) {

        if (Validator.isSame(bonusNumber,winningNumber)){
            Message.printInputErrorDuplicateBonusNumber();
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
