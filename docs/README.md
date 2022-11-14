# 로또

##  기능 목록

- [X] 구입 금액에 해당하는 만큼 로또를 발행하는 기능 - generateLottos()
  - [X] 금액만큼 로또의 수를 count 하는 기능 - Money# getLottoCount()
  - [X] 발행한 로또에 (1 ~ 45범위의) 서로다른 임의의 값이 생성된다. - NumberGenerator#createRandomUniqueNumbers()
- [X] 발행한 로또와 당첨 번호를 비교하는 기능 - Draw Class
  - [X] 일치하는 수의 개수 + 보너스 볼 일치 여부에따라 등수 계산 - Draw#resultLottery()
- [X] 수익률을 계산하는 기능 - Money#viewYield()
- [X] 자바 enum을 활용하기 - Constants#Statistic
  - [참고 사항] https://velog.io/@kyle/자바-Enum-기본-및-활용 


### Class
- Lotto
  - view() - 로또 번호를 출력하는 메소드
  - getNumbers() - 로또 번호를 List 형태로 반환하는 메소드
  - hasNumber(Integer number) - 숫자를 입력받아 해당 숫자가 로또 번호에 존재하는지 확인하는 메소드
  
- Money
  - getLottoCount() - 구매한 로또의 수를 반환하는 메소드
  - viewYield(Integer winnings) 당첨금을 입력받아 수익률을 출력하는 메소드

- Draw
  - resultLottery(List<Lotto> Lottos) - 로또들을 입력받아 당첨 결과를 출력하고 총 당첨금을 반환하는 메소드






