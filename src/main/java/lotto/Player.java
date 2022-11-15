package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int payMoney;
    private int lottoCount;
    private Lotto lotto;
    private Integer bonus;

    public int getPayMoney() {
        return payMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String pay = Console.readLine();
        payValidate(pay);
        payMoney = Integer.parseInt(pay);
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
        lotto = new Lotto(integers);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        bonusValidate(bonusNum);
        bonus = Integer.parseInt(bonusNum);
    }

    public List<Integer> stringToList(String numbers) {
        int num;
        String[] split = numbers.split(",");
        List<Integer> integers = new ArrayList<>();

        for (String s : split) {
            try {
                num = Integer.parseInt(s);
            }
            catch (NumberFormatException ex) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
            }
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이에 숫자만 입력 가능합니다");
            }
            integers.add(num);
        }
        if (integers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야합니다");
        }

        return integers;
    }

    public void bonusValidate(String input) {
        int bonus;
        try {
            bonus = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }

        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이에 숫자만 입력 가능합니다");
        }
    }
}
