package project02;

public class LeftBlinker implements Blinker {
	@Override
	public void blinkerState() {
		System.out.println("왼쪽 깜빡이가 켜졌습니다.");
	}
}
