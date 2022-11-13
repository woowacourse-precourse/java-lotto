package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Input / Output 기능을 담당하는 클래스
 */
public class IoManager {

    private static final Format MONEY_FORMAT = new DecimalFormat("#,###");
    private static final Format RATE_FORMAT = new DecimalFormat("#,###.0");

    public static List<Integer> getWinningNumbersFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getNumbersFromUser(",");
    }

    public static int getBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getNumberFromUser();
    }

    public static int getBillFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return getNumberFromUser();
    }

    public static void printException(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void printLottoPublishInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach((lotto) -> printLotto(lotto));
    }

    public static void printScratchResult(ScratchResult scratchResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        LottoGrade.getLottoGradesWithoutFail().forEach(
                (grade) -> System.out.println(formattedCountOfGrade(grade, scratchResult.getCountOfGrade(grade))));

        System.out.println("총 수익률은 " + formattedNumber(RATE_FORMAT, scratchResult.getEarningRate()) + "%입니다.");
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    private static List<Integer> getNumbersFromUser(String parser) {
        try {
            String line = Console.readLine();
            String pattern = "[0-9]+(" + parser + "[0-9]+)*";

            if (!validateFitInPattern(line, pattern)) {
                throw new Exception();
            }

            return Arrays.stream(line.split(parser)).map((string) -> Integer.parseInt(string))
                    .collect(Collectors.toUnmodifiableList());

        } catch (Exception e) {
            throw new IllegalArgumentException("형식에 알맞지 않은 입력입니다. 입력은 숫자[,숫자] 형태로 주어져야 합니다.");
        }
    }


    private static int getNumberFromUser() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("형식에 알맞지 않은 입력입니다. 입력은 숫자로 주어져야 합니다.");
        }
    }

    private static boolean validateFitInPattern(String string, String patternString) {
        return string.matches(patternString);
    }

    private static String formattedCountOfGrade(LottoGrade grade, int count) {
        return String.format("%s (%s원) - %d개", formattedGrade(grade), formattedNumber(MONEY_FORMAT, grade.prize),
                count);
    }

    private static String formattedNumber(Format format, Number number) {
        return format.format(number);
    }

    private static String formattedGrade(LottoGrade grade) {
        String output = grade.matchNumberCount + "개 일치";

        if (grade.hasBonusNumber) {
            output += ", 보너스 볼 일치";
        }

        return output;
    }
}
