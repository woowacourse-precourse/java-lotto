package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.Rank.Grade;

public class LottoGame {
    public static void startGame() {
        int money = getMoney();

        List<Lotto> lottoList = Lotto.getLottoList(money);
        printLottoList(lottoList);

        Lotto winningNumbers = Lotto.inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        Lotto.validateBonusNumber(bonusNumber, winningNumbers);

        Map<Integer, Integer> result = Rank.getResult(winningNumbers, lottoList, bonusNumber);
        printResult(result);

        double yield = getYield(money, result);
        System.out.printf(Messages.OUTPUT_YIELD_MESSAGE, yield);
    }

    public static int getMoney() {
        System.out.println(Messages.OUTPUT_START_GAME_MESSAGE);
        String inputMoney = Console.readLine();
        validateMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static void validateMoney(String inputMoney) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(inputMoney);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static int inputBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.printf(Messages.OUTPUT_BUY_MESSAGE, lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<Integer, Integer> result) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(Messages.OUTPUT_WINNING_MESSAGE);
        for (Grade grade : Grade.values()) {
            if (grade.isCheck()) {
                System.out.printf(Messages.OUTPUT_BONUS_MESSAGE, grade.getMatchCount(), decimalFormat.format(grade.getPrize()),
                        result.get(7));
            }
            if (!grade.isCheck()) {
                System.out.printf(Messages.OUTPUT_RESULT_MESSAGE, grade.getMatchCount(), decimalFormat.format(grade.getPrize()),
                        result.get(grade.getMatchCount()));
            }
        }
    }

    public static double getYield(int money, Map<Integer, Integer> result) {
        double sum = 0;
        for (Grade grade : Grade.values()) {
            if (grade.isCheck())
                sum += grade.getPrize() * result.get(7);
            if (!grade.isCheck()) {
                sum += grade.getPrize() * result.get(grade.getMatchCount());
            }
        }
        return (sum / money) * 100;
    }
}
