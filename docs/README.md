# 로또 

## 기능 목록

- [ ] 1~45까지 랜덤 숫자를 중복없이 생성 - LottoNumbers#createRandomNumbers()
- [ ] 로또 구입 금액에 맞게 로또 발행 - LottoNumbers#buyHowManyLotto()
- [ ] 당첨 번호 6개 입력 ( , 로 구분 ), 중복 x - Manager#inputWinNumbers()
- [ ] 수익률 구하기 - Manager#calculateMoney()
  - [ ] 보너스 번호 1개 입력 - Manager#inputBonusNumber()
- [ ] 로또 숫자 중, 중복된 숫자 있으면 예외 발생 - Lotto#hasNumber()



## 기능 요구 사항

중복 되지 않은 숫자 6개를 

당첨 번호 6개 , 보너스 번호 1개와 비교한다.

- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
