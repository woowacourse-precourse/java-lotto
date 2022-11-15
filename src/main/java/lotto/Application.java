package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import lotto.constant.Constant;

public class Application {
    private static Constant constant = new Constant();
    public static List<Lotto> Tickets = new ArrayList<>();
    public static int Lotto_Size = 6;

    private static String Answer_Numbers = "당첨 번호를 입력해 주세요.";
    private static String Regex = ",";
    private static String Insert_Money = "구매 금액을 입력하세요";
    private static String Buy_Message = "개를 구매했습니다.";
    private static String Winning_Stats = "당첨 통계\n---";
    private static String Yield_Total = "총 수익률은 %s%%입니다.\n";
    private static String Win_FirstPrize = "6개 일치 (2,000,000,000원) - ";
    private static String Win_SecondPrize = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static String Win_ThirdPrize = "5개 일치 (1,500,000원) - ";
    private static String Win_FourthPrize = "4개 일치 (50,000원) - ";
    private static String Win_FifthPrize = "3개 일치 (5,000원) - ";
    private static String Count_Correct = "개";

    public static void main(String[] args) {
        int count = Buy_Lotto();
        for (int i = 0; i < count; i++) {
            Tickets.add(new Lotto(
                Randoms.pickUniqueNumbersInRange(1,45,6))
            );
            Tickets.get(i).print_Numbers();
        }
        Winning(get_Rank(MakeAnswer(), Tickets, MakeBonus()));
        printResult(count);
    }
    
    public enum Rank{
        first(0),
        second(0),
        third(0),
        fourth(0),
        fifth(0);

        private int count;

        Rank(int count){
            this.count = count;
        }
    }

    public static Lotto MakeAnswer() {
        List<String> winning = new ArrayList<>();
        List<Integer> WinningNumberSet = new ArrayList<>();

        System.out.println(Answer_Numbers);
        String Winning_Numbers;

        if((Winning_Numbers = Console.readLine()) != null){
            String[] split_number = Winning_Numbers.split(Regex);
            for(String s: split_number)
                winning.add(s);
        }

        if(winning.stream().distinct().count() != winning.size())
            throw new IllegalArgumentException(constant.Print_Duplicate_Numbers());
        System.out.println(winning);

        for(String number : winning)
            WinningNumberSet.add(Integer.parseInt(number));
        return new Lotto(WinningNumberSet);
    }

    public static int MakeBonus() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> get_Rank(Lotto answer, List<Lotto> MyLotto, Integer bonus) {
        List<Integer> winning = new ArrayList<>();
        for(int i = 0; i < MyLotto.size(); i++){
            int rank = MyLotto.get(i).get_CorrectNumbers(answer,bonus);
            winning.add(rank);
        }
        return winning;
    }

    public static Integer Buy_Lotto()   {
        System.out.println(Insert_Money);
        String cost = Console.readLine();
        int Total_Cost = 0;

        if(cost == null)
            throw new IllegalArgumentException(constant.Print_No_Insert());

        try {
            Total_Cost = Integer.parseInt(cost);
        }
        catch (NumberFormatException e){
            System.out.println(constant.Print_Only_Numbers());
        }

        if(Total_Cost % 1000 != 0)
            throw new IllegalArgumentException(constant.Print_Buy_Per_1000());

        System.out.println(Total_Cost / 1000 + Buy_Message);

        return Total_Cost / 1000;
    }

    public static String yield(int Totalcost){
        int Total = 2_000_000_000 * Rank.first.count + 
                    30_000_000 * Rank.second.count + 
                    1_500_000 * Rank.third.count + 
                    50_000 * Rank.fourth.count + 
                    5_000 * Rank.fifth.count;
        int Yield = Total * 10 / Totalcost;

        if(Yield % 10 >= 5)
            return (Yield / 10 + 1) / 10 + "." + (Yield / 10) % 10;
        else
            return Yield / 100 + "." + (Yield / 10) % 10;
    }

    public static void Winning(List<Integer> winning){
        for(int correct_Num : winning){
            if(correct_Num == 6) Rank.first.count++;
            else if(correct_Num == 7) Rank.second.count++;
            else if (correct_Num == 5) Rank.third.count++;
            else if (correct_Num == 4) Rank.fourth.count++;
            else if (correct_Num == 3) Rank.fifth.count++;
        }
    }

    public static void printResult(int count)   {
        System.out.println(Winning_Stats);
        System.out.println(Win_FifthPrize + Rank.fifth.count + Count_Correct);
        System.out.println(Win_FourthPrize + Rank.fourth.count + Count_Correct);
        System.out.println(Win_ThirdPrize + Rank.third.count + Count_Correct);
        System.out.println(Win_SecondPrize + Rank.second.count + Count_Correct);
        System.out.println(Win_FirstPrize + Rank.first.count + Count_Correct);
        System.out.printf(Yield_Total, yield(count));
    }
}
