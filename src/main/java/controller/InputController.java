package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import util.Constant;
import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputController {

    InputValidator inputValidator = new InputValidator();

    public Integer insertLottoAmount() {
        InputView.printLottoPrice();
        String stringpuramount = Console.readLine();
        inputValidator.checkDigitPrice(stringpuramount);
        Integer lottopuramount = Integer.parseInt(stringpuramount);

        inputValidator.checkDividePrice(lottopuramount);
        return lottopuramount;
    }

    public List<Lotto> makeLottoNumberList(int lottoPurAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers = makeLottoNumber(lottoPurAmount);
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
        List<Integer> lottonumber = new ArrayList<>();
        String strlottonumber = Console.readLine();
        inputValidator.checkDigitNumber(strlottonumber);

        String[] numbers = strlottonumber.split(",");
        lottonumber = StringToIntNumber(numbers);
        inputValidator.checkWinNumber(lottonumber);

        return lottonumber;
    }

    public List<Integer> StringToIntNumber(String strlottonumber[]) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<strlottonumber.length; i++) {
            numbers.add(Integer.parseInt(strlottonumber[i]));
        }
        return numbers;
    }

}