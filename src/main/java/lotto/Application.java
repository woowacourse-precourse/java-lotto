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

//    public static int purchase_Input(){
//
//    }

    public static void main(String[] args) {
        issue_Number();
        purchase_Output();
        String purchase_Input = Input();
        Number_exception(purchase_Input);
        Unit_exception(purchase_Input);
        purchase_Amount_Output(purchase_Amount(StringtoInteger(purchase_Input)));



//        int num = Integer.parseInt(Console.readLine());
//        System.out.println(number);
//        Lotto winning_number = new Lotto(number);

    }
}
