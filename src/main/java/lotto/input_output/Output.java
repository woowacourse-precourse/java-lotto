package lotto.input_output;

/*
- [x] 구입 금액 메시지 출력<br>
  ex) 구입금액을 입력해 주세요.
- [x] 복권 구입 갯수 출력<br>
ex) 8개를 구매했습니다.
- [ ] 발행된 복권 출력<br>
ex) [8, 21, 23, 41, 42, 43]
- [x] 당첨 번호 입력 메시지 출력<br>
ex) 당첨 번호를 입력해 주세요.
- [x] 보너스 번호 입력 메시지 출력<br>
ex) 보너스 번호를 입력해 주세요.
- [ ] 당첨 결과 출력<br>
ex)<br>
당첨 통계<br>
"---"<br>
3개 일치 (5,000원) - 1개<br>
4개 일치 (50,000원) - 0개<br>
5개 일치 (1,500,000원) - 0개<br>
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개<br>
6개 일치 (2,000,000,000원) - 0개<br>
- [ ] 수익률 출력 출력<br>
ex) 총 수익률은 62.5%입니다.
- [ ] 오류 메시지 출력(다수)<br>
ex) [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 한다.

 */
public class Output {

    private enum Print{
        BUY_LOTTERY("구입금액을 입력해 주세요"),
        PRINT_BUY_LOTTERY("%d개를 구매했습니다."),
        PRINT_LOTTERY(""),  //TODO: 추후 수정
        WIN_LOTTERY_NUMBER("당첨 번호를 입력해 주세요."),
        BOUNNS_LOTTERY_NUMBER("보너스 번호를 입력해 주세요."),
        PRINT_RESULT("당첨 통계%n"); //TODO: 추후 수정

        private String output;
        public String getOutput(){
            return output;
        }
        private Print(String output){
            this.output = output;
        }

    }


}
