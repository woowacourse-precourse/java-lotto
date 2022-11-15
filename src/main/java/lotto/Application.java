package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    Input input;
    List<Lotto> userBuyLottoGroup;
    CreateUserLottoNumbers createUserLottoNumbers;
    Output output;
    MatchCondition matchCondition;

    int amount;
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
        input = new Input();
        userBuyLottoGroup = new ArrayList<>();
        createUserLottoNumbers = new CreateUserLottoNumbers();
        output  = new Output();
        matchCondition = new MatchCondition();
        amount = 0;
    }

    public void buyLotto(){
        amount = input.inputMoney();
        userBuyLottoGroup = createUserLottoNumbers.createUserLottoNumber(amount);
        output.userBuyLottoNumbers(userBuyLottoGroup);
    }

    public void printPrizeResult(){
        List<Integer> winningNumber = input.inputWinningLottosNumber();
        int bonsNumber = input.inputBonusNumber(winningNumber);
        List<Integer> placeResult = matchCondition.getMatchResult(userBuyLottoGroup,winningNumber,bonsNumber);
        output.lottoMatchResult(placeResult);
        double profit = matchCondition.calculRateOfReturn(amount,placeResult);
        output.printRateOfReturn(profit);

    }




}
