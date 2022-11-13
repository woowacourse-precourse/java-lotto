package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class UI {

    public Integer money(){
        System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println("당첨 번호를 입력해 주세요.");

        String Input = Console.readLine();
        String[] Input_Array = Input.split(",");
        for (int index = 0; index < Input_Array.length; index++) {
            Answer_number_validate(Input_Array[index]);
            Integer number = Integer.valueOf(Input_Array[index]);
            Answer_numbers.add(number);
        }
        Lotto L = new Lotto(Answer_numbers);
        return Answer_numbers;
    }

    private void Answer_number_validate(String Input) {
        try {
            Integer number = Integer.valueOf(Input);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();}
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    public Integer Bonus_Number() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String Input = Console.readLine();
        Bonus_number_validate(Input);
        Integer Bonus_Number = Integer.valueOf(Input);
        return Bonus_Number;
    }

    private void Bonus_number_validate(String Input) {
        try {
            Integer number = Integer.valueOf(Input);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();}
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }




//    public static void main(String[] args) {
//        UI UI = new UI();
//        System.out.println(UI.Bonus_Number());
//    }
//
//}
