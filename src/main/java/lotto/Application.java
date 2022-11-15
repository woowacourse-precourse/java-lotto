package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class Application {
    public static void main(String[] args) {
        String inputmoney = InputMoney();
        CheckUnit(inputmoney);
    }

    public static String InputMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        String inputmoney = Console.readLine();
        return inputmoney;
    }
    public static void CheckUnit(String inputmoney){
        try{
            Integer money = Integer.valueOf(inputmoney);
            if(money % 1000 !=0){
                throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위입니다.");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요");
        }
    }

    public static int CountLotto(int Money){

    }

    public static List<Integer> LottoNumber(){

    }

    public static List<Integer> InputNumber(){

    }

    public static List<Integer> CompareNumber(){

    }

    public static int CompareBonus(){

    }

    public static List<Integer> CountWin(){

    }

    public static void PrintWin(){

    }

    public static int CalculateMoney(){

    }
}

