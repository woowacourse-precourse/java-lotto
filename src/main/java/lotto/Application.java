package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private static final int LOTTERY_PRICE = 1000;
    private static final String PRICE_PATTERN = "^\\d*$";
    public static void main(String[] args) {

        int buyPrice = receiveBuyPrice();
        int buyNum = buyPrice / LOTTERY_PRICE;

        List<Lotto> lotteries = Lotto.generateLotteries(buyNum);

    }

    /**
     * 사용자로부터 로또의 구입금액을 입력받는 함수 <br/>
     *
     * @return 로또의 구입 금액
     */
    public static int receiveBuyPrice() {
        System.out.print("구입금액을 입력해 주세요. : ");
        String userInput = Console.readLine();

        return parseBuyPrice(userInput);
    }

    /**
     * 매개변수로 주어진 사용자의 입력을 파싱해 int로 구하는 함수 <br/>
     * 만약 구입 금액이 숫자가 아니거나 나누어 떨어지지 않는 경우 IllegalArgumentException 발생
     *
     * @param userInput 사용자의 입력 문자열
     * @return 로또 구입 금액
     */
    public static int parseBuyPrice(String userInput) {
        if(!userInput.matches(PRICE_PATTERN)) throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");

        int price = Integer.parseInt(userInput);

        if(price % LOTTERY_PRICE != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어지는 값으로 입력해야 합니다.");

        return price;
    }

}
