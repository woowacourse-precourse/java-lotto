package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoPurAmount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class InputController {
    private final int DIVIDEPRICE = 1000;
    private final int LOTTONUMBERQUANTITY = 6;
    private final int MINLOTTOVALUE = 1;
    private final int MAXLOTTOVALUE = 45;

    InputValidator inputValidator = new InputValidator();

    public Integer insertLottoAmount() {
        String stringpuramount = Console.readLine();
        Integer lottopuramount = Integer.parseInt(stringpuramount);
        inputValidator.checkDigitPrice(stringpuramount);
        inputValidator.checkDividePrice(lottopuramount);
        return lottopuramount;
    }

    public List<List<Integer>> makeLottoNumberList(LottoPurAmount lottoPurAmount) {
        List<List<Integer>> makeLottoNumberList = new ArrayList<>();
        for(int i=0; i<lottoPurAmount.getLottopuramount()/DIVIDEPRICE; i++) {
            List<Integer> lottonumber = new ArrayList<>();
            lottonumber = makeLottoNumber();
            makeLottoNumberList.add(lottonumber);
        }
        return makeLottoNumberList;
    }

    public List<Integer> makeLottoNumber() {
        List<Integer> lottonumber = new ArrayList<>();
        lottonumber = Randoms.pickUniqueNumbersInRange(MINLOTTOVALUE, MAXLOTTOVALUE, LOTTONUMBERQUANTITY);
        lottonumber.sort(Comparator.naturalOrder());
        return lottonumber;
    }


}