package characters;

import java.util.Random;

public class Slime extends Monster {
	  final int LEVEL = 1;
	  final String NAME = "スライム";
	  final int INITIAL_HP = 20;
	  final int ATTACK_POINT = 5;
	  final int DEFENCE_POINT = 5;
	  final int SPEED_POINT = 10;


	public Slime() {
		  this.name = NAME;
		  this.hp = INITIAL_HP;
		  this.attackPoint = ATTACK_POINT;
		  this.defencePoint = DEFENCE_POINT;
		  this.speedPoint = SPEED_POINT;
		  this.looseFlag = false;
	}

	@Override
	public
	void appear() {
		System.out.println("  ﾉヽ､");
		System.out.println("( ﾟ∀ﾟ)");
		System.out.println(" ￣￣~");
	}

	@Override
	public
	void takeAction(PlayerCharacter player) {
	    Random random = new Random();
	    int randomNumber = random.nextInt(7);
	    switch (randomNumber) {
	      case 0:
	      case 1:
	      case 2:
	      case 3:
	        attack(player);
	        break;
	      case 4:
	      case 5:
	        noAction();
	        break;
	      case 6:
	        run();
	        break;
	    }

	}

	  public void noAction() {
		    System.out.println(this.name + this.suffix + "は はねた！");
		    System.out.println("しかし何も起こらない！");
	  }

	@Override
	public void die() {
		super.die();
		System.out.println("  ﾉヽ､");
		System.out.println("(×o×)");
		System.out.println(" ￣￣~");
	}


}
