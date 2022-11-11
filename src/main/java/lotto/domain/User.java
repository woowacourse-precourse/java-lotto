package lotto.domain;

import javax.xml.validation.Validator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private static final int LOTTERY_PRICE = 1_000;

    private int money;
    private int totalPrize;
    private int numberOfLotteries;
    private double rateOfReturn;
    private List<Lotto> lotteries;

    public void inputUserMoney() {
        String userInput = readLine();
        InputValidator validator = new InputValidator();

        validator.validateInputMoney(userInput);
        this.money = Integer.parseInt(userInput);
    }

    public void calculateNumOfLotteries() {
        this.numberOfLotteries = money / LOTTERY_PRICE;
    }

    public int getNumOfLotteries() {
        return numberOfLotteries;
    }

    public void setLotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
