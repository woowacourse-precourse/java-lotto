package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    UI UI = new UI();
    HashMap<Integer, Integer> Lotto_Choice_Result = new HashMap<>();




    public List<List<Integer>> Lotto_number(Integer money){
        Integer number_of_lotto_paper  = money / 1000;
        List<List<Integer>> Total_Lotto_numbers = new ArrayList<>();

        for (Integer i = 0; i < number_of_lotto_paper; i++){
            List<Integer> Lotto_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(Lotto_numbers);
            Total_Lotto_numbers.add(Lotto_numbers);
        }
        UI.Lotto_Number_Print(number_of_lotto_paper,Total_Lotto_numbers);
        return Total_Lotto_numbers;
    }



    public static void main(String[] args) {

       // TODO: 프로그램 구현
    }
}
