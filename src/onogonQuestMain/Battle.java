package onogonQuestMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import characters.Character;
import characters.monsters.Monster;
import characters.monsters.MonsterList;
import characters.monsters.OnogonJunior;
import characters.playerCharacters.PlayerCharacter;

public class Battle {

	public static void startBattle(PlayerCharacter pc) {
		// コマンドを選ぶ
		// 選んだコマンドを実行
		// 相手が生きているかどうか
		List<Monster> monsterList = null;
		Monster.lostNumber = 0;
		monsterList = MonsterList.encountMonsters();
		int monsterNumber = monsterList.size();
		for (int i = 0; i < monsterNumber; i++) {
			System.out.println(monsterList.get(i).name + "が現れた！");
			monsterList.get(i).appear();
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		battle(pc, monsterList);
	}

	public static void startEventBattle(PlayerCharacter pc, int bossNo) {
		// コマンドを選ぶ
		// 選んだコマンドを実行
		// 相手が生きているかどうか
		List<Monster> monsterList = null;
		Monster.lostNumber = 0;
		switch (bossNo) {
		case 0:
			monsterList = new ArrayList();
			monsterList.add(new OnogonJunior(0));
			break;
		default:
			monsterList = MonsterList.encountMonsters();
			break;
		}
		int monsterNumber = monsterList.size();
		for (int i = 0; i < monsterNumber; i++) {
			System.out.println(monsterList.get(i).name + "が現れた！");
			monsterList.get(i).appear();
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		battle(pc, monsterList);
	}

	public static void battle(PlayerCharacter pc, List<Monster> monsterList) {
		List<Character> characterList = new ArrayList<>();
		pc.setRunFlag(false);
		characterList.add(pc);

		Collections.sort(characterList, new SpeedComparator());
		Monster.lostNumber = 0;
		int monsterNumber = monsterList.size();
		for (int i = 0; i < monsterNumber; i++) {
			characterList.add(monsterList.get(i));
		}
		while (!pc.getLooseFlag() && !pc.getRunFlag() && Monster.lostNumber < monsterNumber) {
			pc.showStatus();
			CommandList commandList = new CommandList();
			commandList = pc.selectCommand(monsterList);
			for (int i = 0; i < characterList.size(); i++) {
				Character actingCharacter = characterList.get(i);
				if (!actingCharacter.getLooseFlag()) {
					if (actingCharacter instanceof PlayerCharacter) {
						actingCharacter.executeCommand(commandList);
						System.out.println("");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (pc.getLooseFlag() || pc.getRunFlag() || Monster.lostNumber == monsterNumber) {
							break;
						}
					} else {
						actingCharacter.takeAction(pc);
						System.out.println("");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						if (pc.getLooseFlag() || pc.getRunFlag() || Monster.lostNumber == monsterNumber) {
							break;
						}
					}
				}
			}
		}
		if (Monster.lostNumber == monsterNumber) {
			System.out.println(pc.name + "は戦いに勝利した！");
			System.out.println("さすが勇者！");
		}
	}

}
