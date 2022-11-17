package lotto.view;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Integer> lottoNumbers = new ArrayList<>();
        try {
            lottoNumbers = stringToList(UserInputUtils.readLine());
        } catch (Exception exception) {
            OutputView.printException(new IllegalArgumentException("입력 형식은 숫자,숫자,숫자, ... 입니다"));
        }
        return new LottoRequest(lottoNumbers);
    }

    private static List<Integer> stringToList(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static LottoNumberRequest inputBonusNumber() {
        OutputUtils.outputLine("보너스 번호를 입력해 주세요.");
        String bonusNumber = UserInputUtils.readLine();
        validate(bonusNumber);
        return new LottoNumberRequest(Integer.parseInt(bonusNumber));
    }

    private static void validate(String input) {
        if (!Pattern.matches(INPUT_TYPE, input)) {
            throw new IllegalArgumentException("입력 타입은 숫자이여야 합니다.");
        }
    }
}
