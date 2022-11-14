# 구현할 기능 목록

## 사용자의 입력값 확인

사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- 구입금액은 1000으로 나누어 떨어져야 한다.
- 당첨번호는 `,`를 기준으로 구분되어야 하고, 총 6개의 숫자이다.
- 당첨번호는 unique 해야한다.
- 당첨번호는 1~45 사이에 있어야 한다.
- 보너스번호는 총 1개의 숫자이다.
- 보너스번호는 unique 해야한다.
- 보너스번호는 1~45 사이에 있어야 한다.

정수인지 아닌지는 `StringToIntDataStructure`클래스에서 예외처리 하도록한다.     
적절한 정수들인지 아닌지는 `Lotto`클래스의 생성자에서 확인한다.

## Random 값 추출(난수 생성)

Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.

`RandomLottos` 클래스에서 저장한다.

## java enum

java enum 클래스 `LottoRanking`을 작성한다.   
```
1등: 6개일치, 2,000,000,000원
5등: 3개일치, 5,000원
```
과 같이 데이터들 간의 연관관계를 표현할 수 있게 한다.     
몇개의 숫자가 일치했는지와 보너스 숫자의 일치여부가 주어질 때, 그 정보와 일치하는 enum을 반환하는 메소드 `LottoRanking.of`를 작성한다.

## 당첨 로또 정보(입력값)

- `WinningLotto` 클래스에서 저장한다. `Lotto` 클래스 composition으로 구현한다.(https://stackoverflow.com/questions/49002/prefer-composition-over-inheritance).

## Lotto 클래스

`WinningLotto`를 매개변수로 `LottoRanking`을 반환하는 메소드 `findLottoRankingBy()`를 추가로 작성한다.      
**일급콜렉션인 `Lotto`에서 getter를 사용하는 것은 좋지 않으므로 해당 숫자를 포함하는지의 여부를 알려주는 `hasNumber()` 메서드를 작성한다.**

## 당첨 통계

`LottoStatistic` 클래스를 만들어 통계를 담당하도록 한다.
- `LottoStatistic` 클래스는 `List<LottoRanking> lottosRanking`을 저장한다.
- `RandomLottos`의 인스턴스 `randomLottos`, `WinningLotto`의 인스턴스 `winningLotto`를 매개변수로 이를 초기화 할 수 있다.
- 이 리스트를 통해 출력문자열을 초기화 할 수 있다.

## 출력

`Output` 클래스에 작성한다.

## 단위 테스트

도메인 로직에 단위 테스트를 구현한다. 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

- 입력 예외 처리(Input class) 
- `WinningLotto` 클래스의 `findNumOfMatchingBy()` 메소드
- 적절한 enum을 반환하는지
- `LottoStatistic` 클래스의 `lottosRanking` 이 적절하게 초기화 되었는지
- 적절한 결과를 반환하는지