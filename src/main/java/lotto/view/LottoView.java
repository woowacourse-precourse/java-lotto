package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.customer.Customer;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoResult;

import java.util.*;

import static lotto.model.lotto.Rank.*;

public class LottoView {
    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_NUMBER_AMOUNT = 6;

    public int enterMoneyFromCustomer() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
            validateMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 형식의 입력입니다");
        }
        System.out.println();
        return money;
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하였습니다.");
        if (money < LOTTO_PRICE)
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하였습니다.");
    }

    public void printPurchasedLottos(Customer customer) {
        List<Lotto> lottos = customer.getLottos();
        System.out.printf("%d개를 구매했습니다.", lottos.size());
        System.out.println();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }

        System.out.println();
    }

    public List<Integer> enterWinNumbersFromAdmin() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winNumbers = new ArrayList<>();
        try {
            splitFromConsole(winNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 당첨번호를 입력하였습니다.");
        }

        System.out.println();

        return winNumbers;
    }

    private void splitFromConsole(List<Integer> winNumbers) {
        String[] input = Console.readLine().split(",");

        for (String s : input) {
            Integer number = Integer.valueOf(s);
            validateLottoNumber(number);
            winNumbers.add(number);
        }
        validateDuplicatedWinNumbers(winNumbers);
    }

    private void validateDuplicatedWinNumbers(List<Integer> winNumbers) {
        Set<Integer> numberSet = new HashSet<>(winNumbers);
        if (numberSet.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨번호를 입력하였습니다.");
        }
    }

    private void validateLottoNumber(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int enterBonusNumberFromAdmin(List<Integer> winNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.valueOf(Console.readLine());

        validateLottoNumber(bonusNumber);
        validateDuplicateBonusLottoNumber(winNumbers, bonusNumber);

        System.out.println();
        return bonusNumber;
    }

    private void validateDuplicateBonusLottoNumber(List<Integer> winNumbers, Integer bonusNumber) {
        if (winNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함된 번호입니다.");
    }

    public void printStat(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FIFTH.getCntOfSameNumber(), FIFTH.getPrizeMoney(), lottoResult.getRankResult().get(FIFTH));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FORTH.getCntOfSameNumber(), FORTH.getPrizeMoney(), lottoResult.getRankResult().get(FORTH));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", THIRD.getCntOfSameNumber(), THIRD.getPrizeMoney(), lottoResult.getRankResult().get(THIRD));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", SECOND.getCntOfSameNumber(), SECOND.getPrizeMoney(), lottoResult.getRankResult().get(SECOND));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FIRST.getCntOfSameNumber(), FIRST.getPrizeMoney(), lottoResult.getRankResult().get(FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.getRateOfReturn());
    }
}
