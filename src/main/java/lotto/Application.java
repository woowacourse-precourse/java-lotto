package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.List;

import static lotto.UI.*;
import static lotto.Winning.*;



public class Application{
    public static void main(String[] args) {
        List<List<Integer>> number = new ArrayList<>();

        System.out.println(Request_Input_Price);
        Error.notNum(String.valueOf(price));
        Error.Exception_Error(Integer.parseInt(Lot_EA));
        UI.Lot_Count(Integer.parseInt(Lot_EA));

        System.out.println(Lot_EA);

        for(int i=0; i<EA; i++) {
           List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
           number.add(numbers);
           numbers.sort(Comparator.naturalOrder());
           System.out.println(numbers);
        }

        System.out.println(Request_Winning_Number);
        Winning_number(win_number);
        System.out.println(Request_Bonus_Number);
        Bonus_Number();
        System.out.println(Lot_Result);
        for(int j=0; j<number.size(); j++){
            Result(win_numbers,number.get(j));
        }
        print_Bonus();
        getRate(correctNumbers,Integer.parseInt(price));
    }
}


