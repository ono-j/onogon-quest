package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import items.Item;
import magics.Magic;

public abstract class PlayerCharacter extends Character {
  int maxHp; // 最大HP
  int maxMp; // 最大MP
  int mp; // 現在のMP
  Item item;
  public boolean sleepFlag = false;
  ArrayList<Magic> magicList = new ArrayList<Magic>();

  public void setMp(int mp){
	  this.mp = mp;
  }

  public int getMp(){
	  return this.mp;
  }

  public void showStatus(){
	  System.out.println(" ────");
	  System.out.println("|" + this.name);
	  System.out.println("|HP: " + this.hp);
	  System.out.println("|MP: " + this.mp);
	  System.out.println("");
}

  public int selectCommand() {
	int command;
	boolean commandRegistered = false;
	while(!commandRegistered){
		try {
			System.out.println("コマンドを入力してください。");
			if (this.magicList != null) {
				System.out.println("1.たたかう  2.かいふく  3.にげる  4,まほう");
				command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				if(command >= 1 && command <= 4){
					return command;
				}
			} else {
				System.out.println("1.たたかう  2.かいふく  3.にげる");
				command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				if(command >= 1 && command <= 3){
					return command;
				}
			}
			System.out.println(command + "が入力されました。数値を正しく入力してください。");
			System.out.println("");
		} catch (NumberFormatException e) {
	        System.out.println("数値を入力してください。");
			System.out.println("");
	    }
	}
	return 0;
  }

  public Monster selectMonster(List<Monster> monsterList) {
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
			if(command >= 1 && command <= monsterList.size()){
				return monsterList.get(command - 1);
			}
			System.out.println(command + "が入力されました。数値を正しく入力してください。");
			System.out.println("");
		} catch (NumberFormatException e) {
			System.out.println("数値を入力してください。");
			System.out.println("");
		}
	}
	return null;
  }

  // 操作の定義
  public void executeCommand(int command, List<Monster> monsterList) {
    // switch文による場合分け
    switch (command) {
      case 1:
        attack(selectMonster(monsterList));
        break;
      case 2:
        sleep();
        break;
      case 3:
        run();
        break;
      case 4:
    	useMagic(selectMonster(monsterList));
        break;
    }
  }

  public void attack(Monster m) {
	    System.out.println(this.name + "の攻撃！");
	    Random rand = new Random();
	    if (rand.nextInt(10) > 1) {
	      int finalAttackPoint = rand.nextInt(this.attackPoint + this.item.damage);
	      int finalDefencePoint = rand.nextInt(m.defencePoint);
	      int attackDamage;
	      if (finalAttackPoint > finalDefencePoint){
	    	  attackDamage = finalAttackPoint - finalDefencePoint;
	      } else {
	    	  attackDamage = 0;
	      }
	      m.hp -= attackDamage;
	      System.out.println(attackDamage + "ポイントのダメージを与えた！");
		  System.out.println("");
	      if (m.hp < 1) {
			m.die();
	      }
	    } else {
	      System.out.println("避けられた！");
		  System.out.println("");
	    }
  }

  public void useMagic(Monster m){
		if (this.magicList != null) {
		    System.out.println("どの魔法を使いますか？");
			for (int i = 0; i < this.magicList.size(); i++){
		        System.out.print(i + 1 + "." + this.magicList.get(i).name + "  ");
			}
			System.out.println("");
			try {
				int command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				if(command >= 1 && command <= this.magicList.size()){
					Magic magic = this.magicList.get(command - 1);
			        System.out.print(this.name + "はMP" + magic.lostMp + "を消費し、" + magic.name + "を使った！");
			        if (this.mp >= magic.lostMp){
			        	this.mp -= magic.lostMp;
			        	System.out.print(magic.effectValue + "ポイントのダメージを与えた！");
			    		System.out.println("");
			        	m.hp -= magic.effectValue;
				    	if (m.hp < 1) {
							m.die();
						}
			        } else {
			        	System.out.print("しかしMPが足りない！");
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
