package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int enterTheAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if(amount%LOTTO_PRICE!=0) throw new IllegalArgumentException();

        return amount/LOTTO_PRICE;
    }
}
