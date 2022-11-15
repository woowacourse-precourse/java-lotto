package lotto.layer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void generateLotto() {
        String inputMoney = inputView.requestMoney();
        Money money = Mapper.stringToMoney(inputMoney);
        List<Lotto> lotteries = lottoService.generateLotteries(money);
        outputView.responseBuyLotto(lotteries);
    }

    public void getStatistics() {
        String inputLotto = inputView.requestLotto();
        Lotto lotto = Mapper.stringToLotto(inputLotto);
        String inputBonusNumber = inputView.requestBonusNumber();
        LottoNumber bonusNumber = Mapper.stringToLottoNumber(inputBonusNumber);
        Map<WinningLotto, Integer> lottoFrequency = lottoService.getWinningLottoFrequency(lotto, bonusNumber);
        double benefitRate = lottoService.getBenefitRate();
        outputView.responseStatistic(lottoFrequency, benefitRate);
    }

    private static class Mapper {

        private static final String COMMA = ",";
        private static final String ERROR_NUMBER_FORMAT = "숫자 형식의 데이터를 입력해주세요.";

        private static Money stringToMoney(String money) {
            int value;
            try {
                value = Integer.parseInt(money);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
            }
            return new Money(value);
        }

        private static Lotto stringToLotto(String lotto) {
            List<Integer> temp;
            try {
                temp = Arrays.stream(lotto.split(COMMA))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
            }
            return new Lotto(temp);
        }

        private static LottoNumber stringToLottoNumber(String number) {
            int value;
            try {
                value = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
            }
            return LottoNumber.getInstance(value);
        }
    }
}
