package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.WinningNumber;
import lotto.Lotto;
import util.InputValidator;
import view.InputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputController {

    InputValidator inputValidator = new InputValidator();

    public Integer insertLottoAmount() {
        InputView.printLottoPrice();
        String purAmount = Console.readLine();
        inputValidator.checkDigitPrice(purAmount);
        Integer lottoPurAmount = Integer.parseInt(purAmount);

        inputValidator.checkDividePrice(lottoPurAmount);
        return lottoPurAmount;
    }

    public List<Lotto> makeLottoNumberList(int lottoPurAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>(makeLottoNumber(lottoPurAmount));
        return lottoNumbers;
    }

    public List<Lotto> makeLottoNumber(int lottoPurAmount) {
        int lottoNumbers = lottoPurAmount / 1000;
        return IntStream.range(0, lottoNumbers)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)).map(Lotto::new)
                .collect(Collectors.toList());
    }

    public List<Integer> insertLottoNumber() {
        InputView.printInputLottoNumber();
        String remNumber = Console.readLine();
        inputValidator.checkDigitNumber(remNumber);

        String[] numbers = remNumber.split(",");
        List<Integer> lottoNumber = new ArrayList<>(StringToIntNumber(numbers));
        inputValidator.checkWinNumber(lottoNumber);

        return lottoNumber;
    }

    public int insertBonusNumber(WinningNumber winningNumber) {
        String bonusNumber = Console.readLine();
        inputValidator.checkBonusNumber(bonusNumber, winningNumber);

        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> StringToIntNumber(String[] strLottoNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : strLottoNumber) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

}