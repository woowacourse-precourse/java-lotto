### 기능 구현 목록

---



- [ ] 구매 금액을 입력받는 기능.　　　　　　　　　　　　　　"getMoneyForLotto"
    - [ ] ‘구입금액을 입력해 주세요’ 출력 　　　　　　　　　"printMoneyForLotto"
    - [ ] 구매 금액 입력 예외 사항 　　　　　　　
        - [ ] 숫자가 맞는가?　　　　　　　　　　　　　　　"isItNumber"
        - [ ] 1000으로 나누어 떨어지는가?　　　　　　　　"divideBy1000"
      
<br/>


- [ ] 구매 금액을 통해 로또 구매 개수를 계산하는 기능.　　　　　"countNumOfLotto"
    - [ ] 로또 구매 개수를 출력한다.　　　　　　　　　　 　　　"printNumOfLotto"

<br/>

- [ ] 로또 구매 개수만큼의 로또 번호를 생성하는 기능.　　　　　"generateLottoDigits"
    - [ ] 6자리의 번호를 1~45 범위 내에서 선택한다.　　　　　"selectLottoDigits"
    - [ ] 선택한 번호들은 중복이 없어야 한다.　　　　　　　　　"checkDuplicateInDigits"
    - [ ] [ 8, 21, 23, 41, 42, 43] 의 형식으로 출력한다.　　　　"printLottoDigits"
    - [ ] 만든 6개 로또를 리스트에 저장한다.　　　　　　　　　"saveLottoToBox"

<br/>

- [ ] 당첨 번호를 입력받는 기능.　　　　　　　　　　　　　　　　　"getWinningNum"
    - [ ] ‘당첨번호를 입력해 주세요’ 출력　　　　　　　　　　　　"printWinningLottoInput"
    - [ ] 구분자(,) 를 기준으로 나누어 준다.　　　　　　　　　　　"seperateByComma"
    - [ ] 당첨 번호 입력 예외 사항　　
        - [ ] 구분자 ‘,’ 과 숫자가 아닌 다른 값이 있지 않은가?　　"checkInputValidity"
        - [ ] 입력이 6개의 숫자가 들어왔는가?　　　　　　　　　"checkContainSix"
        - [ ] 숫자들이 1~45 내에 있는가?　　　　　　　　　　　"checkMoneyInRange"

<br/>

- [ ] 보너스 번호를 입력받는다.　　　　　　　　　　　　　　　　　"getBonusNum"
    - [ ] ‘보너스 번호를 입력해 주세요’ 출력　　　　　　　　　　　"printBonusInput"
    - [ ] 보너스 번호 입력 예외 사항　
        - [ ] 입력된 보너스 번호가 숫자가 맞는가?　　　　　　　"checkBonusIsNum"
        - [ ] 당첨 번호에서 사용된 숫자는 아닌가?　　　　　　　"checkBonusNotInWinning"

<br/>

- [ ] 당첨 통계를 보여준다.　　　　　　　　　　　　　　　　　　　"showLottoResult"
    - [ ] ‘당첨 통계 —- 3개 일치 (5000원)  - 1개’ 출력　　　　　　"printLottoResult"
    - [ ] 로또 당첨 통계를 계산한다.　　　　　　　　　　　　　　　"calculateSameLottoNum"
    - [ ] 보너스 일치 여부를 계산한다.　　　　　　　　　　　　　　"checkBonusIncluded"
    - [ ] 수익률을 계산한다.　　　　　　　　　　　　　　　　　　　"calculateYieldRate"