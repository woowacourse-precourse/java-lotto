package lotto.domain;

import javax.xml.validation.Validator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int money;
    private int totalPrize;
    private int numOfLotteries;
    private double rateOfReturn;
    private List<Lotto> lotteries;

    public void inputUserMoney() {
        String userInput = readLine();
        InputValidator validator = new InputValidator();

        validator.validateInputMoney(userInput);
        this.money = Integer.parseInt(userInput);
    }

}
