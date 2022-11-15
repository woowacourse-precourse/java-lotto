package lotto;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;

//UI(입출력)을 담당하는 클래스
public class LottoGame {

    public void readWinningLottoNumbersAndBonusNumber() {
        String winningNumbersString = Console.readLine();
        String bonusNumberString = Console.readLine();
        List<Integer> winningNumbers = parseWinningLottoNumbers(winningNumbersString);
        Integer bonusNumber = parseBonusNumber(bonusNumberString);

        validateWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
    }

    //입력받은 당첨 번호 문자열을 파싱하는 함수
    public List<Integer> parseWinningLottoNumbers(String winningNumbers) {
        StringTokenizer st = new StringTokenizer(winningNumbers, ",");
        List<Integer> winningNumbersRet = new LinkedList<>();
        while (st.hasMoreElements()) {
            Integer val;
            try {
                val = Integer.parseInt(st.nextToken());
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 사용자 당첨번호 입력 오류");
            }
            winningNumbersRet.add(val);
        }

        return winningNumbersRet;
    }

    //보너스 번호를 파싱하는 함수
    public Integer parseBonusNumber(String bonusNumberString){
        Integer bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberString);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력 오류입니다.");
        }
        return bonusNumber;
    }

    //입력받은 로또 번호와 보너스 번호를 검증하는 함수
    public void validateWinningNumbersAndBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        //로또 번호는 로또 생성자를 이용해 검증한다.
        Lotto validatedWinningNumbers = new Lotto(winningNumbers);

        //보너스 번호는 로또 번호와 중복되는 경우, 1-45이내의 숫자가 아닌 경우 예외를 던진다.
        if (winningNumbers.contains(bonusNumber) || (!(1 <= bonusNumber && bonusNumber <= 45))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 중복인 로또 번호가 있거나 1-45이내의 숫자가 아닙니다.");
        }
    }
}
