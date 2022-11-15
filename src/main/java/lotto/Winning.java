package lotto;

import static camp.nextstep.edu.missionutils.Console.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.Error.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.UI.price;


public class Winning {
    static String win_number = readLine();
    static List<Integer> win_numbers = new ArrayList<>();
    static String User_Bonus_Number="";
    static String Final_Result="";
    static int correctNumber=0;
    static List<Integer> correctNumbers = new ArrayList<>();
    static List<String> Final_Results = new ArrayList<>();
    static int count = 0;
    static List<String> Results = new ArrayList<>();
    static String Bonus_Number = pickUniqueNumbersInRange(1, 45, 1).toString();


    static List<Integer> Winning_number(String win_number){
        List<String> read_win_number = List.of(win_number.split(","));
        win_numbers = read_win_number.stream().map(Integer::parseInt).collect(Collectors.toList());
        number_Error(win_numbers);
        EA_ERROR(win_numbers);
        return win_numbers;
    }

    static void Bonus_Number(){
        String User_Bonus_number = readLine();
        User_Bonus_Number = String.valueOf(parseInt(User_Bonus_number));
    }

    static void Result(List<Integer> win_numbers, List<Integer> numbers){

        for(int i=0; i<win_numbers.size(); i++){
            if(numbers.contains(win_numbers.get(i))){
                correctNumber ++;
            }
        }
        correctNumbers.add(correctNumber);
        correctNumber=0;
    }
    static void print_Bonus(){
            if(!Bonus_Number.contains(User_Bonus_Number)){
                calcount.CALCOUNT[] calcounts = calcount.CALCOUNT.values();
                for(lotto.calcount.CALCOUNT calcount : calcounts){
                    System.out.printf("%s %d개 \n",calcount.getEA(),calcount.earnMoney(price));
                }
            }
            if(Bonus_Number.contains(User_Bonus_Number)){
                BonusCalcount.BONUS_CALCOUNT[] bonusCalcounts = BonusCalcount.BONUS_CALCOUNT.values();
                for(lotto.BonusCalcount.BONUS_CALCOUNT BonusCalcount : bonusCalcounts){
                    System.out.printf("%s %d개 \n", BonusCalcount.getBonusEA(),BonusCalcount.earnBonusMoney(price));
                }
            }
        }
     static void getRate(List<Integer> correctNumbers, int price){
        long profit=0;
         profit += (long) 5000 * Collections.frequency(correctNumbers, 3);
         profit += (long) 50000 * Collections.frequency(correctNumbers, 4);
         profit += (long) 2000000000 * Collections.frequency(correctNumbers, 6);
         if(!Bonus_Number.contains(User_Bonus_Number)){
            profit += (long) 1500000 * Collections.frequency(correctNumbers, 5);
         }
         if(Bonus_Number.contains(User_Bonus_Number)){
            profit += (long) 30000000 * Collections.frequency(correctNumbers, 5);
         }
         double result = profit / (double) price * 100;
         System.out.println(String.format("총 수익률은 %.1f",result) + "%입니다.");
     }
}
