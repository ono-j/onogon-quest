package onogonQuestMain;

import characters.playerCharacters.PlayerCharacter;

public class Gate {
	private final static int ENTRANCE_FEE = 200;
	public static boolean payEntranceFee(PlayerCharacter pc){
		int command;
		System.out.println("門番「街へ入りたかったら入場料" + ENTRANCE_FEE + "ゴールドはらうことだな」");
		System.out.println("");
		System.out.println("はらいますか？");
		System.out.println("1.はい  2.いいえ");
		try {
			command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
			if(command == 1){
				int myMoney = pc.getMoney();
				if (myMoney >= 200){
					pc.setMoney(myMoney - ENTRANCE_FEE);
					System.out.println(pc.name + " は " + ENTRANCE_FEE + "ゴールド失った");
					System.out.println("");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					enterCity(pc);
					return true;
				} else {
					System.out.println("門番「おいおい、 " + myMoney + "ゴールドしか持ってないじゃないか");
					System.out.println("      外でモンスターでも狩って 稼いできな！」");
					System.out.println("");
				}
			} else if(command == 2){
				System.out.println(pc.name + " は フィールドに出た！");
				System.out.println("");
			} else {
				System.out.println("門番「答えになってねーよ」");
				System.out.println(pc.name + " は つまみ出された！");
				System.out.println("");
			}
		} catch (NumberFormatException e) {
			System.out.println("門番「答えになってねーよ」");
			System.out.println(pc.name + " は つまみ出された！");
			System.out.println("");
		}
		return false;

	}

	private static void enterCity(PlayerCharacter pc){
		System.out.println(pc.name + " は 街に入った！");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pc.name + " を この先 待っているのは、");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("天国か、それとも地獄か、");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pc.name + " の 冒険は続く！");
		System.out.println("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("┼ヽ   -|r‐､.  ﾚ  |");
		System.out.println("ｄ⌒)  ./|  _ﾉ   __ﾉ");
	}

}
