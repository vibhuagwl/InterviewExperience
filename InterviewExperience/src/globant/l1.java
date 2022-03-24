package globant;

import java.util.List;
import java.util.Stack;
/*
class Pair {
	Character chr;
	int freq;
}

class Users {

}

enum Level {
	FIRST, SECOND;
}

enum GameStatus {
	STARTED, FINISHED;
}

class game {
	int gameid;
	int playerscount;

}

class RequestParam {
	private int gameid;
	private int userid;
}

class ResponseEntity {
	// gameid,userid,gamestatus,level,
}

class Weapon {
	public void weaponSelector(String weaponid);
}

class WeaponSelectorBasedOnPoints implements Weapon {
	public void weaponselector(String weaponid);
}

class WeaponSelectorBasedOnUserPerfence()
{

	}

//GameStatus
//gameid,userid,gamestatus,level,marks
//@RestController("/api/v1/")
	class GameController {
		// @PostMapping("/games/{gameid}/users/{userid}")
	public void insert(@RequestParam RequestParam requestParam)
	{
		 List< ResponseEntity> list = service.fetchGameStatus(gameid,userid);
		 list.get(0).getlevel
	}
	}*/

public class l1 {
	public static void main(String[] args) {
		String input = "aaaabbbccccdddeeaa";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			int count = 1;
			while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
				count++;
				i++;
			}
			sb.append(count + "" + input.charAt(i));
		}
		System.out.println(sb.toString());

		System.out.println(approach("aaaabbbccccdddeeaa"));
	}

	// Stack approach
	public static String approach(String str) {
		StringBuffer sb = new StringBuffer();
		Stack<Character> st = new Stack<>();
		st.push(str.charAt(0));
		int count = 1;
		int i = 0;
		for (i = 1; i < str.length(); i++) {
			if (st.peek() != str.charAt(i)) {
				sb.append(count + "" + str.charAt(i - 1));
				count = 1;
				st.push(str.charAt(i));
			} else {
				count++;
			}
		}
		if (st.peek() != str.charAt(i - 1)) {
			sb.append(count + "" + str.charAt(i - 1));
		}
		return sb.toString();
	}

}
