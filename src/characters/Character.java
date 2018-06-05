package characters;

import characters.playerCharacters.PlayerCharacter;
import onogonQuestMain.CommandList;

public abstract class Character {
	public String name;
	protected int hp; // 現在のHP
	protected int attackPoint;
	protected int defencePoint;
	protected int speedPoint;
	public boolean loseFlag = false;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return this.hp;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	public int getAttackPoint() {
		return this.attackPoint;
	}

	public void setDefencePoint(int defencekPoint) {
		this.defencePoint = defencekPoint;
	}

	public int getDefencePoint() {
		return this.defencePoint;
	}

	public void setSpeedPoint(int speedPoint) {
		this.speedPoint = speedPoint;
	}

	public int getSpeedPoint() {
		return this.speedPoint;
	}

	public void setLooseFlag(boolean looseFlag) {
		this.loseFlag = looseFlag;
	}

	public boolean getLooseFlag() {
		return this.loseFlag;
	}

	public abstract void run();

	public void executeCommand(CommandList commandList) {
	}

	public void takeAction(PlayerCharacter pc) {
	}
}
