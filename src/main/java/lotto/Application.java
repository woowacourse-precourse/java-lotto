package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        int lottoCount = validateBudget(Console.readLine());

    }

    public static int validateBudget(String input){
        int budget = 0;
        try{
            budget = Integer.parseInt(input) / 1000;
            if (budget % 1000 != 0) throwException("구입 금액은 1000의 배수여야 합니다.");
        }catch(Exception e){throwException("구입 금액은 숫자이어야 합니다.");}
        return (budget / 1000);
    }

    public static void throwException(String message){
        System.out.println("[ERROR] " + message);
        throw new IllegalArgumentException();
    }

}
