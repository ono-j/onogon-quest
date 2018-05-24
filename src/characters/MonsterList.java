package characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MonsterList {
//	public static Monster encountRandomMonster(){
//		int monsterNo = MonsterListEnum.getRandomMonster().getId();
//	    switch (monsterNo) {
//	      case 1:
//	        return new Matango();
//	        break;
//	      case 2:
//	    	return new Slime();
//	        break;
//	      default:
//	    	return null;
//	    	break;
//	}

	private final static int MAX_MONSTER_NUMBER = 2;
	public enum MonsterListEnum {
		Matango(1, "お化けキノコ"),
		Slime(2, "スライム");

		private int id;
		private String name;

		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}

		private MonsterListEnum (int id, String name) {
			this.id = id;
			this.name = name;
		}

		public static MonsterListEnum valueOf(int id) {
			MonsterListEnum[] array = values();
			for(MonsterListEnum num : array) {
				if (id == num.getId()){
					return num;
				}
			}
			return null;
		}

		private static final List<MonsterListEnum> MONSTERS =
				Collections.unmodifiableList(Arrays.asList(values()));
		private static final int SIZE = MONSTERS.size();
		private static final Random RANDOM = new Random();

		public static MonsterListEnum getRandomMonster() {
			return MONSTERS.get(RANDOM.nextInt(SIZE));
		}

	}
	public static List<Monster> encountMonsters(){
		Random rand = new Random();
		int monsterNumber = rand.nextInt(MAX_MONSTER_NUMBER) + 1;
		List<Monster> encountMonsterList = new ArrayList();
		for (int i = 0; i < monsterNumber; i++){
			int monsterNo = MonsterList.MonsterListEnum.getRandomMonster().getId();
				switch (monsterNo) {
				case 1:
					encountMonsterList.add(new Matango());
					break;
				case 2:
					encountMonsterList.add(new Slime());
					break;
			}
		}
		return encountMonsterList;

	}

}
