package view;

import camp.nextstep.edu.missionutils.Console;
import model.Model;
import domain.lotto.Rank;
import domain.lotto.Lotto;
import domain.lotto.LottoRepository;

import java.text.DecimalFormat;
import java.util.List;

import static view.message.Message.*;

public class View {

    public static String setAmount() {

        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static void printCount() {
        Model model = Model.getInstance();
        int count = model.getUser().getCount();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printIssuanceLottoNumbers() {

        Model model = Model.getInstance();

        LottoRepository lottoRepository = model.getLottoRepository();
        List<Lotto> lottoList = lottoRepository.getLottoList();

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static String createWinningNumber() {
        System.out.println(INPUT_NUM_MESSAGE);
        return Console.readLine();
    }

    public static String createBonusNumber() {
        System.out.println(INPUT_BONUS_NUM_MESSAGE);
        return Console.readLine();
    }

    public static void printLottoResult() {
        Model model = Model.getInstance();
        int yield = model.getUser().getYield();
        int amount = model.getUser().getAmount();

        printBeforeResult();
        printRank();
        String rate = String.format("%.1f", 100.0 * (double) yield / (double) amount);
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    private static void printBeforeResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static void printRank() {
        for (Rank value : Rank.values()) {

            if (value == Rank.NONE) {
                continue;
            }
            print(value);
        }
    }

    private static void print(Rank value) {
        DecimalFormat df = new DecimalFormat("###,###");
        String amount = df.format(value.getReward());
        System.out.println(value.getOutput() + " ("  + amount + "원)" + " - " + value.getCount() + "개");
    }
}
