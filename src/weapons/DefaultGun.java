package weapons;

public class DefaultGun extends Weapon {

	public DefaultGun() {
		power = 10; // мощность
		maxRange = 50; // max дальность стрельбы
		effectiveRange = 25; // ѕрицельна€ дальность
		rateOfFire = 2;// скорострельность в секундах
		weight = 300;// gramm
		height = 30;// cm
		
		setTimeToReload(4); // среднее врем€ перезар€дки ил врем€ замаха дл€ сабли
		noise = 10;
		calibr = 12;// mm
		bulletVelocity = 24;

	}
}
