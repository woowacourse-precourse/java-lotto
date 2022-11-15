package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void Error(String ErrorType){
        throw new IllegalArgumentException("[ERROR] " + ErrorType);
    }
    public static Integer EnterAmount(){
        Integer Amount;
        Amount = Integer.parseInt(Console.readLine());
        if(Amount%1000!=0){
            Error("구매 금액은 1000의 배수여야 합니다.");
        }
        return Amount;
    }
    public static void InPut(){

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
