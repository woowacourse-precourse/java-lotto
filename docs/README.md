# 기능 구현 목록

## 로또 기능
- - -
- [x] 로또 발행 : 1~45에서 중복되지 않는 6개의 숫자를 뽑는다. - Generator#createRandomLotto
  - [x] 구매한 로또의 목록을 오름차순으로 출력한다.
  - [x] 로또 발행 : 구입 금액(장당 1000원)에 해당하는 만큼 로또를 발행한다. - Generator#createLottoByPay
- [x] 당첨된 로또들의 수익금을 합한다. - Calculator#sumJackpot
  - [x] 수익률 통계는 소수점 둘째 자리에서 반올림한다. - Calculator#calculateEarningRate
- [x] 만들어진 로또와 입력한 로또가 일치하는지 비교한다 - Judgement#rankLotto
  - [x] 5개 일치의 경우, 보너스 번호가 일치하는지 비교한다 - Judgement#secondPrize
  - [x] 발행한 로또들의 당첨 갯수를 리스트에 저장한다 - Judgement#makeWinnigTable
  - [x] 당첨 갯수에 따른 당첨 등수를 저장한다 - Output#createMakeOfPrize

## 입력
- - -
- [x] 로또 구입 금액을 1000원 단위로 입력한다. - Input#payForLotto
- [x] 당첨 번호 6개를 쉼표 기준으로 입력한다. - Input#winningNumber
- [x] 보너스 번호를 입력한다. - Input#bonusNumber

## 출력
- - -
- [x] 시작 시 ```구입금액을 입력해 주세요.``` 출력한다. - Input#payForLotto
- [x] 구입 금액을 입력하면 그 갯수만큼 ```n개를 구매했습니다.```를 출력한다. -#Application
- [x] 당첨 번호를 입력할 떄 ```당첨 번호를 입력해 주세요.```를 출력한다. - Input#winningNumber
- [x] 보너스 번호를 입력할 떄 ```보너스 번호를 입력해 주세요.```를 출력한다. - Input#bonusNumber
- [x] 당첨 통계를 양식에 맞춰 출력한다. - Output#writeDown
- [x] 수익률을 소수점 두자리까지 출력한다. - Calculator#calculateEarningRate

## 예외처리
- - -
- [x] 모든 에러 문구는 ```[ERROR]```로 시작한다.
  - [x] 구입 금액 입력시, 숫자가 아닌 문자가 있으면 예외 처리 한다. - Pay#validate
  - [x] 구입 금액 입력시, 1000원 단위가 아니면 예외 처리 한다. - Pay#divisible
  - [x] 당첨 번호 입력시, 6개의 숫자가 아니면 예외 처리 한다. - Lotto#validate
  - [x] 당첨 번호 입력시, 중복 숫자가 있으면 예외 처리 한다. - Lotto#repeat
  - [ ] 보너스 번호 입력시, 한개의 숫자가 아니면 예외 처리 한다.
  - [ ] 보너스 번호 입력시, 로또 번호와 중복 숫자이면 예외 처리 한다.