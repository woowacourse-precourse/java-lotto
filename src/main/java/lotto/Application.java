package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	String money = getMoneyFromUser();
        // TODO: 프로그램 구현
    }
    
    public static String getMoneyFromUser() {
    	String result = Console.readLine();
    	return result;
    }
}
