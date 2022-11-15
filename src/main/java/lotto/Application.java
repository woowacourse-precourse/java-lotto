package lotto;
import lotto.Controller;
public class Application {

    public static void main(String[] args) {
        Integer money;
       InputView inputView = new InputView();
       try {
           money = inputView.money(inputView.inputMoney());
       }catch(Exception e) {
           money = inputView.money(inputView.inputMoney());
           System.out.println(e.getMessage());
       }
        LottoNumberCreator lottoCreator = new LottoNumberCreator(money);
        lottoCreator.showHowManyTickets();
       inputView.pressLottoNumbers();
       Lotto lotto = new Lotto(inputView.getLottoNumbers());
       inputView.pressBonusNumber();
       Controller controller = new Controller(lotto.getLottoNumbers(), inputView.getBonusNumber(), inputView.getTicketMoney());
       controller.showLottoWinningResult(lottoCreator.getNumbersContainer());
    }
}

