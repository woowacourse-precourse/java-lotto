package lotto;
import lotto.Controller;
public class Application {
    public static void main(String[] args) {
       InputView inputView = new InputView();
        LottoNumberCreator lottoCreator = new LottoNumberCreator((inputView.getTicketMoney()));
        lottoCreator.showHowManyTickets();
       inputView.pressLottoNumbers();
       Lotto lotto = new Lotto(inputView.getLottoNumbers());
       inputView.pressBonusNumber();
       Controller controller = new Controller(lotto.getLottoNumbers(), inputView.getBonusNumber(), inputView.getTicketMoney());
       controller.showLottoWinningResult(lottoCreator.getNumbersContainer());


    }
}

