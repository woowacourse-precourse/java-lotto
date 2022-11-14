package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Inputer {


    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int userInputMoney = Integer.parseInt(readLine());
        return userInputMoney;
    }

    public List<Integer> createLottoWinNumber() {
        Maker maker = new Maker();

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoWin = readLine();

        List<Integer> lottoWinNumberList = maker.lottoWinList(lottoWin);

        return lottoWinNumberList;
    }

    public int inputLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        return bonusNumber;
    }

}
