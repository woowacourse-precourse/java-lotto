package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoInput {
    public static final int LOTTO_COST = 1000;
    public int inputPurchaseAmount(){
        InputView.showPurchaseAmountMessage();
        int purchaseAmount = 0;
        try{
            purchaseAmount = Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e){
            System.out.println(InputView.PURCHASE_FORMAT_ERROR);
        }
        return purchaseAmount;
    }

    public List<Integer> inputWinNumber(){
        InputView.showAnswerNumberMessage();
        String answer = Console.readLine();

        List<Integer> winNumbers = tokenizeNumber(answer);
        InputView.newLine();
        return winNumbers;
    }

    public static int inputBonusNumber() {
        InputView.showBonusNumberMessage();
        int bonusNumber = Integer.parseInt(Console.readLine());
        InputValidator.validateLottoNumberRange(bonusNumber);
        InputView.newLine();
        return bonusNumber;
    }

    public static List<Integer> tokenizeNumber(String answer){
        StringTokenizer st = new StringTokenizer(answer, ",");
        List<Integer> answerList = new ArrayList<>();

        while(st.hasMoreTokens()){
            answerList.add(Integer.parseInt(st.nextToken()));
        }
        return answerList;
    }

}
