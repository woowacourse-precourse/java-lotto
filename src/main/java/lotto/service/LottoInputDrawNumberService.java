package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.domain.lotto.repository.Lotto;

public class LottoInputDrawNumberService {
    private List<Lotto> DrawLottoNumber = new ArrayList<>();
    private Lotto lottoDrawNumber;

    private LottoInputDrawNumberService() {
    }

    private static class InnerLottoInputDrawNumberService {
        private static final LottoInputDrawNumberService instance = new LottoInputDrawNumberService();
    }

    public static LottoInputDrawNumberService getInstance() {
        return InnerLottoInputDrawNumberService.instance;
    }

    public void inputDrawNumber() {
        System.out.println(UserInterfaceMessage.REQUEST_INPUT_WINNING_NUMBER.getValue());
        saveDrawNumber(readLine());
    }

    public void saveDrawNumber(String lottoNumber) {
        validate(lottoNumber);
        validateInputNumberCount(lottoNumber);
        List<Integer> drawNumber = String2IntegerList(lottoNumber);
        lottoDrawNumber = new Lotto(drawNumber);
    }

    private List<Integer> String2IntegerList(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.replace(" ", "").strip().split(",");
        List<Integer> lottoDrawNumber =
                Arrays.stream(lottoNumbers).map(individualNumber -> Integer.parseInt(individualNumber))
                .collect(Collectors.toList());
        Collections.sort(lottoDrawNumber);
        return lottoDrawNumber;
    }

    private void validate(String lottoNumber) {
        try {
            String lottoDrawNumber = lottoNumber.replace(",", "").replace(" ","").strip();
            Integer.parseInt(lottoDrawNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                    LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
        }
    }
    private void validateInputNumberCount(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.replace(" ", "").strip().split(",");
        if (Arrays.stream(lottoNumbers).count() != LottoRule.LOTTO_MAX_COUNT.getValue()) {
            throw new IllegalArgumentException(UserInterfaceMessage.ERROR_PREFIX.getValue()
                    + String.format(UserInterfaceMessage.REQUEST_INPUT_PRICE_INFO.getValue(),
                    LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
        }
    }

    public List<Integer> getLottoDrawNumber() {
        return lottoDrawNumber.getNumbers();
    }
}
