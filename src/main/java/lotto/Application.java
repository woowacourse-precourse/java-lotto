package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void Error(String ErrorType){
        throw new IllegalArgumentException("[ERROR] " + ErrorType);
    }
    public static Integer EnterAmount(){
        System.out.println("구입금액을 입력해 주세요.");

        Integer Amount;
        Amount = Integer.parseInt(Console.readLine());
        if(Amount%1000!=0){
            Error("구입금액은 1000의 배수여야 합니다.");
        }
        return Amount;
    }
    public static void PrintPurchaseResult(int Amount){
        int NumberOfGame = Amount/1000;
        System.out.println();
        System.out.println(NumberOfGame + "개를 구매했습니다.");
    }
    public static List<Integer> setWinningNumber(){
        
    }
    public static void UI(){

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
