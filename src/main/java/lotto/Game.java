package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<List<Integer>> myLottoNumbers = new ArrayList<>();
    List<Integer> winningLottoNumbers = new ArrayList<>();
    int bonusNumber;

    List<Integer> compareResult = new ArrayList<>();


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

        Lotto winningNumbers = new Lotto(numberDrawing.winningNumber);
        winningLottoNumbers = winningNumbers.getLotto();
        bonusNumber = numberDrawing.bonusNumber;
    }

    public void func(){
        NumberChecker numberChecker = new NumberChecker(winningLottoNumbers, myLottoNumbers);
        numberChecker.compareNumber();
        //
        System.out.println(numberChecker.myNumber);
        System.out.println(numberChecker.numberOfCorrectNumbers);
        System.out.println(numberChecker.winningNumber);
        //
        compareResult = numberChecker.numberOfCorrectNumbers;
    }



}
