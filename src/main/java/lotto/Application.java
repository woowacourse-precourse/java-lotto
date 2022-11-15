package lotto;

import lotto.input_processing.InputPrice;
import lotto.input_processing.InputWinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static InputPrice inputPrice = new InputPrice();
    static InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
    static CheckWinningHistory checkWinningHistory = new CheckWinningHistory();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Lotto> lottoList = getLottoList();
        List<Integer> winningNumbers = inputWinningNumbers.getWinningNumbers();
        int bonusNumber = inputWinningNumbers.getBonusNumbers(winningNumbers);
        checkWinningHistory.checkNumberMatching(lottoList, winningNumbers, bonusNumber);
    }
    private static ArrayList<Lotto> getLottoList() {
        try {return inputPrice.createLottoNumbers();}
        catch (Exception e) {System.out.println(e.getMessage());}
        return null;
    }
}
