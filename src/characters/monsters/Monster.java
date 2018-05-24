package characters.monsters;

import java.math.BigDecimal;
import java.util.Random;

import characters.Character;
import characters.playerCharacters.PlayerCharacter;

public abstract class Monster extends Character {
  public static int lostNumber;
  public char suffix;
  public int order;
  public int avoidPoint;
  public int magicAvoidPoint;
  public int money;
  public abstract void appear();
  public abstract void takeAction(PlayerCharacter player);

  public int getOrder(){
	  return this.order;
  }

  public void attack(PlayerCharacter pc) {
	    System.out.println(name + "の攻撃！");
	    Random random = new Random();
	    if (random.nextInt(64) > 1 || pc.getSleepFlag() == true) {
	    	  int finalAttackPoint = random.nextInt(this.attackPoint);
		      int finalDefencePoint = random.nextInt(pc.getDefencePoint());
		      BigDecimal monsterAttactPoint = new BigDecimal(String.valueOf(this.attackPoint));
		      BigDecimal playerDefencePoint = new BigDecimal(String.valueOf(pc.getDefencePoint()));
		      int attackDamage;
		      // A = (敵の攻撃力 * 2 - プレイヤーの守備力) / 2
		      BigDecimal A = monsterAttactPoint.multiply(new BigDecimal("2")).subtract(playerDefencePoint)
		    		  .divide(new BigDecimal("2"), 0, BigDecimal.ROUND_HALF_UP);
		      // A ≦ 0の場合
		      if (A.compareTo(new BigDecimal("1")) < 0){
		    	// ダメージ = 1 ～ 2
		    	  attackDamage = random.nextInt(2) + 1;
		      }
		      // A < 敵の攻撃力／2 + 1の場合
		      else if (A.compareTo(
		    		  monsterAttactPoint.divide(new BigDecimal("2"), 0, BigDecimal.ROUND_HALF_UP)
		    		  .add(new BigDecimal("1")))
		    		  < 0){
		    	  attackDamage = new BigDecimal("2")
		    			  .add(monsterAttactPoint.divide(new BigDecimal("2")).add(new BigDecimal("1"))
		    			  .multiply(new BigDecimal(String.valueOf(random.nextInt(256))).divide(new BigDecimal("256"))))
		    			  .divide(new BigDecimal("3"))
		    			  .setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		      }
		   // A > 敵の攻撃力／2 + 1の場合
		      else {
		    	  // ダメージ = ｛A + (A + 1) * (0 ～ 255) /256｝ / 2
		    	  attackDamage = A.add(
		    			  A.add(new BigDecimal("1"))
		    			  .multiply(new BigDecimal(String.valueOf(random.nextInt(256))).divide(new BigDecimal("256"))))
		    			  .divide(new BigDecimal("2"))
		    			  .setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
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
    System.out.println(this.name + "は逃げ出した！");
	System.out.println("");
    this.loseFlag = true;
    lostNumber++;
  }

  public void sleep() {
    System.out.println(this.name + "は、眠って回復した！");
	System.out.println("");
  }

  public void die(PlayerCharacter pc) {
    System.out.println(this.name + "を倒した！");
    this.loseFlag = true;
    pc.setMoney(pc.getMoney() + this.money);
 	System.out.println(pc.name + " は " + this.money + "ゴールドひろった ");
	System.out.println("");
    lostNumber++;
  }

}
