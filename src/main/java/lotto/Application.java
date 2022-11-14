package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    private static final String ERROR = "[ERROR]";
    static int Recall = 0;
    static int money;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요");

        try {
            input(Console.readLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Recall = money / 1000;

        System.out.println(Recall+"개");

    }

    private static void input(String moneya) {
        try {
            for (int i = 0; i < moneya.length(); i++) {
                if (!(moneya.charAt(i) >= '0' && moneya.charAt(i) <= '9')) {
                    throw new IllegalArgumentException(ERROR);
                }
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR+ "잘못된 금액입니다.");
        }

        money = Integer.parseInt(moneya);

        if(money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + "천원단위로 구매해주세요.");
        }
    }
}
