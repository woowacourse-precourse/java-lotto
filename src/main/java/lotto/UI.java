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

    public List<Integer> Lotto_Number_Input() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String Lotto_Number_Input = Console.readLine();

        List<Integer> Lotto_numbers = new ArrayList();
        String[] Input_Array = Lotto_Number_Input.split(",");
        for (int index = 0; index < Input_Array.length; index++) {
            Number_validate(Input_Array[index]);
            Integer number = Integer.valueOf(Input_Array[index]);
            Lotto_numbers.add(number);
        }
        Lotto L = new Lotto(Lotto_numbers);
        return Lotto_numbers;
    }

    private void Number_validate(String Lotto_Number_Input) {
        try {
            Integer number = Integer.valueOf(Lotto_Number_Input);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();}
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    public Integer Bonus_Number_Input() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String Bonus_Input = Console.readLine();
        Bonus_number B = new Bonus_number(Bonus_Input);
        Integer Bonus_Number = Integer.valueOf(Bonus_Input);
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
