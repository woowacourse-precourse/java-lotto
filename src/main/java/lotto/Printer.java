package lotto;


import java.util.List;

public class Printer {

    public void printUserLottoNumber(List<List<Integer>> lottoInput){

        int amountLotto = lottoInput.size();

        System.out.println(amountLotto + "개를 구매하셨습니다.");

        for(int i =0; i<amountLotto; i++){
            System.out.println(lottoInput.get(i));
        }

    }

    public void printWinList(int correctNumber){


    }

    public void printRevenue(int correctNumber){

    }

    public void printRevenuePercent(int inputMoney, int revenue) {

        double doubleInputMoney = inputMoney;
        double doubleRevenue = revenue;

        double revenuePercent = doubleRevenue/doubleInputMoney;

        System.out.println("총 수익률은 " + String.format("%.2f", revenuePercent) + "%입니다.");

    }

}
