package controller;
import domain.MatchingNumber;
import lotto.Lotto;
import util.WinNum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputController {
    public HashMap<String,Integer> matchingNumber(List<Lotto> lottos, List<Integer> lottoAnswer, int bonusNumber) {
        HashMap<String,Integer> correctnumber = new HashMap<>();
        initHashmap(correctnumber);

        for (Lotto lotto : lottos) {
            String matchingNumber;
            matchingNumber = calMatchingNumber(lotto.getLotto(), lottoAnswer, bonusNumber);
            int eachNum = correctnumber.get(matchingNumber);
            correctnumber.put(matchingNumber, eachNum + 1);
        }
        return correctnumber;
    }

    public void initHashmap(HashMap<String,Integer> correctNumber) {
        WinNum[] values = WinNum.values();
        for (WinNum value : values) {
            correctNumber.put(value.toString(), 0);
        }
    }

    public String calMatchingNumber(List<Integer> lottoNumber, List<Integer> lottoAnswer,int bonusNumber) {
        String correctNumber;
        List<Integer> remLottoNum = new ArrayList<>(lottoNumber);
        List<Integer> remLottoAns = new ArrayList<>(lottoAnswer);
        remLottoNum.retainAll(remLottoAns);

        correctNumber = numToString(remLottoNum.size());
        if(remLottoNum.size() == 5 && remLottoNum.contains(bonusNumber)) {
            correctNumber = WinNum.Bonus.toString();
        }
        return correctNumber;
    }

    public String numToString(int number) {
        switch (number) {
            case 3: return WinNum.Three.toString();
            case 4: return WinNum.Four.toString();
            case 5: return WinNum.Five.toString();
            case 6: return WinNum.Six.toString();
        }
        return WinNum.Nothing.toString();
    }

    public int winningAmount(MatchingNumber matchingNumber) {
        int price = 0;
        WinNum[] values = WinNum.values();
        HashMap<String,Integer> matchingNumbers = matchingNumber.getMatchingNumber();

        for (WinNum value : values) {
            String money = WinNum.valueOf(value.toString()).label();
            int winNumber = matchingNumbers.get(value.toString());
            price += Integer.parseInt(money) * winNumber;
        }
        return price;
    }
}