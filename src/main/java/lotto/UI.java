package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {

    public Integer money(){
        String Input = Console.readLine();
        money_validate(Input);
        Integer money = Integer.valueOf(Input);
        return money;
    }

    private void money_validate(String Input) {
        try {
            Integer money = Integer.valueOf(Input);
            Integer remainder = money % 1000;
            if (remainder != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위의 숫자여야 합니다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위의 숫자여야 합니다.");
        }
    }
//    public static void main(String[] args) {
//        UI UI = new UI();
//        UI.money();
//    }

}
