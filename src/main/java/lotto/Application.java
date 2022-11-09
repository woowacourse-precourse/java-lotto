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
        // 입력 받은 금액 검증
        if(validAccount(account)){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1,000원 단위로 입력해주세요.");
        }
        return account;
    }

    private static boolean validAccount(int account) {
        if (account % 1000 == 0) {
            return false;
        }
        return true;
    }


}
