package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        String input = readInput();

        final int MONEY = validateMoneyInput(input);
        

    }

    public static String readInput(){
        String input = Console.readLine();
        return input;
    }

    public static int validateMoneyInput(String input){
        int money = parseInt(input);
        boolean isUnitOf1K = ((money % 1000)==0);

        if (isUnitOf1K==false){
            throw new IllegalArgumentException("[Error] Money should end with 000");
        }

        return money;
    }

    public static int parseInt(String input){
        try {
            int money = Integer.parseInt(input);
            return money;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[Error] Only numbers are allowed");
        }
    }

}
