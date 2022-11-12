package view;

import domain.LottoNumberList;
import domain.LottoPurAmount;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String BUY = "개를 구매했습니다.";

    public static void printBuyLottoNumber(LottoPurAmount lottoPurAmount) {
        String buynumber = "";
        buynumber = lottoPurAmount.getLottopuramount().toString() + BUY;
        System.out.println(buynumber);
    }

    public void printAllLottoNumber(List<List<Integer>> lottonumberlist) {
        for(int i=0; i<lottonumberlist.size(); i++) {
            System.out.println(lottonumberlist.toString());
        }
    }
}
