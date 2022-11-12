package util;

import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class ValidateWinningLottoNumber {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER =1;
    private static final int TICKET_SIZE=6;
    static List<Integer> winningLottoTicket = new ArrayList<>();

    public static List<Integer> setWinningLottoTicket(String winningLotto) {
        String[] split = winningLotto.split(",");

        for (String number : split) {
            validateSplitNumber(number);
            winningLottoTicket.add(Integer.parseInt(number));
        }

        if(winningLottoTicket.size()!=TICKET_SIZE){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_SIZE.getMessage());
        }
        return winningLottoTicket;
    }

    public static void validateSplitNumber(String splitedNumber) {
        int convertSplitedNumber=0;
        try{
            convertSplitedNumber = Integer.parseInt(splitedNumber);
        }
        catch(Exception e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }

        if(convertSplitedNumber<MIN_NUMBER || convertSplitedNumber >MAX_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OVERRANGE.getMessage());
        }
    }


}
