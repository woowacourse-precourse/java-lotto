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

    public static void Number_exception(String purchase_Amount){
        for(int i=0; i<purchase_Amount.length(); i++){
            if((int)(purchase_Amount.charAt(i))>57 || (int)(purchase_Amount.charAt(i))<48){
                throw new IllegalArgumentException("[Error] 자연수 값을 입력해주세요.");
            }
        }
    }

    public static void Unit_exception(String purchase_Amount){
        if((Integer.parseInt(purchase_Amount)%1000)!=0){
            throw new IllegalArgumentException("[Error] 1000원 단위로 입력해주세요.");
        }
    }

//    public static int purchase_Amount(){
//
//    }

    public static void main(String[] args) {
        issue_Number();
        purchase_Output();
        String purchase_Amount = Input();
        Number_exception(purchase_Amount);
        Unit_exception(purchase_Amount);




//        int num = Integer.parseInt(Console.readLine());
//        System.out.println(number);
//        Lotto winning_number = new Lotto(number);

    }
}
