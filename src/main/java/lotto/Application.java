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
        System.out.println(input+"개를 구매했습니다.");
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
        System.out.println("당첨 번호를 입력해주세요.");
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
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public static void Duplicate_exception_bonus(int bonus, List<Integer> winner_number){
        if(winner_number.contains(bonus)) throw new IllegalArgumentException("[Error] 당첨 번호와 중복되지 않는 값을 입력해주세요.");
    }

    public static void result_Output(){
        System.out.printf("당첨통계\n---\n");
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

    public static List<Integer> count_prize(List<List<Integer>> result){
        int i=0;
        int [] prize = new int [5];
        List<Integer> compare_result = new ArrayList<>();
        while(i<result.size()){
            if(result.get(i).contains(6)) prize[0]++;
            if(result.get(i).contains(5)){
                if(result.get(i).contains(1)) prize[1]++;
                prize[0]++;
            }
            if(result.get(i).contains(4)) prize[3]++;
            if(result.get(i).contains(3)) prize[4]++;
            i++;
        }
        for(int j=0; j<5; j++){
            compare_result.add(prize[i]);
        }
        return compare_result;
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

    public enum statistics{
        Fifth_Prize(5000, 3, 0, ,"3개 일치 (5,000원) - "),
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
        List<List<Integer>> issue_Numbers;
        String[] Lotto_Num;
        List<Integer> winner_number;
        String bonus_number;

        purchase_Output();
        String purchase_Input = Input();
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
        System.out.println(winner_number);
        bonus_Output();
        bonus_number =  Input();
        Range_exception(bonus_number);
        Number_exception(bonus_number);
        Duplicate_exception_bonus(StringtoInteger(bonus_number), winner_number);
        result_Output();
        System.out.println(result_of_each(issue_Numbers, winner_number, StringtoInteger(bonus_number)));
//        Lotto lotto_number = new Lotto(StringtoInt(Lotto_Num));
//        System.out.println(lotto_number);


//        Lotto winning_number = new Lotto(number);

    }
}
