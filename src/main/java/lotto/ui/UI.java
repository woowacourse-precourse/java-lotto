package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utility.Exception;

public class UI {
    private final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final String NUMBER_OF_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";

    private final String WINNING_INFO_MESSAGE_0 = "당첨 통계\n---";
    private final String WINNING_INFO_MESSAGE_1 = "3개 일치 (5,000원) - %d개";
    private final String WINNING_INFO_MESSAGE_2 = "4개 일치 (50,000원) - %d개";
    private final String WINNING_INFO_MESSAGE_3 = "5개 일치 (1,500,000원) - %d개";
    private final String WINNING_INFO_MESSAGE_4 = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private final String WINNING_INFO_MESSAGE_5 = "6개 일치 (2,000,000,000원) - %d개";

    private final String EARNNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private String input(){
        return Console.readLine();
    }

    private void output(String message){
        System.out.println(message);
    }

    private void stringSplitWithCheckException(List<Integer> winningNumbers){
        List<String> winningNumberStrings = new ArrayList<>(Arrays.asList(input().split(",")));
        for(String numberString : winningNumberStrings){
            try{Exception.checkInputIsNum(numberString);}
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                winningNumbers.clear();
                stringSplitWithCheckException(winningNumbers);
            }
            int winningNumber = Integer.valueOf(numberString);
            try{Exception.checkWinningNumberRange(winningNumber);}
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                winningNumbers.clear();
                stringSplitWithCheckException(winningNumbers);
            }
            winningNumbers.add(winningNumber);
        }
    }
    
    public int inputPurchasePrice(){
        output(INPUT_PURCHASE_PRICE_MESSAGE);
        String priceString = input();
        try{Exception.checkInputIsNum(priceString);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchasePrice();
        }
        int price = Integer.parseInt(priceString);
        try{Exception.checkPriceCanDivide(price);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchasePrice();
        }
        return price;
    }

    public List<Integer> inputWinningNumbers(){
        output(INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumbers = new ArrayList<>(6);
        stringSplitWithCheckException(winningNumbers);
        try{Exception.checkNumberOfNumbers(winningNumbers);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
        try{Exception.checkDuplicateNumber(winningNumbers);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
        return winningNumbers;
    }

    public int inputBonusNumber(){
        output(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumberString = input();
        try{Exception.checkInputIsNum(bonusNumberString);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
        int bonusNumber = Integer.valueOf(bonusNumberString);
        try{Exception.checkWinningNumberRange(bonusNumber);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
        return bonusNumber;
    }

    public void outputPurchaseLotto(List<Lotto> lottos){
        output(String.format(NUMBER_OF_PURCHASE_LOTTO_MESSAGE, lottos.size()));
        for(Lotto lotto : lottos){
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            List<Integer> lottoNumbers = new ArrayList<>(6);
            lottoNumbers.addAll(lotto.getNumbers());
            lottoNumbers.sort(Comparator.naturalOrder());
            for(int numberIndex = 0; numberIndex < 6; ++numberIndex){
                sb.append(String.valueOf(lottoNumbers.get(numberIndex)));
                if(numberIndex < 5) sb.append(", ");
            }
            sb.append(']');
            output(sb.toString());
        }
    }

    public void outputWinningInfo(List<Integer> numberOfWinningLottos){
        output(WINNING_INFO_MESSAGE_0);
        output(String.format(WINNING_INFO_MESSAGE_1,numberOfWinningLottos.get(0)));
        output(String.format(WINNING_INFO_MESSAGE_2,numberOfWinningLottos.get(1)));
        output(String.format(WINNING_INFO_MESSAGE_3,numberOfWinningLottos.get(2)));
        output(String.format(WINNING_INFO_MESSAGE_4,numberOfWinningLottos.get(3)));
        output(String.format(WINNING_INFO_MESSAGE_5,numberOfWinningLottos.get(4)));
    }

    public void outputEarningRate(double earningRate){
        output(String.format(EARNNING_RATE_MESSAGE, earningRate));
    }
}
