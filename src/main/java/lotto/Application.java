package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> issue_Number(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void purchase_Output(){
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static String Input(){
        return Console.readLine();
    }

    public static void Number_exception(String purchase_Input){
        for(int i=0; i<purchase_Input.length(); i++){
            if((int)(purchase_Input.charAt(i))>57 || (int)(purchase_Input.charAt(i))<48){
                throw new IllegalArgumentException("[Error] 자연수 값을 입력해주세요.");
            }
        }
    }

    public static void Unit_exception(String purchase_Input){
        if((Integer.parseInt(purchase_Input)%1000)!=0){
            throw new IllegalArgumentException("[Error] 1000원 단위로 입력해주세요.");
        }
    }

    public static int StringtoInteger(String str){
        return Integer.parseInt(str);
    }

    public static int purchase_Amount(int input){
        return (input / 1000);
    }

    public static void purchase_Amount_Output(int input){
        System.out.println("\n"+input+"개를 구매했습니다.");
    }

    public static List<List<Integer>> issue_Numbers(int purchase_Amount){
        int initNum = 0;
        List<List<Integer>> numbers = new ArrayList<>();

        while(initNum<purchase_Amount) {
            numbers.add(issue_Number());
            initNum++;
        }
        return numbers;
    }

    public static void issue_Numbers_Output( List<List<Integer>> issue_Numbers){
        for(int i=0; i<issue_Numbers.size(); i++){
            System.out.println(issue_Numbers.get(i));
        }
    }

    public static void Lotto_Output(){
        System.out.println("\n당첨 번호를 입력해주세요.");
    }

    public static String [] split(String str){
        int i=0;
        int count = str.split(",").length;
        String [] array = new String[count];

        while(i<count){
            array[i] = str.split(",")[i];
            i++;
        }

        return array;
    }

    public static void Lotto_Number_exception(String [] strings){
        for(int i=0; i<strings.length; i++){
            Number_exception(strings[i]);
            Range_exception(strings[i]);
        }
    }

    public static String [] replace_blank(String [] str){
        String [] string = str;
        for(int i=0; i<str.length; i++) {
            if (str[i].contains(" ")) {
                string[i] = str[i].replace(" ", "");
            }
        }
        return string;
    }

    public static void Range_exception(String str){
        if(Integer.parseInt(str)<1 || Integer.parseInt(str)>45){
            throw new IllegalArgumentException("[Error] 1~45사이의 정수를 입력해주세요.");
        }
    }

    public static void Duplicate_exception(List<Integer> list){
        int key = list.size()-1;
        int temp = list.get(key);

        list.remove(key);
        if(list.contains(temp)){
            throw new IllegalArgumentException("[Error] 중복되지 않는 값을 입력해주세요.");
        }
        list.add(temp);
    }

    public static List<Integer> StringtoInt(String [] str){
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<str.length; i++){
            list.add(StringtoInteger(str[i]));
            Duplicate_exception(list);
        }

        return list;
    }

    public static void bonus_Output(){
        System.out.println("\n보너스 번호를 입력해주세요.");
    }

    public static void Duplicate_exception_bonus(int bonus, List<Integer> winner_number){
        if(winner_number.contains(bonus)) throw new IllegalArgumentException("[Error] 당첨 번호와 중복되지 않는 값을 입력해주세요.");
    }

    public static void result_Output(){
        System.out.printf("\n당첨통계\n---\n");
    }

    public static List<List<Integer>> result_of_each(List<List<Integer>> issue_numbers, List<Integer> winner_number, int bonus_number){
        List<Integer> issue_number;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<issue_numbers.size(); i++){
            issue_number = issue_numbers.get(i);
            temp.add(compare(issue_number,winner_number));
            temp.add(compare_bonus(issue_number, bonus_number));
            result.add(temp);
            temp = new ArrayList<>();
        }
        return result;
    }

    public static List<Integer> count_prize(List<List<Integer>> results){
        int i=0;
        List<Integer> prize = new ArrayList<>();
        Initialize_prize(prize, 0, 5);
        while(i<results.size()){
            prize_parameter(results.get(i), prize, statistics.First_Prize.number, 0);
            bonus_parameter(results.get(i), prize, statistics.Second_Prize.number, 2);
            prize_parameter(results.get(i), prize, statistics.Fourth_Prize.number, 3);
            prize_parameter(results.get(i), prize, statistics.Fifth_Prize.number, 4);
            i++;
        }
        return prize;
    }

    public static List<Integer> Initialize_prize(List<Integer> prize, int num, int times){
        for(int i=0; i<times; i++){
            prize.add(num);
        }
        return prize;
    }

    public static List<Integer> prize_parameter(List<Integer> result, List<Integer> prize, int number, int rank){
        int temp = prize.get(rank);

        if(result.contains(number)) prize.set(rank,++temp);
        return prize;
    }

    public static List<Integer> bonus_parameter(List<Integer> result, List<Integer> prize, int number, int rank){
        int temp_1 = prize.get(rank-1);
        int temp_2 = prize.get(rank);

        if(result.contains(number)) {
            if(result.contains(statistics.Second_Prize.bonus)) {
                prize.set(rank-1, ++temp_1);
                return prize;
            }
            prize.set(rank, ++temp_2);
            return prize;
        }
        return prize;
    }

//    public static int Number_of_iterations(List<List<Integer>> issue_numbers){
//
//    }
//  (List<List<Integer>> issue_numbers, List<Integer> winner_number, int bonus_number)

    public static int compare(List<Integer> issue_number, List<Integer> winner_number){
        int count = 0;
        for(int i=0; i<winner_number.size(); i++){
            if(issue_number.contains(winner_number.get(i))) count++;
        }
        return count;
    }

    public static int compare_bonus(List<Integer> issue_number, int bonus_number){
        if(issue_number.contains(bonus_number)) return 1;
        return 0;
    }

    public static void statistic_Output(List<Integer> prizeCount){
        int init=4;

        for (statistics prize : statistics.values()){
            System.out.print(prize.message);
            System.out.println(prizeCount.get(init--)+"개");
        }
    }

    public static String total_Rate_Of_Return(List<Integer> count_prize, int purchaseAmount){
        int initnum = 4;
        double Sum = 0;
        for(statistics total_return : statistics.values()){
            Sum += total_return.prize * count_prize.get(initnum--);
        }
        return String.format("%.1f",(Sum/purchaseAmount)*100);
    }

    public static void total_Return_Output(String total_return){
        System.out.println("총 수익률은 "+ total_return + "%입니다.");
    }

    public enum statistics{
        Fifth_Prize(5000, 3, 0, "3개 일치 (5,000원) - "),
        Fourth_Prize(50000, 4, 0, "4개 일치 (50,000원) - "),
        Third_Prize(1500000, 5, 0, "5개 일치 (1,500,000원) - "),
        Second_Prize(30000000, 5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        First_Prize(2000000000, 6, 0, "6개 일치 (2,000,000,000원) - ");

        private final int prize;
        private final int number;
        private final int bonus;
        private final String message;

        statistics(int prize, int number, int bonus, String message){
            this.prize = prize;
            this.number = number;
            this.bonus = bonus;
            this.message = message;
        }

        public int getPrize() {
            return prize;
        }

        public int getNumber() {
            return number;
        }

        public int getBonus() {
            return bonus;
        }

        public String getMessage() {
            return message;
        }
    }


    public static void main(String[] args) {
        String purchase_Input;
        int purchaseAmount;
        List<List<Integer>> issue_Numbers;
        String[] Lotto_Num;
        List<Integer> winner_number;
        String bonus_number;
        List<Integer> prizeCount;

        purchase_Output();
        purchase_Input = Input();
        Number_exception(purchase_Input);
        Unit_exception(purchase_Input);
        purchase_Amount_Output(purchase_Amount(StringtoInteger(purchase_Input)));
        issue_Numbers = issue_Numbers((purchase_Amount(StringtoInteger(purchase_Input))));
        issue_Numbers_Output(issue_Numbers);
        Lotto_Output();
        String Lotto_Input = Input();
        Lotto_Num = replace_blank(split(Lotto_Input));
        Lotto_Number_exception(Lotto_Num);
        winner_number = StringtoInt(Lotto_Num);
//        System.out.println(winner_number);
        bonus_Output();
        bonus_number =  Input();
        Range_exception(bonus_number);
        Number_exception(bonus_number);
        Duplicate_exception_bonus(StringtoInteger(bonus_number), winner_number);
        result_Output();
//        System.out.println(count_prize(result_of_each(issue_Numbers, winner_number, StringtoInteger(bonus_number))));
        prizeCount = count_prize(result_of_each(issue_Numbers, winner_number, StringtoInteger(bonus_number)));
        purchaseAmount = StringtoInteger(purchase_Input);
        statistic_Output(prizeCount);
        total_Return_Output(total_Rate_Of_Return(prizeCount, purchaseAmount));

//
//        Lotto lotto_number = new Lotto(StringtoInt(Lotto_Num));
//        System.out.println(lotto_number);


//        Lotto winning_number = new Lotto(number);

    }
}
