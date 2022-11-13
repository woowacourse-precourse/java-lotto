package view;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import domain.Lotto;
import domain.LottoGrade;
import dto.ScratchResult;

public class LottoGameView implements IoView {

    private final Format MONEY_FORMAT = new DecimalFormat("#,###");
    private final Format RATE_FORMAT = new DecimalFormat("#,###.0");

    private LottoGameView() {
    }

    static class SingleTone {

        private static final IoView INSTANCE = new LottoGameView();
    }

    public static IoView getInstance() {
        return SingleTone.INSTANCE;
    }

    @Override
    public List<Integer> getWinningNumbersFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getNumbersFromUser(",");
    }

    @Override
    public int getBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getNumberFromUser();
    }

    @Override
    public int getBillFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return getNumberFromUser();
    }

    @Override
    public void printException(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    @Override
    public void printLottoPublishInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach((lotto) -> printLotto(lotto));
    }

    @Override
    public void printScratchResult(ScratchResult scratchResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        LottoGrade.getLottoGradesWithoutFail().forEach(
                (grade) -> System.out.println(formattedCountOfGrade(grade, scratchResult.getCountOfGrade(grade))));

        System.out.println("총 수익률은 " + formattedNumber(RATE_FORMAT, scratchResult.getEarningRate()) + "%입니다.");
    }


    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
    }

    private List<Integer> getNumbersFromUser(String parser) {
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


    private int getNumberFromUser() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("형식에 알맞지 않은 입력입니다. 입력은 숫자로 주어져야 합니다.");
        }
    }

    private boolean validateFitInPattern(String string, String patternString) {
        return string.matches(patternString);
    }

    private String formattedCountOfGrade(LottoGrade grade, int count) {
        return String.format("%s (%s원) - %d개", formattedGrade(grade), formattedNumber(MONEY_FORMAT, grade.prize),
                count);
    }

    private String formattedNumber(Format format, Number number) {
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
