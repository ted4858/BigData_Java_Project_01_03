package project02;

public class RightBlinker implements Blinker {
	@Override
	public void blinkerState() {
		System.out.println("오른쪽 깜빡이가 켜졌습니다.");
	}
}
