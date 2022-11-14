package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Inputer {
    private static final String REGEX = ",";

    public int inputMoney() {

        int userInputMoney = Integer.parseInt(readLine());

        return userInputMoney;
    }

    public List<Integer> createLottoWinNumber() {

        String lottoWin = readLine();
        List<Integer> lottoWinNumberList = lottoWinList(lottoWin);

        return lottoWinNumberList;
    }

    public int inputLottoBonusNumber() {

        int bonusNumber = Integer.parseInt(readLine());

        return bonusNumber;
    }


    public List<Integer> lottoWinList(String lottoWin) {

        String[] lottoWinArray = lottoWin.split(REGEX);

        List<Integer> lottoWinList = new ArrayList<>();

        for (int i = 0; i < lottoWinArray.length; i++) {
            lottoWinList.add(Integer.parseInt(lottoWinArray[i]));
        }

        return lottoWinList;
    }

}
