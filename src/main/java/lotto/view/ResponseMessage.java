package lotto.view;

import lotto.domain.Rank;

import java.util.Map;

public class ResponseMessage {
    private static final int SECOND_RANK_MATCH = 7;
    private static final int START_KEY = 3;
    private static final int END_KEY = 6;
    private static final int SECOND_THIRD_RANK_MATCH = 5;
    private static final int NOTHING_MATCH = 0;
    static StringBuilder responseMessage = new StringBuilder();

    public static void initStringBuilder() {
        responseMessage.setLength(0);
        responseMessage.append('\n');
    }

    public static void printPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printLottoNumbers(int lottoNumber) {
        responseMessage.append('\n')
                .append(lottoNumber)
                .append("개를 구매했습니다.");
        System.out.println(responseMessage);
    }

    public static void printWinningNumbers() {
        initStringBuilder();
        responseMessage.append("당첨 번호를 입력해 주세요.");
        System.out.println(responseMessage);
    }

    public static void printBonusNumber() {
        initStringBuilder();
        responseMessage.append("보너스 번호를 입력해 주세요.");
        System.out.println(responseMessage);
    }

    public static void printWinStatistics(Map<Integer, Integer> matches, String profitRate) {
        initStringBuilder();
        responseMessage.append("당첨 통계\n").append("---\n");

        for (int key = START_KEY; key <= END_KEY; key++) {
            responseMessage.append(Rank.findRankByMatch(key).toString())
                    .append(matches.getOrDefault(key, NOTHING_MATCH)).append("개\n");
            if (key == SECOND_THIRD_RANK_MATCH) {
                responseMessage.append(Rank.findRankByMatch(SECOND_RANK_MATCH).toString())
                        .append(matches.getOrDefault(SECOND_RANK_MATCH, NOTHING_MATCH)).append("개\n");
            }
        }
        responseMessage.append("총 수익률은 ").append(profitRate).append("%입니다.");
        System.out.println(responseMessage);
    }
}
