package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class View {
    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void requestAmount() {
        output.printOutput(Message.REQUEST_PURCHASE_AMOUNT.toString());
    }

    public String getInput() {
        return input.input();
    }

    public void showLotto(List<Lotto> lottos) {
        showCount(lottos.size());
        lottos.forEach(lotto -> output.printOutput(lotto.toString()));
    }

    private void showCount(int count) {
        output.printOutput(count + Message.PURCHASE_MESSAGE.toString());
    }

    public void requestNumbers() {
        output.printOutput(Message.GET_LOTTO_NUMBER.toString());
    }

    public void requestBonus() {
        output.printOutput(Message.GET_BONUS_NUMBER.toString());
    }

    public void printError(String message) {
        output.printOutput(message);
    }

    public void showResult(LottoResult lottoResult) {
        output.printOutput(Message.RESULT_INFO.toString());
        lottoResult.getRank().entrySet()
                .stream()
                .filter(result -> !result.getKey().equals(LottoRank.SIXTH))
                .forEach(this::showAllResult);
        showYield(lottoResult.getYield());
    }

    private void showYield(double yield) {
        output.printOutput(
                String.format(Message.YIELD_RESULT.toString(), yield));
    }

    private void showAllResult(Map.Entry<LottoRank, Integer> result) {
        if (result.getKey().getReward() == 30000000) {
            showBonus(result);
            return;
        }
        showCommon(result);
    }

    private void showBonus(Map.Entry<LottoRank, Integer> result) {
        output.printOutput(
                String.format(Message.BONUS_RESULT.toString(), result.getKey().getMatchCount(),
                        result.getKey().getReward(), result.getValue()));
    }

    private void showCommon(Map.Entry<LottoRank, Integer> result) {
        output.printOutput(
                String.format(Message.EACH_RESULT.toString(), result.getKey().getMatchCount(),
                        result.getKey().getReward(), result.getValue()));
    }
}
