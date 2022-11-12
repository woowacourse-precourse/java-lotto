package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.Lotto.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Control {
    private final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private final String CONFIRM_MESSAGE = "개를 구매했습니다.";
    private final String INPUT_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private final String WINNING_STATISTICS = "당첨 통계\n---";

    private List<Lotto> lotteries;
    private int price;

    public Control() {

    }

    /* 복권 진행 */
    public void play() {
        System.out.println(START_MESSAGE);
        String cost = readLine();
        buyLotto(cost);

        createLotto();

        printMyLotto();

    }

    /* 복권 구매 */
    private void buyLotto(String cost) {
        price = Integer.parseInt(cost);
        buyValidation();
    }

    /* 지불한 금액만큼 로또 생성 */
    private void createLotto() {
        int item = price % 1_000;
        System.out.println(item + CONFIRM_MESSAGE);
        System.out.println();

        for (int i = 0; i < item; i++) {
            lotteries = new ArrayList<>();
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotteries.add(lotto);
        }
    }

    /* 구매한 로또 출력 */
    private void printMyLotto() {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    /* 구매 검증 */
    private void buyValidation() {
        if (price < 1_000) {
            throw new IllegalArgumentException("[ERROR] 로또 최소 구매 금액은 1,000원 입니다.");
        }

        if (price > 100_000) {
            throw new IllegalArgumentException("[ERROR] 로또는 1회 최대 100,000원까지 구매 가능합니다.");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 저희 복권 판매점은 거슬러 주지 않습니다.");
        }
    }

    /* 문자열을 정수 리스트로 변환 */
    private List<Integer> stringToIntegerList(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(",");
        return Arrays
                .stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
