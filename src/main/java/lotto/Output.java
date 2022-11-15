package lotto;

import java.util.List;

public class Output {

    public static void purchase_Output(){
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static void purchase_Amount_Output(int input){
        System.out.println("\n"+input+"개를 구매했습니다.");
    }

    public static void issue_Numbers_Output( List<List<Integer>> issue_Numbers){
        for(int i=0; i<issue_Numbers.size(); i++){
            System.out.println(issue_Numbers.get(i));
        }
    }

    public static void Lotto_Output(){
        System.out.println("\n당첨 번호를 입력해주세요.");
    }

    public static void bonus_Output(){
        System.out.println("\n보너스 번호를 입력해주세요.");
    }

    public static void result_Output(){
        System.out.printf("\n당첨통계\n---\n");
    }


}
