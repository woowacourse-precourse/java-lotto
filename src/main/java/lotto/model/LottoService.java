package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lotto.bo.Lotto;
import lotto.bo.WinningNumber;
import lotto.model.Checker.WinningPlace;

public class LottoService {
    static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private WinningNumber winningNumber;
    private Map<WinningPlace, Integer> winningResult;

    public void playLotto() {
        System.out.println("구입금액을 입력해주세요.");
        getLottos(Console.readLine());
        getWinningNumber();
        initializeWinningResult();
        calcWinningResult();
        printWinningResult();
    }

    public void getLottos(String money) {
        lottos = new ArrayList<>();
        validateMoney(money);
        int numberOfLottos = Integer.parseInt(money) / LOTTO_PRICE;

        System.out.printf("\n%d개를 구매했습니다.\n", numberOfLottos);
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUMBER,
                    Lotto.LOTTO_MAX_NUMBER,
                    Lotto.LOTTO_NUMBER_SIZE);
            Lotto lotto = new Lotto(numbers);
            printLottoNumbers(lotto);
            lottos.add(lotto);
        }
    }

    public void getWinningNumber() {
        String winningNumber;
        String bonusNumber = "1";
        System.out.println("\n당첨 번호를 입력해주세요.");
        winningNumber = Console.readLine();
        new WinningNumber(winningNumber, bonusNumber);
        System.out.println("\n보너스 번호를 입력해주세요.");
        bonusNumber = Console.readLine();
        this.winningNumber = new WinningNumber(winningNumber, bonusNumber);
    }

    private void validateMoney(String money) {
        int tempMoney;
        String range = "^[0-9]+$";
        if (!Pattern.matches(range, money)) {
            System.out.println("[ERROR] 구입 금액은 숫자여야합니다.");
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야합니다.");
        }
        tempMoney = Integer.parseInt(money);
        if (tempMoney % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 1000으로 나누어 떨어져야합니다.");
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야합니다.");
        }
        if (tempMoney < LOTTO_PRICE) {
            System.out.println("[ERROR] 구입 금액은 로또 한장의 가격을 넘어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 구입 금액은 로또 한장의 가격을 넘어야 합니다.");
        }
    }

    private void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        ArrayList<Integer> numbersNew = new ArrayList<>(numbers);
        Collections.sort(numbersNew);
        System.out.print("[");
        for (int i = 0; i < numbersNew.size(); i++) {
            System.out.print(numbersNew.get(i));
            if (i != numbersNew.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private void initializeWinningResult() {
        WinningPlace[] winningPlaces = WinningPlace.values();
        winningResult = new HashMap<>();
        for (WinningPlace tempWinningPlace : winningPlaces) {
            winningResult.put(tempWinningPlace, 0);
        }
    }

    private void calcWinningResult() {
        for (Lotto lotto : lottos) {
            WinningPlace tmpWinningPlace = Checker.calcWinningPlace(lotto, winningNumber);
            if (tmpWinningPlace != WinningPlace.NOTHING) {
                winningResult.merge(tmpWinningPlace, 1, Integer::sum);
            }
        }
    }

    private void printWinningResult() {
        double benefit = 0;
        WinningPlace[] winningPlaces = WinningPlace.values();

        for (int i = winningPlaces.length - 1; i >= 0; i--) {
            int corrects = winningPlaces[i].getCorrects();
            int winningValue = Integer.parseInt(winningPlaces[i].getWinningValue().replaceAll(",", ""));
            int myCorrects = winningResult.get(winningPlaces[i]);
            benefit += winningValue * myCorrects;
            if (winningPlaces[i] == WinningPlace.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", corrects, winningPlaces[i].getWinningValue(), myCorrects);
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", corrects, winningPlaces[i].getWinningValue(), myCorrects);
        }
        double benefitPercent = ((benefit) / (lottos.size() * LOTTO_PRICE)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", benefitPercent);
    }
}
