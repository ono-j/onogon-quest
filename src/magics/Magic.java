package magics;

import characters.monsters.Monster;
import characters.playerCharacters.PlayerCharacter;

public abstract class Magic {
	public String name;
	public int lostMp;
	public int effectValue;

	public abstract void cast(PlayerCharacter pc, Monster m);
}
