package characters.monsters;

import java.util.Random;

import characters.playerCharacters.PlayerCharacter;

public class Slime extends Monster {
	final int LEVEL = 1;
	final String NAME = "スライム";
	final int INITIAL_HP = 4;
	final int ATTACK_POINT = 7;
	final int DEFENCE_POINT = 3;
	final int SPEED_POINT = 10;
	final int AVOID_POINT = 1;
	final int MAGIC_AVOID_POINT = 0;
	final int MONEY = 10;

	public Slime(int i) {
		this.order = i;
		this.name = NAME;
		this.hp = INITIAL_HP;
		this.attackPoint = ATTACK_POINT;
		this.defencePoint = DEFENCE_POINT;
		this.speedPoint = SPEED_POINT;
		this.avoidPoint = AVOID_POINT;
		this.magicAvoidPoint = MAGIC_AVOID_POINT;
		this.money = 10;
		this.runFlag = true;
		this.loseFlag = false;
	}

	@Override
	public void appear() {
		System.out.println("  ﾉヽ､");
		System.out.println("( ﾟ∀ﾟ)");
		System.out.println(" ￣￣~");
	}

	@Override
	public void takeAction(PlayerCharacter pc) {
		Random random = new Random();
		int randomNumber = random.nextInt(10);
		switch (randomNumber) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			attack(pc);
			break;
		case 6:
		case 7:
		case 8:
			noAction();
			break;
		case 9:
			run();
			break;
		}

	}

	public void noAction() {
		System.out.println(this.name + "は はねた！");
		System.out.println("しかし何も起こらない！");
	}

	@Override
	public void die(PlayerCharacter pc) {
		System.out.println("  ﾉヽ､");
		System.out.println("(×o×)");
		System.out.println(" ￣￣~");
		super.die(pc);
	}

}
