package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구입 금액 입력 받기
        int account = setAccount();
        System.out.println("account = " + account);

    }

    private static int setAccount() {
        int account = Integer.parseInt(Console.readLine());
        return account;
    }




}
