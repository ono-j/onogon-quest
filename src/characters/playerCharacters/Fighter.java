package characters.playerCharacters;

import characters.monsters.Monster;
import items.Sword;

public class Fighter extends PlayerCharacter {
  // 属性の定義 (フィールド)
  int INITIAL_HP = 150;
  int INITIAL_MP = 0;
  int ATTACK_POINT = 20;
  int DEFENCE_POINT = 10;
  int SPEED_POINT = 8;
  static int money;

  public Fighter() {
		System.out.println("勇者の名前を入力してください");
		String heroName = new java.util.Scanner(System.in).nextLine();
	    this.name = heroName;
		System.out.println("勇者"+ this.name + "を召喚しました！");
		System.out.println("");

	    this.maxHp = INITIAL_HP; // hpを100で初期化
	    this.hp = INITIAL_HP; // hpを100で初期化
		System.out.println(this.name + "のHPは"+ this.hp + "です。");

		this.maxMp = INITIAL_MP;
		this.mp = INITIAL_MP;
		System.out.println(this.name + "のMPは"+ this.mp + "です。");

		setRandomMoney();
		System.out.println("所持金は" + Fighter.money + "ゴールドです。");

		this.attackPoint = ATTACK_POINT;
	    this.defencePoint = DEFENCE_POINT;
	    this.speedPoint = SPEED_POINT;
	    this.loseFlag = false;
		Sword sword = new Sword();
		this.item = sword;
		System.out.println("現在の武器は攻撃力" + item.damage + "の" + item.name + "です。");
		System.out.println("");

	  }

  public static void setRandomMoney() {
    Fighter.money = (int) (Math.random() * 1000);
  }


  // 操作の定義
  public void executeCommand(int command, Monster m) {
    // switch文による場合分け
    switch (command) {
      case 1:
        attack(m);
        break;
      case 2:
        sleep();
        break;
      case 3:
        run();
        break;
      case 4:
        break;
    }
  }

  @Override
  public void sleep() {
    if (this.hp < INITIAL_HP - 30) {
      this.hp += 30;
    } else {
      this.hp = INITIAL_HP;
    }
    this.sleepFlag = true;
    System.out.println(this.name + "は、眠ってHPを" + this.hp + "まで回復した！");
  }

  @Override
  public void run() {
	  super.run();
	  System.out.println("最終HPは" + this.hp + "でした。");
  }

}
