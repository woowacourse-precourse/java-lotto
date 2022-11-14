package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumber;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator;
        WinningNumber winningNumber;

        System.out.println("구입금액을 입력해주세요.");
        lottoGenerator = new LottoGenerator(Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine()));

        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumber = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();
        
        winningNumber = new WinningNumber(winNumber, Integer.valueOf(bonusNumber));
    }
}
