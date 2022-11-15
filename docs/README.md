## 기능목록

### 1. 주기능

| 기능이름 | 기능 세부사항 | 
|:---:|---|
|Lotto|로또|
|Lotto.isValidList| 주어진 번호 리스트가 로또 번호를 생성하기에 적합한 리스트가 아니면 예외 발생|
|LottoeryStore|로또의 판매처|
|LottoeryStore.purchaseLotteries|로또를 금액에 맡게 발행|
|LotteryHostAgency.setDrawalNumbers| 당첨번호와 보너스 번호를 설정|
|LotteryHostAgency.getResult|당첨 번호에 대한 결과를 반환|
|LotteryHostAgency.WinningCriteria|당첨기준|
|LotteryHostAgency.WinningCriteria.amount|당첨 등수에 따른 당첨금액|
|LotteryHostAgency.WinningCriteria.matches|당첨 등수에 대한|
|Application.getEarningsRate|수익률 계산|
|Application.purchaseLotteries|구입금액 입력값을 받아 해당 수 만큼 Lotto 객체를 생성|
|Application.getInputWinningNumbers|당첨번호 입력값을 받아 당첨번호 리스트를 반환|
|Application.getInputBonusNumber|보너스번호 입력값을 받아 반환|
|Application.printWiningStats|당첨 통계를 출력|

### 2. 보조기능

| 기능이름 | 기능 세부사항 |  종속 기능 |
|:---:|---| --- |
|Lotto.isBetween1And45| 주어진 수가 0과 45사이에 속하는지 출력 | Lotto.isValidList |
|Lotto.contiansOnce| 주어진 리스트에 주어진 수가 1번만 포함되어 있는지 출력 | Lotto.isValidList |
|LotteryHostAgency.setWinningNumbers| 당첨 번호를 설정 | LotteryHostAgency.setDrawalNumbers |
|LotteryHostAgency.setBonusNumber| 보너스 번호를 설정| LotteryHostAgency.setDrawalNumbers|
|Application.validateInputAmountString|입력된 구입 금액 입력값을 검증|Application.purchaseLotteries |
|Application.validateInputWinningNumbersString|입력한 당첨 번호 입력값을 검증| Application.getInputWinningNumbers|
|Application.validateInputBonusNumberString|입력한 보너스 번호의 입력값 검증| Application.getInputBonusNumber|
|Application.printResults|결과를 주어진 형식으로 출력| Application.printWiningStats|
|Application.printEarningRate|수익률을 출력| Application.printWiningStats|
|Application.printOneResultByWinningCriteria|한 당첨등수에 해당하는 당첨내역 및 금액을 출력|Application.printResults|

### 3. Application 상태    

| 기능이름 | 기능 세부사항 |
|:---:|---|
|Application.amount|구매금액|
|Application.totalOutcome|총 금액|
|Application.lottories|구입한 로또|
|Application.results|구입한 로또의 당첨 결과|



