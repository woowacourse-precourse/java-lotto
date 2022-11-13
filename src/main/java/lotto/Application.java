package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int lottoCount = getLottoCount(inputAmount());
    }

    protected static int getLottoCount(String inputAmount) throws IllegalArgumentException {
        if(inputAmount.length() == 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 입력하지 않았습니다.");
        int amount = Integer.parseInt(inputAmount);
        if(amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return amount / 1000;
    }

    private static String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
