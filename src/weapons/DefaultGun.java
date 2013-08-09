package weapons;

public class DefaultGun extends Weapon {

	public DefaultGun() {
		power = 10; // ��������
		maxRange = 50; // max ��������� ��������
		effectiveRange = 25; // ���������� ���������
		rateOfFire = 2;// ���������������� � ��������
		weight = 300;// gramm
		height = 30;// cm
		
		setTimeToReload(4); // ������� ����� ����������� �� ����� ������ ��� �����
		noise = 10;
		calibr = 12;// mm
		bulletVelocity = 24;

	}
}
