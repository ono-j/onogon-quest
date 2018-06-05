package onogonQuestMain;

import org.apache.commons.lang3.math.NumberUtils;

import characters.playerCharacters.Hero;
import event.Gate;
import onogonQuestMain.data.Data;
import onogonQuestMain.data.DataBaseConnector;

/**
 * @author Junya
 *
 */
public class Main {

	//	ここからMainメソッド
	public static void main(String[] args) {
		int command;
		String input;
		Hero hero = null;
		boolean loadChosen = false;
		while (!loadChosen) {
			System.out.println("1.つづきから  2.はじめから");
			input = new java.util.Scanner(System.in).nextLine();
			if (NumberUtils.isNumber(input)) {
				command = Integer.parseInt(input);
				switch (command) {
				case 1:
					// 勇者をロード
					Data data = DataBaseConnector.load();
					hero = new Hero(data);
					loadChosen = true;
					break;
				case 2:
					// 勇者を生成
					hero = new Hero();
					loadChosen = true;
					break;
				default:
					System.out.println(input + "が入力されました。数値を正しく入力してください。");
					System.out.println("");
				}
			} else {
				System.out.println(input + "が入力されました。数値を正しく入力してください。");
				System.out.println("");
			}
		}

		// 行動を選択
		boolean gameFinished = false;
		while (!gameFinished && !hero.loseFlag) {
			System.out.println("コマンドを入力してください。");
			System.out.println("1.街へ入る  2.モンスターとたたかう  3.セーブして終了");
			input = new java.util.Scanner(System.in).nextLine();
			if (NumberUtils.isNumber(input)) {
				command = Integer.parseInt(input);
				Gate gate = new Gate();
				switch (command) {
				case 1:
					gameFinished = gate.payEntranceFee(hero);
					break;
				case 2:
					Battle.startBattle(hero);
					System.out.println("");
					break;
				case 3:
					System.out.println("データをセーブして、ゲームを終了します。");
					DataBaseConnector.save(hero);
					System.out.println("お疲れ様でした。");
					gameFinished = true;
					break;
				default:
					System.out.println(input + "が入力されました。数値を正しく入力してください。");
					System.out.println("");
					break;
				}
			} else {
				System.out.println(input + "が入力されました。数値を正しく入力してください。");
				System.out.println("");
			}
		}

	}

}
