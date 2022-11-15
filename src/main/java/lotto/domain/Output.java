package lotto.domain;

import java.util.List;

public class Output {
    public void printBuyLotto(List<List<Integer>> buyLotto) {

        StringBuilder sb = new StringBuilder();

        int amount = buyLotto.size();

        sb.append("\n" + amount).append(PrintMessages.LOTTO_COUNT.getMessage()).append("\n");

        for (List<Integer> lotto : buyLotto) {
            sb.append(lotto).append("\n");
        }
        System.out.println(sb);
    }

    public void printLottoResult(List<Rank> Result) {
        StringBuilder sb = new StringBuilder();
        sb.append(PrintMessages.LOTTO_RESULT.getMessage());

        for (Rank rank : Rank.values()) {
            sb.append(resultMessage(rank, Result)).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public String resultMessage(Rank rank, List<Rank> Result) {
        StringBuilder sb = new StringBuilder();

        long count = countRank(rank, Result);

        if (rank != Rank.BLANK) {
            sb.append(rank.getMESSAGE()).append(count).append("개");
        }

        return sb.toString();
    }

    public long countRank(Rank rank, List<Rank> lottoRanks) {
        long count = lottoRanks.stream().filter(lottoRank -> lottoRank == rank).count();
        return count;
    }

    public void printPercent(String percent) {
        StringBuilder sb = new StringBuilder();
        sb.append(PrintMessages.LOTTO_PERCENT_FRONT.getMessage()).append(percent)
                .append(PrintMessages.LOTTO_PERCENT_END.getMessage());

        System.out.println(sb);
    }

    public void printInputMessage() {
        System.out.println(PrintMessages.INPUT_NUMBER.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println(PrintMessages.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printInputMoney() {
        System.out.println(PrintMessages.INPUT_MONEY.getMessage());
    }
}