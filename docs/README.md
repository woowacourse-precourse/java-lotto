# 로또 

## 기능 목록

- [ x ] 1~45까지 랜덤 숫자를 중복없이 생성 - LottoRandomNumbers#createRandomNumbers()
- [ x ] 로또 구입 금액에 맞게 로또 발행 - LottoRandomNumbers#createRandomNumbers()
- [ x ] 당첨 번호 6개 입력 ( , 로 구분 ), 중복 x - LottoGame#createWinNumber()
- [ x ] 수익률 구하기 - LottoNumberCheck#calculateYield()
  - [ x ] 보너스 번호 1개 입력 - LottoGame#createBonusNumber()
  - [ x ] 소수점 둘째자리에서 반올림 - LottoNumberCheck#calculateYield()
- [ x ] 보너스 숫자 ( 2등 당첨 ) , 5개 숫자 ( 3등 당첨 ) 구분 - LottoNumberCheck#compareMyLottoNumberWithBonusNumber()
- [ x ] 몇 등 당첨인지 구분할 수 있는 기능 - LottoNumberCheck#countPrizeMoneyOfMyLotto()

## 예외 목록
- [ x ] 내가 입력한 승리 번호 , 보너스 번호가 숫자가 아닐 때 예외 발생
  - [ x ] 1 ~ 45의 범위가 아닐 때 예외 발생
  - [ x ] (승리 번호, 보너스 번호) 중복된 번호가 있을 때 예외 발생
- [ x ] try - catch를 이용한 IllegalArgumentException 예외 발생 - main()
- [ x ] 구매 금액이 1_000원으로 나누어 떨어지지 않으면 예외 발생
- [ x ] 구매 금액이 숫자가 아니면 예외 발생



## 기능 요구 사항

중복 되지 않은 숫자 6개를 

당첨 번호 6개 , 보너스 번호 1개와 비교한다.

- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
