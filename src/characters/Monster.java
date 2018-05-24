package characters;

import java.util.Random;

public abstract class Monster extends Character {
  public static int lostNumber;
  public char suffix;
  public abstract void appear();
  public abstract void takeAction(PlayerCharacter player);

  public void attack(PlayerCharacter pc) {
	    System.out.println(name + this.suffix + "の攻撃！");
	    Random rand = new Random();
	    if (rand.nextInt(10) > 1 || pc.sleepFlag == true) {
	    	  int finalAttackPoint = rand.nextInt(this.attackPoint);
		      int finalDefencePoint = rand.nextInt(pc.defencePoint);
		      int attackDamage;
		      if (finalAttackPoint > finalDefencePoint){
		    	  attackDamage = finalAttackPoint - finalDefencePoint;
		      } else {
		    	  attackDamage = 0;
		      }
		  int pcHp = pc.getHp() - attackDamage;
	      pc.setHp(pcHp);
	      System.out.println(attackDamage + "ポイントのダメージを受けた！");
	      System.out.println("");
	      if (pc.getHp() < 1) {
	        pc.die();
	      }
	    } else {
	      System.out.println(pc.name + "は、うまくかわした！");
		  System.out.println("");
	    }
	  }

  @Override
  public void run() {
    System.out.println(this.name + this.suffix + "は逃げ出した！");
	System.out.println("");
    this.looseFlag = true;
    lostNumber++;
  }

  public void sleep() {
    System.out.println(this.name + this.suffix + "は、眠って回復した！");
	System.out.println("");
  }

  public void die() {
    System.out.println(this.name + this.suffix + "を倒した！");
	System.out.println("");
    this.looseFlag = true;
    lostNumber++;
  }

}
