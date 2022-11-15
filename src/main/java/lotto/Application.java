package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String INPUT_AMOUNT_MONEY = "구입 금액을 입력해주세요.";
        String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
        String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

        System.out.println(INPUT_AMOUNT_MONEY);
        String anmountMoney = Console.readline();
        System.out.println(INPUT_LOTTO_NUMBER);
        String lottoNumber = Console.readline();
        System.out.println(INPUT_BONUS_NUMBER);
        String lottoNumber = Console.readline();
    }
}
