package characters.playerCharacters;

import java.util.Random;

import items.Sword;
import magics.Sizz;

public class Hero extends PlayerCharacter {
  // 属性の定義 (フィールド)
  int INITIAL_HP = 31; // 初期HP
  int INITIAL_MP = 16; // 初期MP
  int ATTACK_POINT = 7;
  int DEFENCE_POINT = 4;
  int SPEED_POINT = 8;

  public Hero() {
		System.out.println("勇者の名前を入力してください");
		String heroName = new java.util.Scanner(System.in).nextLine();
	    this.name = heroName;
		System.out.println("勇者"+ this.name + "はフィールドに降り立ちました！");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	    this.maxHp = INITIAL_HP;
	    this.hp = INITIAL_HP;
		System.out.println(this.name + "のHPは"+ this.hp + "です。");

		this.maxMp = INITIAL_MP;
		this.mp = INITIAL_MP;
		System.out.println(this.name + "のMPは"+ this.mp + "です。");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		setRandomMoney();
		System.out.println("所持金は" + PlayerCharacter.money + "ゴールドです。");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.attackPoint = ATTACK_POINT;
	    this.defencePoint = DEFENCE_POINT;
	    this.speedPoint = SPEED_POINT;
	    this.magicList.add(new Sizz());
	    this.loseFlag = false;
		Sword sword = new Sword();
		this.item = sword;
		System.out.println("現在の武器は攻撃力" + item.damage + "の" + item.name + "です。");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	  }

  public static void setRandomMoney() {
	  Random random = new Random();
	  PlayerCharacter.money = random.nextInt(51) + 100;
  }

  @Override
  public void sleep() {
    if (this.hp < maxHp - 20) {
      this.hp += 20;
    } else {
      this.hp = maxHp;
    }
    this.sleepFlag = true;
    System.out.println(this.name + "は、眠ってHPを" + this.hp + "まで回復した！");
	System.out.println("");
  }

  @Override
  public void run() {
	  super.run();
	  System.out.println("最終HPは" + this.hp + "でした。");
	  System.out.println("");
  }

}
