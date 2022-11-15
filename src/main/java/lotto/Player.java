package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int lottoCount;

    public int getLottoCount() {
        return lottoCount;
    }

    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String pay = Console.readLine();
        payValidate(pay);
        lottoCount = Integer.parseInt(pay) / 1000;
        printCount();
    }

    public void payValidate(String input) {
        Integer price;
        try {
            price = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력 가능합니다");
        }
    }

    private void printCount() {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void getLottoNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<Integer> integers = stringToList(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        //보너스 입력 구현
    }

    public List<Integer> stringToList(String numbers) {
        String[] split = numbers.split(",");
        List<Integer> integers = new ArrayList<>();

        for (String s : split) {
            try {
                integers.add(Integer.parseInt(s));
            }
            catch (NumberFormatException ex) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
            }
        }

        if (integers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야합니다");
        }

        return integers;
    }
}
