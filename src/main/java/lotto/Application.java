package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int lottoPrice = 1000;

    public static Integer getMoney() {
        int money = readMoney();
        validMoney(money);
        return money;
    }

    public static Integer readMoney() {
        System.out.println("구입금액을 입력해주세요.");
        String userInput = Console.readLine();
        try {
            return Integer.valueOf(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR]: 입력값이 숫자가 아닙니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
