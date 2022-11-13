package lotto.view;

import java.util.regex.Pattern;
import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;
import lotto.domain.model.request.MoneyRequest;
import lotto.view.utils.OutputUtils;
import lotto.view.utils.UserInputUtils;

public final class InputView {

    private static final String INPUT_TYPE = "^[0-9]*$";

    private InputView() {
    }

    public static MoneyRequest inputLotteryPurchaseAmount() {
        OutputUtils.outputLine("구입금액을 입력해 주세요");
        String input = UserInputUtils.readLine();
        validate(input);
        return new MoneyRequest(Integer.parseInt(input));
    }

    public static LottoRequest inputLottoNumbers() {
        OutputUtils.outputLine("당첨 번호를 입력해 주세요.");
        String lottoNumbers = UserInputUtils.readLine();
        return new LottoRequest(lottoNumbers);
    }

    public static LottoNumberRequest inputBonusNumber() {
        OutputUtils.outputLine("보너스 번호를 입력해 주세요.");
        String bonusNumber = UserInputUtils.readLine();
        validate(bonusNumber);
        return new LottoNumberRequest(Integer.parseInt(bonusNumber));
    }

    private static void validate(String input) {
        if (!Pattern.matches(INPUT_TYPE, input)) {
            OutputView.printException(new IllegalArgumentException("입력 타입은 숫자이여야 합니다."));
        }
    }
}
