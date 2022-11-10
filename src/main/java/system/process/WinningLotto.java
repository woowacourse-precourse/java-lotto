package system.process;

import models.WinningLottoData;
import utils.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private WinningLottoData winningLottoData;

    public WinningLotto() {
        this.winningLottoData = createWinningLottoData();
    }

    private WinningLottoData createWinningLottoData() {

        List<Integer> lottoNumbers = inputSixLottoNumbers();
        int bonusNumber = inputBonusNumber();

        return new WinningLottoData(lottoNumbers, bonusNumber);

    }

    //TODO : 수정할 것. 예외처리 추가하고 코드 간소화 진행
    private List<Integer> inputSixLottoNumbers() {

        System.out.println("당첨 번호를 입력해 주세요.");

        String numbersInput = Input.input();

        String[] strNumbers = numbersInput.split(",");

        int[] arr = Arrays.stream(strNumbers).mapToInt(Integer::parseInt).toArray(); // 120937182039,902380192830192 이런식이면 여기서 예외처리가 뜰 것임.

        List<Integer> numbers = new ArrayList<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));

        return numbers;
    }

    //TODO : 수정할 것. 코드 간소화 진행.
    private  int inputBonusNumber(){

        System.out.println("보너스 번호를 입력해 주세요.");

        String numberInput = Input.input();

        if(numberInput.length() > 2 || numberInput.length() < 0){
            throw new IllegalArgumentException("[ERROR] 번호는 1자리나 2자리이어야 합니다.");
        }

        if (numberInput.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 올바르게 번호 하나를 입력해주세요.");
        }

        int number = Integer.parseInt(numberInput);

        if(number < 1 ||  number > 45){
            throw new IllegalArgumentException("[ERROR] 범위가 1~45의 숫자가 아닙니다.");
        }

        return number;
    }

    public WinningLottoData getWinningLottoData() {
        return winningLottoData;
    }
}
