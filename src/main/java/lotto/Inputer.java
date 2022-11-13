package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inputer {

    public int inputMoney() {

        Scanner scanner = new Scanner(System.in);

        int userInputMoney = scanner.nextInt();

        return userInputMoney;
    }

    public String createLottoWinNumber() {
        Scanner scanner = new Scanner(System.in);

        String lottoWin = scanner.next();

        return lottoWin;
    }

    public int inputLottoBonusNumber() {
        Scanner scanner = new Scanner(System.in);

        int bonusNumber = scanner.nextInt();

        return bonusNumber;
    }

}
