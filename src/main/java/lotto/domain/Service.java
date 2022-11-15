package lotto.domain;

import lotto.constant.Message;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.util.Converter;
import lotto.util.ServiceInput;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Lotto> lottoTickets;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

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
        List<String> splitInputWinningNumbers = ServiceInput.getSplitInputWinningNumbers();
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i=0; i<splitInputWinningNumbers.size(); i++){
            winningNumbers.add(Converter.StringToInteger(splitInputWinningNumbers.get(i)));
        }

        this.winningNumbers = new WinningNumbers(winningNumbers);
    }

    private void setBonusNumber(){
        String inputBonusNumber = ServiceInput.getInputBonusNumber();
        int bonusNumber = Converter.StringToInteger(inputBonusNumber);

        validateBonusNumberInWinningNumbers(bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateBonusNumberInWinningNumbers(int bonusNumber){
        for (int i=0; i< this.winningNumbers.getNumbers().size(); i++){
            validateDuplicateBonusNumber(bonusNumber, this.winningNumbers.getNumbers().get(i));
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
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
