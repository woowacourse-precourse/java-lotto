package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class View {
    public void printLine(String s) {
        try {
            System.out.println(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void print(String s) {
        try {
            System.out.print(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public int inputPrice() {
        int i;
        try {
            i = Integer.parseInt(Console.readLine());
            if (i % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return i/1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 로또 구입 금액이 올바르지 않습니다.");
            throw e;
        }
    }

    public List<Integer> inputLottoNumber() {
        try {
            String[] ss = Console.readLine().split(",");
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < ss.length; i++) {
                int number = Integer.parseInt(ss[i]);
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException();
                }
                numbers.add(number);
            }
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
    }
}
