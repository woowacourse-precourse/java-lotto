package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoPurAmount;
import util.Constant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class InputController {

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
        for(int i=0; i<lottoPurAmount.getLottopuramount()/Constant.DIVIDEPRICE; i++) {
            List<Integer> lottonumber = new ArrayList<>();
            lottonumber = makeLottoNumber();
            makeLottoNumberList.add(lottonumber);
        }
        return makeLottoNumberList;
    }

    public List<Integer> makeLottoNumber() {
        List<Integer> lottonumber = new ArrayList<>();
        lottonumber = Randoms.pickUniqueNumbersInRange(Constant.MINLOTTOVALUE, Constant.MAXLOTTOVALUE, Constant.LOTTONUMBERQUANTITY);
        lottonumber.sort(Comparator.naturalOrder());
        return lottonumber;
    }

    public List<Integer> insertLottoNumber() {
        List<Integer> lottonumber = new ArrayList<>();
        String strlottonumber = Console.readLine();
        int numberidx = 0;
        inputValidator.checkDigitNumber(strlottonumber);
        for(int i=0; i<strlottonumber.length(); i++) {
            if(strlottonumber.charAt(i) == ',') {
                lottonumber.add(StringToIntNumber(strlottonumber,numberidx,i));
                numberidx = i+1;
            }
        }
        lottonumber.add(StringToIntNumber(strlottonumber,numberidx,strlottonumber.length()));
        inputValidator.checkWinNumber(lottonumber);

        return lottonumber;
    }

    public int StringToIntNumber(String strlottonumber,int firstidx,int lastidx) {
        int resultnumber;
        resultnumber = Integer.parseInt(strlottonumber.substring(firstidx,lastidx));
        return resultnumber;
    }

}