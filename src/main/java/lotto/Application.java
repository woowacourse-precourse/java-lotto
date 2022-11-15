package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static int lottoCount = 0;
    public static List<Integer> winningNumber = new ArrayList<>();

    public static void main(String[] args) {
        lottoBuy();
        lottoIssue();
        setWinningNumbers();
        Lotto lotto = new Lotto(winningNumber);
    }

    public static void lottoBuy() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputLottoPrice = Console.readLine();
        int buyLottoPrice = Integer.parseInt(inputLottoPrice);
        if (buyLottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1,000원 단위로 입력해주세요.");
        }
        lottoCount = buyLottoPrice / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void lottoIssue() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNum = Console.readLine();
        for (String Number : inputNum.split(",")) {
            winningNumber.add(Integer.parseInt(Number));
        }
    }
}

