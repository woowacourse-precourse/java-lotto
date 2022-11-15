package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class UI {

    public Integer Money_Input(){
        System.out.println("구입금액을 입력해 주세요.");
        String Money_Input = Console.readLine();
        Money M = new Money(Money_Input);
        Integer money = Integer.valueOf(Money_Input);
        return money;
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

    public void Lotto_Number_Print(Integer number_of_lotto_paper, List<List<Integer>> Total_Lotto_numbers){
        System.out.printf("%d개를 구매했습니다.%n",number_of_lotto_paper);
        for (Integer index = 0; index < number_of_lotto_paper; index++){
            System.out.println(Total_Lotto_numbers.get(index));
        }

    }

    public void Lotto_Choice_Result_Print(HashMap<Integer, Integer> Lotto_Choice_Result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n",Lotto_Choice_Result.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개%n",Lotto_Choice_Result.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n",Lotto_Choice_Result.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n",Lotto_Choice_Result.get(7));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n",Lotto_Choice_Result.get(6));
    }

    public void Rate_Of_Return_Print(String Rate_Of_Return){
        System.out.printf("총 수익률은 %s%%입니다.%n",Rate_Of_Return);
    }
}
