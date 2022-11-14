package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void printResult(Rank[] values, double yield) {
        try {
            printLine("당첨 통계\n---");
            printInformOfRank(values);
            System.out.println("총 수익률은 " + yield + "%입니다.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void printInformOfRank(Rank[] values) {
        DecimalFormat df = new DecimalFormat("###,###");
        for (int i = 0; i < values.length; i++) {
            if (i == 3) {
                System.out.println(values[i].getSameNumber() + "개 일치, 보너스 볼 일치 "
                        + "(" + df.format(values[i].getPrizeMoney()) + "원)" + " - " + values[i].getCount() + "개");
            } else {
                System.out.println(values[i].getSameNumber() + "개 일치 "
                        + "(" + df.format(values[i].getPrizeMoney()) + "원)" + " - " + values[i].getCount() + "개");
            }
        }
    }

    public int inputPrice() {
        try {
            int i = Integer.parseInt(Console.readLine());
            if (i % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return i / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 구입 금액이 올바르지 않습니다.");
            return inputPrice();
        }
    }

    public List<Integer> inputLottoNumber() {
        try {
            printLine("당첨 번호를 입력해 주세요.");
            String[] ss = Console.readLine().split(",");
            List<Integer> numbers = new ArrayList<>();
            checkValidateLottoNumber(ss, numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return inputLottoNumber();
        }
    }

    public void checkValidateLottoNumber(String[] ss, List<Integer> numbers){
        for (int i = 0; i < ss.length; i++) {
            int number = Integer.parseInt(ss[i]);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
            numbers.add(number);
        }
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numSet.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호가 중복되었습니다.");
            throw new IllegalArgumentException();
        }
    }

    public Integer inputBonusNumber() {
        try {
            printLine("보너스 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return inputBonusNumber();
        }
    }
}
