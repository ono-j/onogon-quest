package characters;

import java.util.Random;

public class Matango extends Monster {
  final int LEVEL = 10;
  final String NAME = "お化けキノコ";
  final int INITIAL_HP = 60;
  final int ATTACK_POINT = 40;
  final int DEFENCE_POINT = 5;
  final int SPEED_POINT = 2;

  public Matango(){
	  this.name = NAME;
	  this.hp = INITIAL_HP;
	  this.attackPoint = ATTACK_POINT;
	  this.defencePoint = DEFENCE_POINT;
	  this.speedPoint = SPEED_POINT;
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
    System.out.println(this.name + this.suffix + "は楽しそうに笑っている");
  }

  @Override
  public void die() {
	super.die();
	  System.out.println("        _,,...,_");
	  System.out.println("  /_~,,..::: ~\"'ヽ");
	  System.out.println(" (,,\"ヾ   ii  /^',).");
	  System.out.println("    :i         i\"");
	  System.out.println("     | (×o×)/");
	  System.out.println("     | （ﾉ    |");
	  System.out.println("     | ｷﾉｺ |");
	  System.out.println("     ヽ ＿ ノ");
	  System.out.println("       U\"U");

  }

}
