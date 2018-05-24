package onogonQuestMain;

import java.util.Comparator;

public class SpeedComparator implements Comparator<characters.Character>{

	@Override
	public int compare(characters.Character o1, characters.Character o2) {
		return o1.getSpeedPoint() < o2.getSpeedPoint() ? 1 : -1;
	}


}
