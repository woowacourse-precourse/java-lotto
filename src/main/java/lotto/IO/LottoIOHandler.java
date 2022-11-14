package lotto.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoIOHandler extends IOHandler {
    // 로또 당첨 번호를 입력한다.
    public List<Integer> getLottoAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        validateInput(getUserInput());
        List<Integer> answer = convertStringToIntList(input);
        return answer;
    }

    // "~,~" 형식의 문자열을 리스트로 변환한다.
    public List<Integer> convertStringToIntList(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] num = input.split(",");
        for(int i=0;i<num.length;i++){
            numbers.add(Integer.parseInt(num[i]));
        }
        return numbers;
    }

    // 사용자가 ","구분자 없이 입력한 경우:
    // 4[0-6]or[1-3][0-9]or[0-9]가 5번 반복 이후 4[0-6]or[1-3][0-9]or[0-9] 오는지 확인
    @Override
    public void validateInput(String input) {
        Pattern pass = Pattern.compile("^(?:4[0-5][,]|[1-3][0-9][,]|[1-9][,]){5}(?:[4][0-6]|[1-3][0-9]|[1-9])$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] \',\' 구분자를 통해 1~45사이의 수 6개를 입력해주세요");
        }
    }

    public void printStatistics(double rate){
        List<Integer> result = new ArrayList<>();
        rate = (double)Math.round(rate*100)/100;
        System.out.println("3개 일치 (5,000원) - "+1+"개\n"+
                "4개 일치 (50,000원) - "+0+"개\n"+
                "5개 일치 (1,500,000원) - "+1+"개\n"+
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+2+"개\n"+
                "6개 일치 (2,000,000,000원) - "+3+"개\n"+
                "총 수익률은 "+String.format("%2.f",rate)+"입니다.");
    }
}
