package event;

import org.apache.commons.lang3.math.NumberUtils;

import characters.playerCharacters.PlayerCharacter;
import onogonQuestMain.Battle;

public class Gate {
	private final static int ENTRANCE_FEE = 200;
	private final static int BOSS_NO = 0;

	public static boolean payEntranceFee(PlayerCharacter pc) {
		String input;
		int command;
		System.out.println("門番「街へ入りたかったら入場料" + ENTRANCE_FEE + "ゴールドはらうことだな」");
		System.out.println("");
		System.out.println("はらいますか？");
		System.out.println("1.はい  2.いいえ");
		input = new java.util.Scanner(System.in).nextLine();
		if (NumberUtils.isNumber(input)) {
			command = Integer.parseInt(input);
			switch (command) {
			case 1:
				int myMoney = pc.getMoney();
				if (myMoney >= 200) {
					pc.setMoney(myMoney - ENTRANCE_FEE);
					System.out.println(pc.name + " は " + ENTRANCE_FEE + "ゴールド払った");
					System.out.println("");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					startEvent(pc);
					return true;
				} else {
					System.out.println("門番「おいおい、 " + myMoney + "ゴールドしか持ってないじゃないか");
					System.out.println("      外でモンスターでも狩って 稼いできな！」");
					System.out.println(pc.name + " は つまみ出された！");
					System.out.println("");
				}
				break;
			case 2:
				System.out.println(pc.name + " は フィールドに出た！");
				System.out.println("");
				break;
			default:
				System.out.println("門番「答えになってねーよ」");
				System.out.println(pc.name + " は つまみ出された！");
				System.out.println("");
				break;
			}
		} else {
			System.out.println("門番「答えになってねーよ」");
			System.out.println(pc.name + " は つまみ出された！");
			System.out.println("");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void startEvent(PlayerCharacter pc) {
		System.out.println("門番「・・・待て」");
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("門番「お前、さては勇者だな？」");
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("門番「ここは通すなとオノゴン様から言われている」");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("門番はなんとモンスターだった！");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Battle.startEventBattle(pc, BOSS_NO);
		if (!pc.loseFlag) {
			enterCity(pc);
		}

	}

	private static void enterCity(PlayerCharacter pc) {
		System.out.println("");
		System.out.println("");
		System.out.println(pc.name + " は 街に入った！");
		System.out.println("");
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pc.name + " を この先 待っているのは、");
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("天国か、それとも地獄か、");
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pc.name + " の 冒険は続く！");
		System.out.println("");
		System.out.println("");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("┼ヽ   -|r‐､.  ﾚ  |");
		System.out.println("ｄ⌒)  ./|  _ﾉ   __ﾉ");
	}

}
