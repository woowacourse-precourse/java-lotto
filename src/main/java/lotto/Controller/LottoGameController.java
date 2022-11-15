package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Console.InputMessages;
import lotto.Console.OutputMessages;
import lotto.Domain.Lotto;
import lotto.Service.LottoGameService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    Lotto lotto;
    LottoGameService lottoGameService = new LottoGameService();
    public List<List<Integer>> lottoList=new ArrayList<>();
    public List<Integer> countEqualNumberList = new ArrayList<>();
    public String inputCash;
    int third = 0;
    int fifth = 0;
    int fourth = 0;
    int second = 0;
    int first = 0;
    DecimalFormat df = new DecimalFormat("0.0");

    public void LottoSystem(InputMessages inputMessages, OutputMessages outputMessages) {
        setRandomList(inputMessages, outputMessages);
        setEnterLotto(inputMessages, outputMessages);
        countEnterNum(getBonusNum(inputMessages, outputMessages));
        printResult(outputMessages);
    }

    public String getInputNumber(InputMessages inputMessages, OutputMessages outputMessages) {
        outputMessages.inputMoneyMsg();
        String cash = inputMessages.readLine();
        isCashInt(cash, outputMessages);

        return cash;
    }

    public int calculateCount(String input) {
        lottoGameService.isValidCash(Integer.parseInt(input));
        return Math.floorDiv(Integer.parseInt(input), 1000);
    }

    public int CountEnter(InputMessages inputMessages, OutputMessages outputMessages) {
        inputCash = getInputNumber(inputMessages, outputMessages);
        outputMessages.countEnterMsg(calculateCount(inputCash));

        return calculateCount(inputCash);
    }

    public List<Integer> getRandomNumList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void setRandomList(InputMessages inputMessages, OutputMessages outputMessages) {
        int count = CountEnter(inputMessages, outputMessages);
        for (int i=0; i<count; i++) {
            List<Integer> list = getRandomNumList();
            lottoList.add(i, list);
            outputMessages.printLottoList(lottoList.get(i));
        }
    }

    public void setEnterLotto(InputMessages inputMessages, OutputMessages outputMessages) {
        List<Integer> winNumList = getWinNumList(inputMessages, outputMessages);

        lotto = new Lotto(winNumList);
    }

    public List<Integer> getWinNumList(InputMessages inputMessages, OutputMessages outputMessages) {
        outputMessages.winNumInputMsg();
        String[] inputList = inputMessages.readLineAsArray();
        List<Integer> inputNumbers = new ArrayList<>();
        for (String inputs: inputList) {
            inputNumbers.add(Integer.parseInt(inputs));
        }

        return inputNumbers;
    }

    public Integer getBonusNum(InputMessages inputMessages, OutputMessages outputMessages) {
        outputMessages.bonusNumInputMsg();
        int bonusNumber = Integer.parseInt(inputMessages.readLine());
        lotto.isValidNumber(bonusNumber);

        return bonusNumber;
    }

    public void countEnterNum(int bonusNum) {
        for (int i=0; i<lottoList.size(); i++) {
            int countNum = 0;
            countCorrectNumbers(countNum, i, bonusNum);
        }
    }

    public void countCorrectNumbers(int countNum, int index, int bonusNum) {
        int count = lotto.countCorrectNums(lottoList, countNum, index);
        countEqualNumberList.add(count);
        setRank(index, bonusNum);
    }

    public void setRank(int index, int bonusNum) {
        for (Integer countNums: countEqualNumberList) {
            if (countNums == 3) {
                fifth++;
            }
            if (countNums == 4) {
                fourth++;
            }
            if (countNums==5 && !lottoList.get(index).contains(bonusNum)) {
                third++;
            }
            if (countNums==5 && lottoList.get(index).contains(bonusNum)) {
                second++;
            }
            if (countNums == 6) {
                first++;
            }
        }
    }

    public void printResult(OutputMessages outputMessages) {
        int prize = 0;
        prize = 5000*fifth + 50000*fourth + 1500000*third + 30000000*second + 2000000000*first;

        String earningRate = df.format(((double) prize/(double) Integer.parseInt(inputCash))*100.0);

        outputMessages.totalResultMsg(fifth, fourth, third, second, first, earningRate);
    }

    public void isCashInt(String cash, OutputMessages outputMessages) {
        if(!cash.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println(outputMessages.CashIsNotInt());
            LottoSystem(new InputMessages(), outputMessages);
        }
    }


}

enum rankType {
    FIFTH,
    FOURTH,
    THIRD,
    SECOND,
    FIRST;
}
