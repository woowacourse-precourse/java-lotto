### 기능 구현 목록

---



- [x] 구매 금액을 입력받는 기능.　　　　　　　　　　　　　　"getMoneyForLotto"
    - [x] ‘구입금액을 입력해 주세요’ 출력 　　　　　　　　　"printMoneyForLotto"
    - [x] 구매 금액 입력 예외 사항 　　　　　　　
        - [x] 숫자가 맞는가?　　　　　　　　　　　　　　　"isItNumber"
        - [x] 1000으로 나누어 떨어지는가?　　　　　　　　"divideBy1000"
        - [x] 0 일땐 그냥 종료되는가?
        - [x] 수가 매우 클때 종료되는가?
      
<br/>


- [x] 구매 금액을 통해 로또 구매 개수를 계산하는 기능.　　　　　"countNumOfLotto"
    - [x] 로또 구매 개수를 출력한다.　　　　　　　　　　 　　　"printNumOfLotto"

<br/>

- [x] 로또 구매 개수만큼의 로또 번호를 생성하는 기능.　　　　　"generateLottoDigits"
    - [x] 6자리의 번호를 1~45 범위 내에서 선택한다.　　　　　"selectLottoDigits"
    - [x] 선택한 번호들은 중복이 없어야 한다.　　　　　　　　　"checkDuplicateInDigits"
    - [x] [ 8, 21, 23, 41, 42, 43] 의 형식으로 출력한다.　　　　"printLottoDigits"
    - [x] 만든 6개 로또를 리스트에 저장한다.　　　　　　　　　"saveLottoToBox"

<br/>

- [x] 당첨 번호를 입력받는 기능.　　　　　　　　　　　　　　　　　"getWinningNum"
    - [x] ‘당첨번호를 입력해 주세요’ 출력　　　　　　　　　　　　"printWinningLottoInput"
    - [x] 구분자(,) 를 기준으로 나누어 준다.　　　　　　　　　　　"seperateByComma"
    - [x] 당첨 번호 입력 예외 사항　　
        - [x] 구분자 ‘,’ 과 숫자가 아닌 다른 값이 있지 않은가?　　"checkInputValidity"
        - [x] 입력이 6개의 숫자가 들어왔는가?　　　　　　　　　"checkContainSix"ㄴ
        - [x] 숫자들이 1~45 내에 있는가?　　　　　　　　　　　"checkMoneyInRange"
        - [x] ',' 가 겹쳐서 들어오는 경우
<br/>

- [x] 보너스 번호를 입력받는다.　　　　　　　　　　　　　　　　　"getBonusNum"
    - [x] ‘보너스 번호를 입력해 주세요’ 출력　　　　　　　　　　　"printBonusInput"
    - [x] 보너스 번호 입력 예외 사항　
        - [x] 입력된 보너스 번호가 숫자가 맞는가?　　　　　　　"checkBonusIsNum"
        - [x] 당첨 번호에서 사용된 숫자는 아닌가?　　　　　　　"checkBonusNotInWinning"
        - [x] 보너스가 1~45 내에 있는가?
<br/>

- [x] 당첨 통계를 보여준다.　　　　　　　　　　　　　　　　　　　"showLottoResult"
    - [x] ‘당첨 통계 —- 3개 일치 (5000원)  - 1개’ 출력　　　　　　"printLottoResult"
    - [x] 로또 당첨 통계를 계산한다.　　　　　　　　　　　　　　　"calculateSameLottoNum"
    - [x] 보너스 일치 여부를 계산한다.　　　　　　　　　　　　　　"checkBonusIncluded"
    - [x] 수익률을 계산한다.　　　　　　　　　　　　　　　　　　　"calculateYieldRate"