package magics;

import java.util.Random;

import characters.monsters.Monster;
import characters.playerCharacters.PlayerCharacter;

public class Sizz extends Magic{
	final String NAME = "ギラ";
	final int LOST_MP = 2;
	final int EFFECT_VALUE = 5;

	public Sizz(){
		this.name = NAME;
		this.lostMp = LOST_MP;
		this.effectValue = EFFECT_VALUE;
	}

	@Override
	public void cast(PlayerCharacter pc, Monster m) {
		Random random = new Random();
		if(random.nextInt(16) > m.magicAvoidPoint){
			// ダメージ = 5 + (1 ～ 7)
			this.effectValue = EFFECT_VALUE + random.nextInt(7) + 1;

			System.out.print(this.effectValue + "ポイントのダメージを与えた！");
			System.out.println("");
			int monsterHp = m.getHp();
			monsterHp -= this.effectValue;
			m.setHp(monsterHp);
			if (monsterHp < 1) {
				m.die(pc);
			}
		} else {
			System.out.print("魔法は外れてしまった。");
		}
	}

}
