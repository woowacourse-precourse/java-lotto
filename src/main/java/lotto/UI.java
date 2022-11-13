package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class UI {

    public Integer money(){
        String Input = Console.readLine();
        Money_Validate(Input);
        Integer money = Integer.valueOf(Input);
        return money;
    }

    private void Money_Validate(String Input) {
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

    public List<Integer> Answer_Number() {
        List<Integer> Answer_numbers = new ArrayList();

        String Input = Console.readLine();
        String[] Input_Array = Input.split(",");
        for (int index = 0; index < Input_Array.length; index++) {
            number_validate(Input_Array[index]);
            Integer number = Integer.valueOf(Input_Array[index]);
            Answer_numbers.add(number);
        }
        Lotto L = new Lotto(Answer_numbers);
        return Answer_numbers;
    }




//    public static void main(String[] args) {
//        UI UI = new UI();
//        UI.Answer_Number();
//    }
//
//}
