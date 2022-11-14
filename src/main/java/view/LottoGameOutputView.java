package view;

import domain.Lotto;
import domain.LottoGrade;
import dto.ScratchResult;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameOutputView implements OutputView {

    private final Format MONEY_FORMAT = new DecimalFormat("#,###");
    private final Format RATE_FORMAT = new DecimalFormat("#,###.0");

    static class Singleton {

        private static final OutputView INSTANCE = new LottoGameOutputView();
    }

    private LottoGameOutputView() {
    }

    public static OutputView getInstance() {
        return Singleton.INSTANCE;
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
