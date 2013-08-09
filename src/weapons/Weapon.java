package weapons;

public class Weapon {
	public int power; // ��������
	public int maxRange; // max ��������� ��������
	public int effectiveRange; // ���������� ���������
	public int rateOfFire;
	public int weight;
	public int height;
	private int timeToReload; // ������� ����� ����������� �� ����� ������ ���
								// �����
	public int bulletVelocity;
	public int noise;
	public int calibr;
	private boolean readytoFire;// ���������� �������� ����� ������
	public boolean isReadytoFire() {
		return readytoFire;
	}
	public void setReadytoFire(boolean readytoFire) {
		this.readytoFire = readytoFire;
	}
	public int getTimeToReload() {
		return timeToReload;
	}
	public void setTimeToReload(int timeToReload) {
		this.timeToReload = timeToReload*1000; //�������� ������� � ������������
	}

}
