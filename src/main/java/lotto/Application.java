package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class Application {
    UI UI = new UI();


    public List<List<Integer>> Lotto_number(Integer money) {
        Integer number_of_lotto_paper = money / 1000;
        List<List<Integer>> Total_Lotto_numbers = new ArrayList<>();

        for (Integer i = 0; i < number_of_lotto_paper; i++) {
            List<Integer> Lotto_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Lotto_numbers.sort(Comparator.naturalOrder());
            Total_Lotto_numbers.add(Lotto_numbers);
        }
        UI.Lotto_Number_Print(number_of_lotto_paper, Total_Lotto_numbers);
        return Total_Lotto_numbers;
    }

    public HashMap<Integer, Integer> Lotto_Choice(List<List<Integer>> Total_Lotto_numbers, List<Integer> Answer_Number, Integer Bonus_Number) {
        HashMap<Integer, Integer> Lotto_Choice_Result = new HashMap<>();
        Lotto_Choice_Result.put(3, 0);
        Lotto_Choice_Result.put(4, 0);
        Lotto_Choice_Result.put(5, 0);
        Lotto_Choice_Result.put(6, 0);
        Lotto_Choice_Result.put(7, 0);
        for (List Lotto_numbers : Total_Lotto_numbers) {
            Integer Common_Number = Lotto_machine(Answer_Number, Bonus_Number, Lotto_numbers);
            if (Common_Number >= 3) {
                Lotto_Choice_Result.put(Common_Number, Lotto_Choice_Result.get(Common_Number) + 1);
            }
        }
        UI.Lotto_Choice_Result_Print(Lotto_Choice_Result);
        return Lotto_Choice_Result;
    }

    public Integer Lotto_machine(List<Integer> Answer_Number, Integer Bonus_Number, List<Integer> Lotto_numbers) {
        ArrayList<Integer> Temporary_Lotto_numbers = new ArrayList<>(Lotto_numbers);
        Temporary_Lotto_numbers.retainAll(Answer_Number);
        Integer Common_Number = Temporary_Lotto_numbers.size();
        if (Common_Number == 5 & Answer_Number.contains(Bonus_Number) == true) {
            Common_Number = 7;
        }
        return Common_Number;
    }

    public String Rate_Of_Return(Integer money, HashMap<Integer, Integer> Lotto_Choice_Result) {
        Integer[] data = {5000, 50000, 1500000, 2000000000, 30000000};
        List<Integer> revenue = new ArrayList<>(Arrays.asList(data));
        Integer Total_revenue = 0;
        for (Integer index = 3; index <= 7; index++) {
            Total_revenue += revenue.get(index - 3) * Lotto_Choice_Result.get(index);
        }
        String Rate_Of_Return = String.format("%.1f", Total_revenue / (double) money * 100);
        UI.Rate_Of_Return_Print(Rate_Of_Return);
        return Rate_Of_Return;
    }


    public static void main(String[] args) {
        Application Application = new Application();
        UI UI = new UI();
        try {

            Integer money = UI.Money_Input();

            List<List<Integer>> Total_Lotto_numbers = Application.Lotto_number(money);
            List<Integer> Answer_Number = UI.Lotto_Number_Input();
            Integer Bonus_Number = UI.Bonus_Number_Input();
            HashMap<Integer, Integer> Lotto_Choice_Result = Application.Lotto_Choice(Total_Lotto_numbers, Answer_Number, Bonus_Number);
            Application.Rate_Of_Return(money, Lotto_Choice_Result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

