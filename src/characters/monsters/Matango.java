package characters.monsters;

import java.util.Random;

import characters.playerCharacters.PlayerCharacter;

public class Matango extends Monster {
  final int LEVEL = 10;
  final String NAME = "お化けキノコ";
  final int INITIAL_HP = 13;
  final int ATTACK_POINT = 11;
  final int DEFENCE_POINT = 12;
  final int SPEED_POINT = 2;
  final int AVOID_POINT = 1;
  final int MAGIC_AVOID_POINT = 0;
  final int MONEY = 50;

  public Matango(int i){
	  this.order = i;
	  this.name = NAME;
	  this.hp = INITIAL_HP;
	  this.attackPoint = ATTACK_POINT;
	  this.defencePoint = DEFENCE_POINT;
	  this.speedPoint = SPEED_POINT;
	  this.avoidPoint = AVOID_POINT;
	  this.magicAvoidPoint = MAGIC_AVOID_POINT;
	  this.money = MONEY;
	  this.looseFlag = false;
  }

  @Override
  public void appear() {
	  System.out.println("        _,,...,_");
	  System.out.println("  /_~,,..::: ~\"'ヽ");
	  System.out.println(" (,,\"ヾ   ii  /^',).");
	  System.out.println("    :i         i\"");
	  System.out.println("     | ( ﾟДﾟ)/");
	  System.out.println("     | （ﾉ    |");
	  System.out.println("     | ｷﾉｺ |");
	  System.out.println("     ヽ ＿ ノ");
	  System.out.println("       U\"U");
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
        noAction();
        break;
      case 9:
        run();
        break;
    }
  }


  public void noAction() {
    System.out.println(this.name + "は楽しそうに笑っている");
  }

  @Override
  public void die(PlayerCharacter pc) {
	  System.out.println("        _,,...,_");
	  System.out.println("  /_~,,..::: ~\"'ヽ");
	  System.out.println(" (,,\"ヾ   ii  /^',).");
	  System.out.println("    :i         i\"");
	  System.out.println("     | (×o×)/");
	  System.out.println("     | （ﾉ    |");
	  System.out.println("     | ｷﾉｺ |");
	  System.out.println("     ヽ ＿ ノ");
	  System.out.println("       U\"U");
	  super.die(pc);
  }

}
