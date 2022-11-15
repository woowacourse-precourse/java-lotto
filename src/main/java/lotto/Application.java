package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputText="";
        int inputInteger=0;
        List<Integer> inputWinningNumbers=new ArrayList<>();

        UserInteraction userInteraction = new UserInteraction();

        userInteraction.askInput("구입금액을");
        inputText=userInteraction.getInput();
        inputInteger = userInteraction.tryParseInt(inputText);

        User user = new User(inputInteger);
        user.printNumbersOfLottos();

        userInteraction.askInput("당첨 번호를");
        inputText=userInteraction.getInput();
        inputWinningNumbers=userInteraction.tryParseIntegers(inputText);
        userInteraction.checkNumbers(inputWinningNumbers);

        userInteraction.askInput("보너스 번호를");
        inputText=userInteraction.getInput();
        inputInteger = userInteraction.tryParseInt(inputText);
        userInteraction.checkBonusNumber(inputWinningNumbers, inputInteger);

        user.calculateEarningRate(inputWinningNumbers, inputInteger);
        user.printPrizeResult();
    }
}
