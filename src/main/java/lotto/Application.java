package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int money=getMoneyInput();

    }

    private static int getMoneyInput(){
        int moneyInput=getIntegerInput();
        if(moneyInput<0){
            throw new IllegalArgumentException();
        }
        return moneyInput;
    }

    private static int getIntegerInput(){
        try{
            return Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
