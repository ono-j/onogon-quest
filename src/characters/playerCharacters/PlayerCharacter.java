package characters.playerCharacters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import characters.Character;
import characters.monsters.Monster;
import items.Item;
import magics.Magic;
import onogonQuestMain.CommandList;

public abstract class PlayerCharacter extends Character {
  int level;
  int maxHp; // 最大HP
  int maxMp; // 最大MP
  int mp; // 現在のMP
  Item item;
  boolean sleepFlag = false;
  ArrayList<Magic> magicList = new ArrayList<Magic>();
  static int money;

  public void setMp(int mp){
	  this.mp = mp;
  }

  public int getMp(){
	  return this.mp;
  }

  public void setSleepFlag(boolean flag){
	  this.sleepFlag = flag;
  }

  public boolean getSleepFlag(){
	  return this.sleepFlag;
  }

  public void setMoney(int money){
	  this.money = money;
  }

  public int getMoney(){
	  return this.money;
  }


  public void showStatus(){
	  System.out.println(" ────");
	  System.out.println("|" + this.name);
	  System.out.println("|HP: " + this.hp);
	  System.out.println("|MP: " + this.mp);
	  System.out.println("");
}

  public CommandList selectCommand(List<Monster> monsterList) {
	CommandList commandList = new CommandList();
	boolean commandRegistered = false;
	while(!commandRegistered){
		try {
			System.out.println("コマンドを入力してください。");
			int action;
			if (this.magicList != null) {
				System.out.println("1.たたかう  2.かいふく  3.にげる  4,まほう");
				action = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				if(action >= 1 && action <= 4){
					commandList.setAction(action);
					if (action == 4){
						commandList.setMagic(selectMagic());
					}
					commandList.setTarget(selectMonster(monsterList));
					return commandList;
				}
			} else {
				System.out.println("1.たたかう  2.かいふく  3.にげる");
				action = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				if(action >= 1 && action <= 3){
					commandList.setAction(action);
					commandList.setTarget(selectMonster(monsterList));
					return commandList;
				}
			}
			System.out.println(action + "が入力されました。数値を正しく入力してください。");
			System.out.println("");
		} catch (NumberFormatException e) {
	        System.out.println("数値を入力してください。");
			System.out.println("");
	    }
	}
	return commandList;
  }

  public Magic selectMagic(){
	    System.out.println("どの魔法を使いますか？");
		for (int i = 0; i < this.magicList.size(); i++){
	        System.out.print(i + 1 + "." + this.magicList.get(i).name + "  ");
		}
		System.out.println("");
		try {
			int command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
			if(command >= 1 && command <= this.magicList.size()){
				Magic magic = this.magicList.get(command - 1);
		        if (this.mp >= magic.lostMp){
		        	return magic;
		        } else {
		        	System.out.print("MPが足りません！");
		    		System.out.println("");
		        }
			} else {
				System.out.println(command + "が入力されました。数値を正しく入力してください。");
				System.out.println("");
			}
		} catch (NumberFormatException e) {
			System.out.println("数値を入力してください。");
			System.out.println("");
		}
		return null;
  }

  public Monster selectMonster(List<Monster> monsterList) {
	if(monsterList.size() - Monster.lostNumber > 2){
		System.out.println("どのモンスターに攻撃しますか？");
		int command;
		boolean commandRegistered = false;
		while(!commandRegistered){
			try {
				for(int i =0; i < monsterList.size(); i ++){
					Monster monster = monsterList.get(i);
					if(!monster.looseFlag){
						System.out.print(i + 1 + ". " + monster.name + "  ");
					}
				}
				System.out.println("");
				command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				if (command <= monsterList.size()){
					if(!monsterList.get(command - 1).looseFlag){
						return monsterList.get(command - 1);
					}
				}
				System.out.println(command + "が入力されました。数値を正しく入力してください。");
				System.out.println("");
			} catch (NumberFormatException e) {
				System.out.println("数値を入力してください。");
				System.out.println("");
			}
		}
	} else {
		for (int i = 0; i < monsterList.size(); i++){
			Monster monster = monsterList.get(i);
			if(!monster.looseFlag){
				return monster;
			}
		}
	}
	return null;
  }

  // 操作の定義
  public void executeCommand(CommandList commandList) {
    // switch文による場合分け
    switch (commandList.getAction()) {
      case 1:
        attack(commandList.getTarget());
        break;
      case 2:
        sleep();
        break;
      case 3:
        run();
        break;
      case 4:
    	useMagic(commandList.getMagic(), commandList.getTarget());
        break;
    }
  }

  public void attack(Monster m) {
	    System.out.println(this.name + "の攻撃！");
	    if (!m.looseFlag){
	    	Random random = new Random();
	    	if (random.nextInt(64) > m.avoidPoint) {
	    		int attackDamage = 0;
	    		BigDecimal playerAttackPoint = new BigDecimal(String.valueOf(this.attackPoint + this.item.damage));
	    		// 会心の一撃
	    		if (random.nextInt(32)> 30){
		    		System.out.println("かいしんのいちげき！！");
	    			// ダメージ = プレイヤーの攻撃力 -(プレイヤーの攻撃力/2) * (0～255) / 256
	    			attackDamage = playerAttackPoint.subtract(
	    					playerAttackPoint.divide(new BigDecimal("2"))
	    					.multiply(new BigDecimal(String.valueOf(random.nextInt(256))).divide(new BigDecimal("256"))))
	    					.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
	    			// 通常ダメージ
	    		} else {
	    			BigDecimal  monsterDefencePoint = new BigDecimal(String.valueOf(m.getDefencePoint()));
	    			// A = プレイヤーの攻撃力 - 敵の守備力 / 2
	    			BigDecimal A = playerAttackPoint.subtract(monsterDefencePoint.divide(new BigDecimal("2"), 0, BigDecimal.ROUND_HALF_UP));
	    			// A ≧ 2の場合
	    			if (A.compareTo(new BigDecimal("1")) > 0){
	    				// ダメージ = ｛A + (A + 1) * (0～255) / 256｝/ 2
	    				attackDamage = A.add(
	    						A.add(new BigDecimal("1"))
	    						.multiply(new BigDecimal(String.valueOf(random.nextInt(256))).divide(new BigDecimal("256"))))
	    						.divide(new BigDecimal("2"))
	    						.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
	    				// A < 2の場合
	    			} else {
	    				// ダメージ = 1 ～ 2
	    				attackDamage = random.nextInt(2) + 1;
	    			}
	    		}
	    		int monsterHp = m.getHp();
	    		monsterHp -= attackDamage;
	    		m.setHp(monsterHp);
	    		System.out.println(attackDamage + "ポイントのダメージを与えた！");
	    		System.out.println("");
	    		if (monsterHp < 1) {
	    			m.die(this);
	    		}
	    	} else {
	    		System.out.println("避けられた！");
	    		System.out.println("");
	    	}
	    } else {
    			System.out.println("しかし失敗した！");
    			System.out.println("");
	    }
  }

  public void useMagic(Magic magic, Monster m){
	if (this.mp >= magic.lostMp){
		System.out.print(this.name + "はMP" + magic.lostMp + "を消費し、" + magic.name + "を使った！");
		if (this.mp >= magic.lostMp){
			this.mp -= magic.lostMp;
			magic.cast(this, m);
		} else {
			System.out.print("しかしMPが足りない！");
			System.out.println("");
		}
	}
  }

  @Override
  public void run() {
    System.out.println("逃げ出した！");
	System.out.println("");
    this.looseFlag = true;
  }

  public void sleep() {
    System.out.println(name + "は、眠って回復した！");
	System.out.println("");
  }



  public void die() {
    System.out.println(this.name + "は死んでしまった。");
	System.out.println("");
    this.looseFlag = true;
  }


}
