package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumber;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator;
        WinningNumber winningNumber;
        int generateCount = 0;
        int[] result = new int[6];

        System.out.println("구입금액을 입력해주세요.");
        lottoGenerator = new LottoGenerator(Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine()));
        generateCount = lottoGenerator.getGenerateCount();
        Lotto[] lottoGroup = new Lotto[generateCount];
        for (int i = 0; i < generateCount; i++) {
            lottoGroup[i] = new Lotto(lottoGenerator.createLottoNumber());
        }

        System.out.println(generateCount + "개를 구매했습니다.");
        for (Lotto lotto: lottoGroup) {
            System.out.println(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winInputNumber = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInputNumber = camp.nextstep.edu.missionutils.Console.readLine();
        
        winningNumber = new WinningNumber(winInputNumber, Integer.valueOf(bonusInputNumber));

        for (int i = 0; i < generateCount; i++) {
            int rank = lottoGroup[i].lottoChecker(winningNumber.getWinNumber(), winningNumber.getBonusNumber());
            result[rank]++;
        }
    }
}
