package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getTheNumberOfLotto() {
        int money = Integer.parseInt(Console.readLine());

        int numberOfLotto = money / 1000;
        
        return numberOfLotto;
    }


}
