package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.constants.ErrorMessage;
import lotto.model.Money;

public class Application {

    public static void main(String[] args) {
        try {
            new Money(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
