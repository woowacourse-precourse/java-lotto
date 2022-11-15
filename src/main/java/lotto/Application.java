package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {

    int amount;
    InputView inputView;
    List<Lotto> userBuyLottoGroup;
    CreateUserLottoNumbers createUserLottoNumbers;
    OutputView outputView;
    MatchingCondition matchingCondition;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();

        try{
            application.buyLotto();
            application.printPrizeResult();
        }catch (IllegalArgumentException r){
            System.out.println(r.getMessage());
        }
    }

    public Application(){
        inputView = new InputView();
        userBuyLottoGroup = new ArrayList<>();
        createUserLottoNumbers = new CreateUserLottoNumbers();
        outputView = new OutputView();
        matchingCondition = new MatchingCondition();
        amount = 0;
    }

    public void buyLotto(){
        amount = inputView.inputMoney();
        
        userBuyLottoGroup = createUserLottoNumbers.createUserLottoNumber(amount);

        outputView.printUserBuyLottoNumbers(userBuyLottoGroup);
    }

    public void printPrizeResult(){
        List<Integer> winningNumber = inputView.inputWinningLottosNumber();
        int bonsNumber = inputView.inputBonusNumber(winningNumber);

        List<Integer> placeResult = matchingCondition.getMatchResult(userBuyLottoGroup,winningNumber,bonsNumber);
        outputView.printUserLottoMatchResult(placeResult);

        double profit = matchingCondition.calculateRateOfReturn(amount,placeResult);
        outputView.printRateOfReturn(profit);

    }

}
