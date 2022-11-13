package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void validate(int value){
        if (value % 1000 !=0) {
            System.out.println("[ERROR] 구입 금액은 1000원 단위입니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int buyingValue = Integer.parseInt(Console.readLine());
        validate(buyingValue);
   }
}
