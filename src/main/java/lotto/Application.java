package lotto;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String money =Console.readLine();
    }

    public static int moneyExceptionHandling(String moneyString){
        int moneyInt;
        try{
            moneyInt = parseInt(moneyString);
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if(moneyInt%1000!=0){
            System.out.println("[ERROR] 금액을 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return moneyInt/1000;
    }
}
