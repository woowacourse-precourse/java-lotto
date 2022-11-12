package lotto.Service;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Application.errorContent;

public class LottoNumberService {
    public Integer receiveLottoSheetsAmount() {
        try{
            Integer lottoSheetsAmount = Integer.parseInt(Console.readLine());
            return lottoSheetsAmount;
        } catch(Exception exception){
            errorContent = " 구입 금액은 숫자여야 합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }
    public void checkDivideBy1000(Integer amount) {
        try {
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            errorContent = " 구매 금액은 1000의 배수여야합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }
    public Integer receiveLottoSheetsCount(Integer lottoSheetsAmount){
        checkDivideBy1000(lottoSheetsAmount);
        Integer lottoSheetsCount = lottoSheetsAmount / 1000;
        return lottoSheetsCount;
    }

}
