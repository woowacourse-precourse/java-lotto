package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        Integer numOfLotto = isUserPaymentValid(userPayment());
    }
    public static String userPayment () {
        return Console.readLine();
    }
    public static Integer isUserPaymentValid (String userPayment) {
        try {Integer.parseInt(userPayment);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERROR");
        }
        Integer numberOfLotto = Integer.parseInt(userPayment);
        try {
            if (numberOfLotto%1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
        }
        return numberOfLotto/1000;
    }
}