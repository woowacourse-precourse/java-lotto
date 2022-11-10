package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    static final int UNIT = 1000;
    static final int LOTTO_LEN = 6;
    static final int LOTTO_MAX_SIZE = 45;
    static final int LOTTO_MIN_SIZE = 1;

    private int userMoney = 0;
    private int resultMoney = 0;
    private int numOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void readMoney(){
        int inputMoney = Integer.parseInt(readLine());
        validataInputNumber(inputMoney);
        userMoney = inputMoney;
    }

    public void validataInputNumber(int inputMoney) {
        if(inputMoney%UNIT != 0){
            System.out.println("[ERROR] 금액은 1000원 단위로 나뉘어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> readLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumber = readLine();
        validataInputLottoNumber(inputLottoNumber);
        return convertLottoNumber(inputLottoNumber);
    }

    public int readBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = readLine();
        validataBonusNumber(bonus);
        return Integer.parseInt(bonus);
    }

    public int validataBonusNumber(String bonus) {
        // 포맷이 잘못된 경우 or 범위가 초과하는 경우
        int bonusNum = 0;
        try{
            bonusNum = Integer.parseInt(bonus);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 보너스 번호 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }

        if(bonusNum > LOTTO_MAX_SIZE || bonusNum < LOTTO_MIN_SIZE){
            System.out.println("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
            throw new IllegalArgumentException();
        }
        return bonusNum;
    }

    public void addLotto(List<Integer> lottoNumber, int bonusNumber){
        lottoNumber.add(bonusNumber);
        lottos.add(new Lotto(lottoNumber));
    }

    public List<Integer> convertLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        return split.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public void validataInputLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        unValidShape(split);

        List<Integer> lottoNumber = convertLottoNumber(inputLottoNumber);
        duplicatedNumber(lottoNumber);
        checkNumberArea(lottoNumber);
    }

    public void unValidShape(ArrayList<String> lottoNumber){
        if(lottoNumber.size() != LOTTO_LEN){
            System.out.println("[ERROR] 숫자 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void duplicatedNumber(List<Integer> lottoNumber) {
        List<Integer> collect = lottoNumber.stream().distinct().collect(Collectors.toList());
        if(collect.size() != LOTTO_LEN){
            System.out.println("[ERROR] 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }

    }

    public void checkNumberArea(List<Integer> lottoNumber){
        for (Integer integer : lottoNumber) {
            if(integer > LOTTO_MAX_SIZE || integer < LOTTO_MIN_SIZE){
                System.out.println("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void showLottos(){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void setNumOfLotto(){
        if(userMoney != 0){
            numOfLotto = userMoney/UNIT;
        }
    }
}
