package weapons;

public class Weapon {
	public int power; // мощность
	public int maxRange; // max дальность стрельбы
	public int effectiveRange; // Прицельная дальность
	public int rateOfFire;
	public int weight;
	public int height;
	private int timeToReload; // среднее время перезарядки ил время замаха для
								// сабли
	public int bulletVelocity;
	public int noise;
	public int calibr;
	private boolean readytoFire;// готовность стрелять прямо сейчас
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
		this.timeToReload = timeToReload*1000; //приводим секунды в миллисекунды
	}

}
