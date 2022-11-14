## Lotto 과제 기능 목록
### - Lotto 인스턴스 추가 기능
- [x] validate 메서드 기능 추가 - Lotto.validate()
  - [x] 입력된 숫자가 1~45 사이의 숫자가 아닐 시 예외 발생
  - [x] 입력된 숫자에 중복된 숫자가 입력될 시 예외 발생
- [x] 숫자들을 정렬하여 보여주기 - Lotto.showLotto()
### - LottoSeller 인스턴스 기능
- [x] 구입 금액 읽기 - LottoSeller.takemoney()
  - [x] 구입 금액에 따라 만들 로또의 개수 계산
  - [x] 거스름돈 계산
- [x] LottoBundle 만들기 - LottoSeller.makeLottoBundle()
  - [x] Lotto에 난수를 넣기
- [x] 만든 LottoBundle 보여주기 - LottoSeller.showBundle()
- [x] 거스름돈 돌려주기 - LottoSeller.giveChange()
### - NumberComparator 인스턴스 기능
- [x] 당첨 숫자 읽기 - setWinningNumber()
  - [x] 숫자 validate - validateWinningNumber()
- [x] 보너스 숫자 추가하기 - setWholeNumber()
  - [x] 숫자 validate - validateWholeNumber()
- [x] LottoBundle과 당첨 숫자들 비교하기 - compareNumbers()
### - WinningPayer 인스턴스 기능
- [ ] 당첨금 지급하기
- [ ] 수익률 알려주기
   

