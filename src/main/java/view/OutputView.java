package view;

import domain.LottoNumberList;
import domain.LottoPurAmount;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String BUY = "개를 구매했습니다.";

    public static void printBuyLottoNumber(LottoPurAmount lottoPurAmount) {
        String buynumber = "";
        int divideprice = lottoPurAmount.getLottopuramount()/1000;
        buynumber = divideprice + BUY;
        System.out.println("\n" + buynumber);
    }

    public static void printAllLottoNumber(List<List<Integer>> lottonumberlist) {
        for(int i=0; i<lottonumberlist.size(); i++) {
            System.out.println(lottonumberlist.get(i).toString());
        }
    }
}
