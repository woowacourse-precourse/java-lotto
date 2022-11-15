package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        lottoBuy();
    }

    public static void lottoBuy() {
        Scanner scanner = new Scanner(System.in);
        int buyLottoPrice = scanner.nextInt();
        if(buyLottoPrice % 1000 != 0 ) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1,000원 단위로 입력해주세요.");
        }
        int lottoCount = buyLottoPrice / 1000;
        System.out.println(lottoCount+ "개를 구매했습니다.");
    }
}
