package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUI {
    private final Manager manager;
    private Lotto lotto;
    private int bonusNumber;
    private List<List<Integer>> publishPurchaseLottos;

    public LottoUI(Manager manager) {
        this.manager = manager;
    }

    public void getLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] matchCount = manager.findMatchCount(lotto, publishPurchaseLottos);

        System.out.printf("%d개 일치 (5,000원) - %d개", 3, matchCount[0]);
        System.out.printf("%d개 일치 (50,000원) - %d개", 4, matchCount[1]);
        System.out.printf("%d개 일치 (1,500,000원) - %d개", 5, matchCount[2]);
        System.out.printf("%d개 일치 (30,000,000원) - %d개", 5, matchCount[3]);
        System.out.printf("%d개 일치 (2,000,000,000원) - %d개", 6, matchCount[4]);

        double rate = manager.calculateYield(matchCount);
        System.out.printf("총 수익률은 %f%입니다.", rate);
    }

    public void setPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        validateIsNumber(input);

        manager.setPurchasePrice(Integer.parseInt(input));
    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        validateIsNumber(input);
        bonusNumber = Integer.parseInt(input);
        validateRange(bonusNumber);
    }

    public void publishLottos() {
        publishPurchaseLottos = manager.publishPurchaseLottos();
    }

    public Lotto getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split(",");

        List<Integer> lottoNumbers = Arrays.stream(input)
                .peek(eachNumber -> validateIsNumber(eachNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    private void validateIsNumber(String each) {
        try {
            Integer.parseInt(each);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }

    private void validateRange(int number) {
        if (number < LottoConst.START_RANGE || LottoConst.END_RANGE < number) {
            throw new IllegalArgumentException("[ERROR] 범위를 벗어난 숫자입니다.");
        }
    }
}
