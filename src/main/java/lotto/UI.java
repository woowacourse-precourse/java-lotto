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


//    public static void main(String[] args) {
//        UI UI = new UI();
//        UI.money();
//    }

}
