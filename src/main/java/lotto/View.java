package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class View {
    public void printLine(String s) {
        try {
            System.out.println(s);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void print(String s) {
        try {
            System.out.print(s);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void printListOfBuyLotto(List<Lotto> list) {
        try {
            for (Lotto l : list) {
                System.out.println(l.getNumbers().toString());
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void printResult(Rank[] values, String yield) {
        try {
            printLine("당첨 통계\n---");
            for (Rank rank : values) {
                System.out.println(rank.getSameNumber() + "개 일치"
                        + "(" + rank.getPrizeMoney() + ")" + " - " + rank.getCount() + "개");
            }
            System.out.println("총 수익률은 " + yield + "%입니다.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public int inputPrice() {
        int i;
        try {
            i = Integer.parseInt(Console.readLine());
            if (i % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return i / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 로또 구입 금액이 올바르지 않습니다.");
            throw e;
        }
    }

    public List<Integer> inputLottoNumber() {
        try {
            printLine("당첨 번호를 입력해 주세요.");
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

    public Integer inputBonusNumber() {
        try {
            printLine("당첨 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
    }
}
