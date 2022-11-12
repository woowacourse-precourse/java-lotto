package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();


        System.out.println("금액 입력");
        int lottoMoney = inputView.inputLottoPurchaseMoney();
        int lottoChance = inputView.getLottoChance(lottoMoney);

        List<Integer> winningNumbers = inputView.createWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();
        System.out.println("당첨 번호 : " + winningNumbers);

        inputView.allLottoNumber = inputView.createAllGameLottoNumber(lottoChance);
        outputView.printLottoPurchaseCompleteMessage(lottoChance);
        outputView.printLottoNumber(inputView.allLottoNumber);

        for (int i = 0; i < inputView.allLottoNumber.size(); i++) {
            inputView.compareWinningNumber(inputView.allLottoNumber.get(i),winningNumbers,bonusNumber);
        }
        System.out.println(inputView.lottoResult);
        outputView.printLottoRankResult(inputView.lottoResult);

    }





}
