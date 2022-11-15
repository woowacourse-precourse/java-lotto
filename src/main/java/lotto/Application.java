package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Lotto lotto;
        int lottoCount;
        int bonusNum;
        List<Grade> gradeList;

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        lottoCount = user.buyingLotto(input);
        user.generatingLotto(lottoCount);
        user.printBoughtLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNum = Console.readLine();
        lotto = new Lotto(user.choosingLottoNumber(inputLottoNum));

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();
        bonusNum = UserMissChecking.bonusNumberChecking(lotto.getNumbers(), inputBonusNum);
        lotto.addBonus(bonusNum);

        gradeList = lotto.saveResult(user.getBoughtLotto());
    }
}
