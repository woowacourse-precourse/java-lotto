# 미션 - 로또

## 리펙토링 내용

- 상수 이름에 존재하던 데이터 타입 제거
- 예외 메세지 형식 변경
- 일급 컬렉션 `Lotto`에서 관리하던 출력 형식을 `OutputView`로 분리
- 6개의 로또 번호 생성 시 `Set` 대신 `List` 사용
- `LottoRanking` 패키지 변경(utils -> domain)
- `LottoRanking`에서 `import static`을 하지 않아 중복된 의미를 가지던 이름 변경
- `NumberFormatException` 발생 시 이를 `IllegalArgumentException`으로 변경할 때 기존 예외를 저장하도록 변경
- 누락된 테스트 케이스 추가 및 잘못된 테스트 케이스 수정
- `toString`과 `getter`를 구분해서 사용
- 전략 패턴 적용
- `Player` 외부에서 `PlayerPurchaseAmount`를 알지 못하도록 `PlayerPurchaseAmount` 생성 값만을 주입받도록 변경
- 로또 당첨 번화와 보너스 번호가 중복될 때의 예외 추가