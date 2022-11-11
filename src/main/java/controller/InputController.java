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

    public Integer insertLottoAmount() {
        String stringpuramount = Console.readLine();
        Integer lottopuramount = Integer.parseInt(stringpuramount);
        checkDigitPrice(stringpuramount);
        checkDevidePrice(lottopuramount);
        return lottopuramount;
    }

    public void checkDigitPrice(String lottopuramount) {
        for(int i=0; i<lottopuramount.length(); i++) {
            if(!Character.isDigit(lottopuramount.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
            }
        }
    }

    public void checkDevidePrice(Integer lottopuramount) {
        if(lottopuramount % DIVIDEPRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원 단위로 나누어 떨어지지 않습니다.");
        }
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
        lottonumber = Randoms.pickUniqueNumbersInRange(MINLOTTOVALUE, MAXLOTTOVALUE,LOTTONUMBERQUANTITY);
        lottonumber.sort(Comparator.naturalOrder());
        return lottonumber;
    }

    public void checkNumberQuantity(String lottonumber) {
        if(lottonumber.length() != LOTTONUMBERQUANTITY) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
    }


}