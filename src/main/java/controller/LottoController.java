package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    Validator validator = new Validator();

    /**
     * 로또 구입
     * - 구입 금액 입력
     * <p>
     * 로또 발행
     * - 구매 갯수 출력
     * - 발행 번호 출력
     * <p>
     * 당첨 번호 입력
     * - 당첨 번호 6자리 입력
     * - 보너스 번호 입력
     * <p>
     * 당첨 통계, 총 수익률 출력
     */

    public void run() {
        int lottoCount = buyLotto();
        System.out.println();

        ArrayList<Lotto> lottos = publishLotto(lottoCount);

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber());
        validator.validateReference(winningNumbers.getWinningNumbers(), bonusNumber.getBonusNumber());

        winningList(lottoCount, lottos, winningNumbers, bonusNumber);

    }



    public int buyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        validator.validateMoneyNumber(userMoney);
        validator.validateMoneyUnit(userMoney);
        Money money = new Money(userMoney);
        return money.getLottoCount();
    }

    public ArrayList<Lotto> publishLotto(int count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        System.out.printf("%d개를 구매했습니다.\n", count);
        LottoMaker lottoMaker = new LottoMaker();
        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoMaker.makeLotto();
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottos;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        validator.validateWinningNumberComma(winningNumber);

        List<Integer> winningNumbers = Arrays.stream(Arrays.stream(winningNumber.split(","))
                        .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toList());

        validator.validateWinningNumberSize(winningNumbers);
        validator.validateWinningNumberRange(winningNumbers);
        validator.validateWinningNumberReference(winningNumbers);
        return winningNumbers;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();
        validator.validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    public void winningList(int lottoCount, ArrayList<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {

    }


}
