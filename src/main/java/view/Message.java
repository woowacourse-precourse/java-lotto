package view;

import static model.WinStatistics.earningRate;

import java.util.Arrays;
import model.WinStatistics.Rank;

public class Message {
    public static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    public static final String INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATISTICS = "당첨 통계\n---";
    public static final String WIN_FIFTH_PLACE = "3개 일치 (5,000원) - %d개";
    public static final String WIN_FOURTH_PLACE = "4개 일치 (50,000원) - %d개";
    public static final String WIN_THIRD_PLACE = "5개 일치 (1,500,000원) - %d개";
    public static final String WIN_SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    public static final String WIN_FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개";
    public static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printUserInput(String userInput) {
        System.out.println(userInput);
    }

    public static void printEarningRate() {
        System.out.printf(Message.EARNING_RATE + "%n", earningRate);
    }

    public static void printWinStatistics() {
        Message.print(Message.WIN_STATISTICS);
        Arrays.stream(Rank.values())
                .forEach(Rank::print);
    }
}