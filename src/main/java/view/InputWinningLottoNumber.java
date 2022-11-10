package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class InputWinningLottoNumber {

    public static void inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String Lotto = Console.readLine();
        List<Integer> lottoList = setLotto(Lotto);
        Lotto lotto = new Lotto(lottoList);
    }

    private static List<Integer> setLotto(String Lotto) {
        String[] split = Lotto.split(",");
        System.out.println("split = " + split);

        List<Integer> lottoList = new ArrayList<>();
        for (String s : split) {
            validateSplitNumber(s);
            lottoList.add(Integer.parseInt(s));
        }

        if(lottoList.size()!=6){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_SIZE.getMessage());
        }
        return lottoList;
    }

    public static void validateSplitNumber(String splitedNumber) {
        int convertSplitedNumber=0;
        try{
            convertSplitedNumber = Integer.parseInt(splitedNumber);
        }
        catch(Exception e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }

        if(convertSplitedNumber<1 || convertSplitedNumber >45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OVERRANGE.getMessage());
        }
    }

}
