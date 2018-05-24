package onogonQuestMain;

import characters.playerCharacters.Hero;

/**
 * @author Junya
 *
 */
public class Main {

	//	ここからMainメソッド
	public static void main(String[] args) {

//		Sample sample = new Sample();

		// 1. 勇者を生成
		Hero hero = new Hero();

		// 2. 行動を選択
		int command;
		boolean gameFinished = false;
		while(!gameFinished && !hero.looseFlag){
			try {
				System.out.println("コマンドを入力してください。");
				System.out.println("1.街へ入る  2.モンスターとたたかう  3.ゲーム終了");
				command = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
				Gate gate = new Gate();
				if(command == 1){
					gameFinished = gate.payEntranceFee(hero);
				} else if(command == 2){
					Battle.startBattle(hero);
					System.out.println("");
				} else if(command == 3){
					System.out.println("ゲームを終了します。");
					System.out.println("お疲れ様でした。");
					gameFinished = true;
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

}