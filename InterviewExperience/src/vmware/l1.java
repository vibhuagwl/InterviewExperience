package vmware;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//lru cache
//intersectionof two ll
//zero and one sepration in array
//median of two linkedlist
//buddy string
// diagnol printing matrix
// knapsack kind of problem
class A {
	public int add(int x, int y) {
		return x + y;
	}
}

class B extends A {
	public int add(int x, int y) {
		return x * y;
	}

	public int sum(int x, int y) {
		return x + y;
	}
}

public class l1 {

	public boolean buddyStrings1(String s, String goal) {
		if (s.length() != goal.length())
			return false;
		// we cannot swap any character if s.length() ==1.
		if (s.length() == 1)
			return false;
		// number of different characters at same index in two string.
		int differentCharacter = 0;
		// index that characters are different
		int[] index = new int[2];
		// pointer of index
		int temp = 0;
		// count differentCharacters
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (differentCharacter < 2) {
					differentCharacter++;
					index[temp++] = i;
				} else
					return false;
			}
		}
		// if two strings are equal,if length =1 return true, or we need to see if they
		// contains any character more
		// than once;
		if (differentCharacter == 0) {
			if (s.length() == 1)
				return true;
			// count 26 lowercase character
			int[] count = new int[26];
			for (char ch : s.toCharArray()) {
				count[ch - 'a']++;
				if (count[ch - 'a'] > 1)
					return true;
			}
			return false;
		}
		if (s.charAt(index[0]) == goal.charAt(index[1]) && s.charAt(index[1]) == goal.charAt(index[0]))
			return true;
		return false;
	}

	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length())
			return false;
		if (A.equals(B)) {
			Set<Character> set = new HashSet<>();
			for (char c : A.toCharArray())
				set.add(c);
			return set.size() < A.length();
		} else {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < A.length(); i++)
				if (A.charAt(i) != B.charAt(i))
					list.add(i);
			return list.size() == 2 && A.charAt(list.get(0)) == B.charAt(list.get(1))
					&& B.charAt(list.get(0)) == A.charAt(list.get(1));
		}
	}

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.add(4, 8));
		System.out.println(((B) a).sum(4, 8));
		l1 l = new l1();
		l.buddyStrings("aaaaa", "aaaaa");
	}
}
