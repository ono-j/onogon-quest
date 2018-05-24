package onogonQuestMain;

import characters.monsters.Monster;
import magics.Magic;

public class CommandList {
	private int action;
	private Magic magic;
	private Monster target;

	public int getAction(){
		return this.action;
	}

	public void setAction(int action){
		this.action = action;
	}

	public Magic getMagic(){
		return this.magic;
	}

	public void setMagic(Magic magic){
		this.magic = magic;
	}

	public Monster getTarget(){
		return this.target;
	}

	public void setTarget(Monster target){
		this.target = target;
	}
}
