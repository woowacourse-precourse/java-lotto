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

        System.out.printf("%d개 일치 (5,000원) - %d개\n", 3, matchCount[0]);
        System.out.printf("%d개 일치 (50,000원) - %d개\n", 4, matchCount[1]);
        System.out.printf("%d개 일치 (1,500,000원) - %d개\n", 5, matchCount[2]);
        System.out.printf("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 5, matchCount[3]);
        System.out.printf("%d개 일치 (2,000,000,000원) - %d개\n", 6, matchCount[4]);

        double rate = manager.calculateYield(matchCount);
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    public void setPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        Validation.validateIsNumber(input);

        manager.setPurchasePrice(Integer.parseInt(input));
    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        Validation.validateIsNumber(input);
        bonusNumber = Integer.parseInt(input);
        Validation.validateRange(bonusNumber);
    }

    public void publishLottos() {
        publishPurchaseLottos = manager.publishPurchaseLottos();
    }

    public void setLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split(",");

        List<Integer> lottoNumbers = Arrays.stream(input)
                .peek(eachNumber -> Validation.validateIsNumber(eachNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        lotto =  new Lotto(lottoNumbers);
    }


}
