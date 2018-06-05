package characters.monsters;

import java.util.Random;

import characters.playerCharacters.PlayerCharacter;

public class OnogonJunior extends Monster {
	final int LEVEL = 10;
	final String NAME = "オノゴンJr.";
	final int INITIAL_HP = 23;
	final int ATTACK_POINT = 18;
	final int DEFENCE_POINT = 20;
	final int SPEED_POINT = 10;
	final int AVOID_POINT = 6;
	final int MAGIC_AVOID_POINT = 0;
	final int MONEY = 0;

	public OnogonJunior(int i) {
		this.order = i;
		this.name = NAME;
		this.hp = INITIAL_HP;
		this.attackPoint = ATTACK_POINT;
		this.defencePoint = DEFENCE_POINT;
		this.speedPoint = SPEED_POINT;
		this.avoidPoint = AVOID_POINT;
		this.magicAvoidPoint = MAGIC_AVOID_POINT;
		this.money = MONEY;
		this.runFlag = false;
		this.loseFlag = false;
	}

	@Override
	public void appear() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("ゅゅゅゅゅゅゅゅゅゅゅゅゅゅゅややややややゅゅゅゅゅゅゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅゅゅゅゅゅややややお哉の哉哉哉哉おやゅゅゅゅゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅゅゅゅややおおのの潤潤野野野野野潤哉のやゅゅゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅゅゅや小おの哉潤潤野野野野野野野潤哉お小やゅゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅやや小おの潤潤野野野野野野野野野野野野哉お小ゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅやおお哉潤野野野野野野野野野野野野野野野潤哉小ゅゅゅゅゅゅ");
		System.out.println("ゅゅゅやややお哉潤野野野野野野野野野野野野野野野野野哉の小ゅゅゅゅゅ");
		System.out.println("ゅゅゅやおお哉野野野潤野野野野野野野野野野野野野野野潤潤おやゅゅゅん");
		System.out.println("ゅゅゅやお哉潤野野潤野野野野潤野野野野野野野野野野野野潤哉やゅゅゅゅ");
		System.out.println("ゅゅゅお潤野野野野野野野潤潤潤潤潤野野野野野野野野潤野潤野のゅゅゅゅ");
		System.out.println("ゅゅ小哉野野野野野野野潤哉哉哉哉哉潤野野野野野野野野野野潤潤おゅゅゅ");
		System.out.println("ゅゅの潤野野野野野野潤哉哉のの哉哉哉潤野野潤野野野野野野野潤哉ゅゅゅ");
		System.out.println("ゅやの潤野野野野野野潤哉ののの哉哉哉哉潤野潤潤潤野野野野野野潤おゅゅ");
		System.out.println("ゅや哉野野野野野野野潤哉ののの哉哉哉哉哉潤潤潤潤野野野野野野潤哉ゅゅ");
		System.out.println("ゅや潤野野野野野野潤哉ののののの哉哉哉哉哉潤哉潤潤野野野野野潤潤やゅ");
		System.out.println("ゅや哉野野野野野野潤哉のおおおのののののののの哉潤潤野野野野野潤やゅ");
		System.out.println("ゅゅの野野野野野野哉哉哉哉ののののののののおおの哉潤野野野潤野潤やゅ");
		System.out.println("ゅゅの野野野野野潤哉哉潤野野潤哉ののの哉潤潤潤哉哉哉潤野野野野潤やゅ");
		System.out.println("ゅゅの潤野野野潤哉の哉哉潤潤潤潤哉哉哉潤潤潤潤哉哉哉哉野野野潤哉ゅゅ");
		System.out.println("ゅゅ小潤野野野哉哉哉哉の哉哉潤潤潤哉哉哉潤哉哉ののおの潤野潤野のゅゅ");
		System.out.println("ゅゅや潤潤野野哉哉哉潤潤潤潤潤哉哉の哉哉潤哉のののおお潤野潤潤小ゅゅ");
		System.out.println("ゅゅや哉潤野潤ののの哉哉野潤潤のおおの潤潤野潤潤のおお潤潤潤潤ゅゅゅ");
		System.out.println("ゅゅゅ哉の潤哉ののおのの哉哉のおおおおの哉哉のおおおお潤潤哉哉ゅゅゅ");
		System.out.println("ゅゅゅの哉潤のののおおおおのおのお小おおおのお小おお小哉哉哉おゅゅゅ");
		System.out.println("ゅゅゅの潤哉おののののおおおおのお小おおおおおおお小やのののやゅゅゅ");
		System.out.println("ゅゅゅお哉のおのののおおおのののお小おのおおおおお小や小哉のゅゅゅゅ");
		System.out.println("ゅゅゅ小ののののののおおののの哉哉のおおのおおおお小や小のおゅゅゅゅ");
		System.out.println("ゅゅゅやのののののののののの哉潤潤潤潤のののおおお小小おの小ゅゅゅゅ");
		System.out.println("ゅゅゅゅおののののののののの哉哉哉哉哉おおののおお小小おおやゅゅゅゅ");
		System.out.println("ゅゅゅゅやののののの哉哉ののののののおのおのののお小小お小ゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅゅやのの哉哉哉哉哉哉潤哉哉哉のののののお小小小ゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅゅやのの哉哉哉潤潤潤潤潤潤潤潤潤哉哉のおおやゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅゅゅゅ小の哉哉潤哉哉哉哉哉哉のの哉哉哉のお小ゅゅゅゅゅゅゅゅ");
		System.out.println("ゅゅゅゅやゅややの哉哉哉哉哉哉潤潤潤哉哉の哉哉のおやゅゅゅゅゅゅゅゅ");
		System.out.println("ゅゅややややややや哉哉哉哉哉哉哉哉哉のののの哉の小ゅゅゅゅゅゅゅゅゅ");
		System.out.println("やややややややややの哉哉哉哉哉哉哉哉ののののののやゅゅゅゅゅゅゅゅゅ");
		System.out.println("やややややややややお哉哉哉哉哉潤潤潤哉哉のののおやゅゅゅゅゅゅゅゅゅ");
		System.out.println("やややややややややの哉哉潤潤潤潤潤潤哉哉哉哉のおやゅゅゅゅゅゅゅゅゅ");
		System.out.println("やややややややややのの哉哉潤潤潤潤潤哉哉哉ののおゅゅゅゅゅゅゅゅゅゅ");
		System.out.println("やややややややおゅおの哉哉哉潤潤潤哉哉哉哉ののおゅややゅゅゅゅゅゅゅ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void takeAction(PlayerCharacter player) {
		Random random = new Random();
		int randomNumber = random.nextInt(10);
		switch (randomNumber) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			attack(player);
			break;
		case 7:
		case 8:
		case 9:
			noAction();
			break;
		}
	}

	public void noAction() {
		System.out.println(this.name + "はマングローブについて語っている！");
	}

	@Override
	public void die(PlayerCharacter pc) {
		System.out.println(this.name + "「ぐああぁぁぁぁ!!!!」");
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ぅぅぅぅぅぅぅぅぅぅぅぅぅぅぅママママママぅぅぅぅぅぅぅぅぅぅぅぅぅ");
		System.out.println("ぅぅぅぅぅぅぅぅぅぅママママも理ヂ理理理ヂヂマぅぅぅぅぅぅぅぅぅぅぅ");
		System.out.println("ぅぅぅぅぅぅぅぅママももヂヂ無無無無無無無無理ヂマぅぅぅぅぅぅぅぅぅ");
		System.out.println("ぅぅぅぅぅマママももヂ理理無無無無無無無無無理ヂもマぅぅぅぅぅぅぅぅ");
		System.out.println("ぅぅぅぅぅマママヂヂ理無無無無無無無無無無無無無理もマぅぅぅぅぅぅぅ");
		System.out.println("ぅぅぅぅぅマもヂ理無無無無無無無無無無無無無無無無無ヂもぅぅぅぅぅぅ");
		System.out.println("ぅぅぅマママも理無無無無無無無無無無無無無無無無無無理ヂもぅぅぅぅぅ");
		System.out.println("ぅぅぅマももヂ無無無無無無無無無無無無無無無無無無無無理もマぅぅぅぅ");
		System.out.println("ぅぅぅマもヂ無無無無無無無無無無無無無無無無無無無無無無理マぅぅぅぅ");
		System.out.println("ぅぅマヂ理無無無無無無無無理理理無無無無無無無無無無無無無ヂマぅぅぅ");
		System.out.println("ぅぅも理無無無無無無無理理理理理理無無無無無無無無無無無無無もぅぅぅ");
		System.out.println("ぅぅヂ無無無無無無無無理ヂヂヂ理理理理無無無無無無無無無無無理マぅぅ");
		System.out.println("ぅマヂ無無無無無無無理理ヂヂヂ理理理理理無無無無無無無無無無無もぅぅ");
		System.out.println("ぅマヂ無無無無無無無理理ヂヂヂ理理理理理無理理無無無無無無無無理ぅぅ");
		System.out.println("ぅマ理無無無無無無無理ヂヂヂヂヂヂ理理理理理理理無無無無無無無無マぅ");
		System.out.println("ぅマ理無無無無無無無理ヂヂヂヂヂヂヂヂヂヂヂヂ理理無無無無無無無マぅ");
		System.out.println("ぅマヂ無無無無無無理理理理ヂヂヂヂヂヂヂヂヂヂヂ理理無無無無無無マぅ");
		System.out.println("ぅぅヂ無無無無無理理理無無無理理ヂヂヂ理理理理理理理無無無無無無マぅ");
		System.out.println("ぅぅヂ無無無無理ヂヂ理理理理理理理理理理理理理理理理理無無無無理ぅぅ");
		System.out.println("ぅぅも無無無無理理理理ヂ理理理理理理理理理理ヂヂヂヂヂ無無無無ヂぅぅ");
		System.out.println("ぅぅマ理理無無理理理理無無無理理ヂヂ理理理理ヂヂヂもヂ理無無無もぅぅ");
		System.out.println("ぅぅマヂ理無無ヂヂヂ理理無理理ヂヂもヂ理無無理理ヂもも無無無理マぅぅ");
		System.out.println("ぅぅぅ理ヂ無理ヂヂヂヂヂ理ヂヂヂももヂヂヂ理ヂヂももも理理理理ぅぅぅ");
		System.out.println("ぅぅぅヂヂ無ヂヂヂももヂヂヂもヂももももヂヂもももももヂ理理もぅぅぅ");
		System.out.println("ぅぅぅヂ理理ヂヂヂヂヂヂヂヂヂヂももももヂヂももももマヂヂヂマぅぅぅ");
		System.out.println("ぅぅぅも理ヂヂヂヂヂヂもヂヂヂヂもももヂヂもももももマも理ヂマぅぅぅ");
		System.out.println("ぅぅぅもヂヂヂヂヂヂヂヂヂヂヂヂヂヂヂヂヂもももももマもヂもぅぅぅぅ");
		System.out.println("ぅぅぅマヂヂヂヂヂヂヂヂヂヂ理無理理理ヂヂヂヂもももももヂもぅぅぅぅ");
		System.out.println("ぅぅぅぅもヂヂヂヂヂヂヂヂヂヂ理理理理ももヂヂヂもももももマぅぅぅぅ");
		System.out.println("ぅぅぅぅマヂヂヂヂヂ理ヂヂヂヂヂヂヂヂヂヂヂヂヂもももヂもぅぅぅぅぅ");
		System.out.println("ぅぅぅぅぅぅマヂヂ理理ヂ理ヂ理理理理理ヂヂヂヂヂももマママぅぅぅぅぅ");
		System.out.println("ぅぅママぅぅマヂヂ理理理無無無理無理理理無理ヂヂヂもマぅぅぅぅぅぅぅ");
		System.out.println("ママママママぅもヂ理理理理理理理理理ヂヂヂ理理ヂももぅぅぅぅぅぅぅぅ");
		System.out.println("ママママママママヂ理理理理理理理理理理理ヂ理理ヂヂマぅぅぅぅぅぅぅぅ");
		System.out.println("マママママママママ理理理理理理理理理ヂヂヂヂヂヂもぅぅぅぅぅぅぅぅぅ");
		System.out.println("マママママママママヂ理理理理理理理理ヂヂヂヂヂヂマぅぅぅぅぅぅぅぅぅ");
		System.out.println("マママママママママヂ理理理理理理理理理理ヂヂヂヂママぅぅぅぅぅぅぅぅ");
		System.out.println("マママママママママヂヂ理理理理理理理理理理理ヂもママぅぅぅぅぅぅぅぅ");
		System.out.println("マママママママママヂヂ理理理理理理理理理理ヂヂもぅマママぅぅぅマぅぅ");
		System.out.println("マママママママもマヂヂヂ理理理理理理理理ヂヂヂもぅマママママママぅマ");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.die(pc);
	}

}
