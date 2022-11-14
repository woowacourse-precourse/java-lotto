package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

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
            if(strings[i] != " ") {
                Number_exception(strings[i]);
            }
            Range_exception(strings[i]);
        }
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

    public static void main(String[] args) {
        List<List<Integer>> issue_Numbers;

        purchase_Output();
        String purchase_Input = Input();
        Number_exception(purchase_Input);
        Unit_exception(purchase_Input);
        purchase_Amount_Output(purchase_Amount(StringtoInteger(purchase_Input)));
        issue_Numbers = issue_Numbers((purchase_Amount(StringtoInteger(purchase_Input))));
        issue_Numbers_Output(issue_Numbers);
        Lotto_Output();
        String Lotto_Input = Input();
        Lotto_Number_exception(split(Lotto_Input));
        System.out.println(StringtoInt(split(Lotto_Input)));
//        Lotto lotto_number = new Lotto(StringtoInt(split(Lotto_Input)));
//        System.out.println(lotto_number);


//        int num = Integer.parseInt(Console.readLine());
//        System.out.println(number);
//        Lotto winning_number = new Lotto(number);

    }
}
