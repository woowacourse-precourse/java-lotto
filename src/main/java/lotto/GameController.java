package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.MESSAGE_NUMBER_OF_TICKET_IS;

public class GameController {
    List<List<Integer>> myLottos = new ArrayList<>();
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;
    List<Integer> myCorrectNumberResult = new ArrayList<>();

    public void buyLotto() {
        LottoSeller lottoPurchase = new LottoSeller();
        lottoPurchase.getPayAmount();
        lottoPurchase.countTicket();

        NumberGenerator newNumbers = new NumberGenerator(lottoPurchase.numberOfTickets);
        newNumbers.generateNumbers();
        myLottos = newNumbers.myLotto;
    }

    public void drawLotto() {
        LottoDrawing numberDrawing = new LottoDrawing();
        numberDrawing.getWinningNumber();
        numberDrawing.getBonusNumber();

        Lotto winningNumbers = new Lotto(numberDrawing.winningNumbers);
        this.winningNumbers = winningNumbers.getNumbers();
        bonusNumber = numberDrawing.bonusNumber;
    }
    public void printLotto(){
        System.out.println(myLottos.size() + MESSAGE_NUMBER_OF_TICKET_IS);
        for (List<Integer> lottoNumber : myLottos){
            System.out.println(lottoNumber.toString());
        }
    }

    public void getResult(){
        NumberChecker numberChecker = new NumberChecker(winningNumbers, bonusNumber, myLottos);
        numberChecker.compareNumber();
        numberChecker.getRanks();
    }
}
