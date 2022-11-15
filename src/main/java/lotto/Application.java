package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Application main = new Application();
        Rank rank = new Rank();

        System.out.println(Message.START_MESSAGE);
        int price = main.checkNum(main.userInputNumber());
        int lottoNum = main.checkPrice(price);

        System.out.println(lottoNum + Message.LOTTOSIZE_MESSAGE);
        List<List<Integer>> myLottoArr = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            myLottoArr.add(main.lottoArr());
            System.out.println(myLottoArr.get(i));
        }

        System.out.println(Message.WINNINGNUM_MESSAGE);
        List numbers = main.winningNums(main.userInputNumber());
        Lotto lotto = new Lotto(numbers);

        System.out.println(Message.BONUSNUM_MESSAGE);
        int bonusNum = main.checkLottoNum(main.checkNum(main.userInputNumber()));

        for (List<Integer> buyLotto : myLottoArr) {
            rank.compareNum(buyLotto, lotto, bonusNum);
        }

        int[] ranks = rank.getRanks();

        System.out.printf(Message.OUTPUT_MESSAGE, ranks[4], ranks[3], ranks[2], ranks[1], ranks[0]);
        System.out.printf(Message.PERCENT_MESSAGE, main.ratePercent(ranks, price));
    }
    public String userInputNumber() {
        return Console.readLine();
    }

    public int checkNum(String userInputNumber) {
        try {
            return Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE + Message.ERROR_CHECKNUM);
        }
    }

    public int checkPrice(int price){
        if (0 < price % 1000 && price % 1000 < 1000){
            throw new IllegalArgumentException(Message.ERROR_MESSAGE + Message.ERROR_CHECKPRICE);
        }
        return price / 1000;
    }

//    public List<List<Integer>> lottoArr(int lottoNum) {
//        List<Integer> myLotto;
//        List<List<Integer>> myLottoArr = new ArrayList<>();
//        for (int i = 0; i < lottoNum; i++) {
//            myLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
////            Collections.sort(myLotto);
//            myLottoArr.add(myLotto);
//        }
//        for (int i = 0; i < myLottoArr.size(); i++) {
//            Collections.sort(myLottoArr.get(i));
//            System.out.println(myLottoArr.get(i));
//        }
//        return myLottoArr;
//    }

    public List<Integer> lottoArr(){
        List<Integer> myLotto = new ArrayList<>();
        myLotto  = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        Collections.sort(myLotto);
        return myLotto;
    }
    public List<Integer> winningNums(String userInputNumber){
        List<Integer> winningLottoNums = new ArrayList<>();
        for (String splitInput : userInputNumber.split(",")) {
            int stringToInt = checkLottoNum(checkNum(splitInput));
            winningLottoNums.add(stringToInt);
        }
        winningLottoNums.sort(Comparator.naturalOrder());
        checkUniqueWinningNums(winningLottoNums);
        return winningLottoNums;
    }

    public void checkUniqueWinningNums(List winningLottoNums){
        if(winningLottoNums.size() != winningLottoNums.stream().distinct().count()){
            throw new IllegalArgumentException(Message.ERROR_MESSAGE + Message.ERROR_UNIQUENUM);
        }
    }

    public int checkLottoNum(int lottoNum) {
        if (0 >= lottoNum || lottoNum > 45) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE + Message.ERROR_CHECKLOTTONUM);
        }
        return lottoNum;
    }

    public double ratePercent(int[] ranks, int price){
        long[] benefit = {2000000000, 30000000, 1500000, 50000, 5000};
        long totalBenefit = 0;
        for (int i = 0; i < benefit.length; i++) {
            totalBenefit += ranks[i]*benefit[i];
        }
        return (double) totalBenefit / price *100;
    }
}
