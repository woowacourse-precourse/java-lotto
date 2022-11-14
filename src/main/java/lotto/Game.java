package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<List<Integer>> myLottoNumbers = new ArrayList<>();
    List<Integer> winningLottoNumbers = new ArrayList<>();
    int bonusNumber;
    List<Integer> myCorrectNumberResult = new ArrayList<>();

    public void buyLotto() {
        LottoSeller lottoPurchase = new LottoSeller();
        lottoPurchase.getPayAmount();
        lottoPurchase.countTicket();

        NumberGenerator newNumbers = new NumberGenerator(lottoPurchase.numberOfTickets);
        newNumbers.generateNumbers();
        myLottoNumbers = newNumbers.myLotto;
    }

    public void drawLotto() {
        LottoDrawing numberDrawing = new LottoDrawing();
        numberDrawing.getWinningNumber();
        numberDrawing.getBonusNumber();

        Lotto winningNumbers = new Lotto(numberDrawing.winningNumbers);
        winningLottoNumbers = winningNumbers.getNumbers();
        bonusNumber = numberDrawing.bonusNumber;
    }

    public void getResult(){
        NumberChecker numberChecker = new NumberChecker(winningLottoNumbers, bonusNumber, myLottoNumbers);
        numberChecker.compareNumber();

//        myCorrectNumberResult = numberChecker.numberOfCorrectNumbers;


     //   PrizeResult.secondWinner_5_bonus.getRank();

    }
}
