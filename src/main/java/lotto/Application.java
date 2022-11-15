package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Lotto lotto;
        int lottoCount;
        int bonusNum;
        int totalPrice;
        List<Grade> gradeList;

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        lottoCount = user.buyingLotto(input);
        user.generatingLotto(lottoCount);
        System.out.println();
        user.printCount();
        user.printBoughtLotto();
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNum = Console.readLine();
        lotto = new Lotto(user.choosingLottoNumber(inputLottoNum));
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();
        bonusNum = UserMissChecking.bonusNumberChecking(lotto.getNumbers(), inputBonusNum);
        lotto.addBonus(bonusNum);
        System.out.println();

        gradeList = lotto.saveResult(user.getBoughtLotto());
        lotto.printResult(gradeList);
        totalPrice = lotto.totalPrice(gradeList);
        System.out.println(totalPrice);
        user.marginRate(lottoCount, totalPrice);

    }
}
