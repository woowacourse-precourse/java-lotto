package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Print.ASK_BUY);
        int publishNum = getPublishNum();
        System.out.println("publishNum: "+publishNum);

    }

    //로또 구입
    private static String inputBudget() {
        String input = Console.readLine();

        validateInputBudget(input);

        System.out.println("inputBudget: "+input);

        return input;
    }

    private static void validateInputBudget(String input) {
        if(!Pattern.matches("^[0-9]*000$", input)) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 숫자만 입력해 주세요.");
        }
    }

    private static int getBudget() {
        return Integer.parseInt(inputBudget());
    }

    private static int getPublishNum() {
        return getBudget()/1000;
    }
}
