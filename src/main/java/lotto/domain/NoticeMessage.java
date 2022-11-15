package lotto.domain;

import lotto.dto.ResultResponse;

import static lotto.domain.LottoStatus.DELIMITER_LENGTH;

public enum NoticeMessage {
    PURCHASING_AMOUNT{
        @Override
        public String toString() {
            return "구입금액을 입력해 주세요.";
        }
    },
    LOTTO_COUNT{
        @Override
        public String toString() {
            return "개를 구매했습니다.";
        }
    },
    LUCKY_NUMBER{
        @Override
        public String toString() {
            return "당첨 번호를 입력해 주세요.";
        }
    },
    BONUS_NUMBER{
        @Override
        public String toString() {
            return "보너스 번호를 입력해 주세요.";
        }
    },
    WINNING_STATISTICS{
        @Override
        public String toString() {
            return "당첨 통계\n" +
                    "---";
        }
    },
    ADDITIONAL_SECOND{
        @Override
        public String toString() {
            return ", 보너스 볼 일치";
        }
    };

    public static String printWinningStatistics(ResultResponse result, int rank) {
        WinningNumberStatus winningNumberStatus = WinningNumberStatus.getWinningNumberStatusByOrder(rank);
        return winningNumberStatus.getCount() + "개 일치" + getAdditionalSecondNotice(rank)
                + " (" + getProcessedMoney(winningNumberStatus.getMoney())+ "원) - "
                + result.getResult().get(rank) + "개";
    }

    private static String getProcessedMoney(int money) {
        String interimMoney = String.valueOf(money);
        int count = 0;

        StringBuilder processedMoney = new StringBuilder();
        for (int index = interimMoney.length(); index > 0; index--) {
            if (count == DELIMITER_LENGTH.getValue()) {
                processedMoney.append(",");
                count = 0;
                index++;
                continue;
            }

            processedMoney.append(interimMoney.charAt(index - 1));
            count++;
        }
        return processedMoney.reverse().toString();
    }

    private static String getAdditionalSecondNotice(int rank) {
        if (rank == WinningNumberStatus.SECOND.getOrder()) {
            return ADDITIONAL_SECOND.toString();
        }
        return "";
    }

    public static String printEarningRate(double earningRate) {
        return "총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.";
    }
}
