## 🚀 기능 요구 사항

- [ ] 로또 구입 금액을 입력받는 기능 LottoShop.buyLotto
    - [ ] "구입금액을 입력해 주세요" 출력 LottoConsole.inputMoney 
    - [ ] 1000원 단위인지 확인하는 기능 LottoShop.checkMoney
        - [ ] 1000원으로 나누어 떨어지지 않는 경우 예외 처리 기능
            - [ ] IllegalArgumentException 발생, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
- [ ] 구매한 갯수만큼 로또 수량 및 번호를 출력하는 기능 LottoShop.giveLottoList
    - [ ] "%d개를 구매했습니다." 출력 LottoConsole.outputLottoList
    - [ ] 1~45 범위의 중복되지 않는 랜덤한 숫자 6개를 오름차순 정렬하여 로또 갯수만큼 출력 LottoShop.generateLottoList
        - [ ] 로또를 생성하는 기능 LottoShop.generateLotto
            - [ ] 랜덤한 숫자 6개를 생성하는 기능 LottoShop.generateRandomNumbers
            - [ ] 랜덤한 숫자 6개를 오름차순 정렬하는 기능 LottoShop.sortLottoByAsc
      - [ ] 랜덤한 숫자 6개를 로또 갯수만큼 출력하는 기능 LottoConsole.outputLottoList
- [ ] 당첨 번호와 보너스 번호를 입력받는 기능 LottoConsole.inputLuckyNumbers
    - [ ] "당첨 번호를 입력해 주세요." 출력 
    - [ ] 당첨 번호 6개를 쉼표를 기준으로 구분하여 입력받는 기능 LottoShop.userNumbers
    - [ ] 보너스 번호 1개를 입력받는 기능 
- [ ] 당첨 통계를 출력하는 기능 LottoConsole.outputResult
    - [ ] 당첨 번호, 로또 번호, 보너스 번호를 비교하여 몇개가 일치하는지 계산하는 기능 LottoCalculator.checkLuckyNumbers
- [ ] 수익률을 출력하는 기능 LottoConsole.outputProfit
    - [ ] 로또 구입 금액과 당첨 금액으로 수익률을 계산하고 소수점 둘째 자리에서 반올림하는 기능 LottoCalculator.calculateProfit
    - [ ] "총 수익률은 %f%입니다." LottoConsole.outputProfit
    
