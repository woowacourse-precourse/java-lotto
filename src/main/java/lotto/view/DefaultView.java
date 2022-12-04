package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.controller.dto.MoneyDto;
import lotto.controller.dto.WinningNumbersDto;
import lotto.domain.LottoRank;

import java.util.EnumMap;
import java.util.Map;

public class DefaultView implements View {

    private final LottoController controller;

    public DefaultView(LottoController controller) {
        this.controller = controller;
    }

    public void render() {
        try {
            sendMoney();
            renderLottos();
            sendWinningNumbers();
            renderStatics();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private void sendMoney() {
        System.out.println(Views.REQUEST_MONEY.render());
        String input = Console.readLine();

        MoneyDto moneyDto = new MoneyDto(input);
        controller.inputMoney(moneyDto);
    }

    private void sendWinningNumbers() {
        System.out.println(Views.REQUEST_WINNING_NUMBER.render());
        String winningNumber = Console.readLine();

        System.out.println(Views.REQUEST_BONUS_NUMBER.render());
        String bonusNumber = Console.readLine();

        WinningNumbersDto dto = new WinningNumbersDto(winningNumber, bonusNumber);
        controller.inputWinningNumbers(dto);
    }

    private void renderLottos() {
        String lottosSize = controller.outputLottoSize();
        System.out.println(Views.LOTTOS_COUNT.render(lottosSize));

        String lottos = controller.outputLottos();
        System.out.println(lottos);
    }

    private void renderStatics() {
        System.out.println(Views.STATICS.render());
        System.out.println(Views.DIVIDER.render());
        EnumMap<LottoRank, Integer> lottoRanks = controller.outputRanks();
        renderRanks(lottoRanks);
        double profitRate = controller.getProfitRate(lottoRanks);
        System.out.println(ProfitView.PROFIT_RATE.render(profitRate));
    }

    private void renderRanks(EnumMap<LottoRank, Integer> lottoRanks) {
        for (Map.Entry<LottoRank, Integer> entry : lottoRanks.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            if (rank.getMatchCount() == 0) continue;

            RankView view = RankView.getView(rank.isHasBonusNumber());
            System.out.println(view.render(rank, count));
        }
    }

}
