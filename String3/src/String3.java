import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String3 {

	// return do not match characters
	public ArrayList<String> doNotMatch(String s1, String s2) {
		ArrayList<String> arr = new ArrayList<String>();
		String out = "";
		int len = s1.length();
		for (int i = 0; i < len; i++) {
			char ch1 = s1.charAt(i);
			char ch2 = s2.charAt(i);
			if (ch1 != ch2) {
				out = ch1 + "" + ch2;
				arr.add(out);
			}
		}
		return arr;
	}

//remove palindrome
	public String removePalindrome(String inp) {
		String out = "";
		String[] arr = inp.split(" ");
		for (int i = 0; i < arr.length; i++) {
			StringBuilder strBuild = new StringBuilder(arr[i]);
			strBuild.reverse();
			if (arr[i].equals(strBuild.toString())) {
				arr[i] = "";
			}
			out += arr[i];
		}
		return out;
	}

//check if string is rotated
	public Boolean checkRotation(String str1, String str2) {
		int len = str1.length() - 1;
		boolean bool = false;
		if (str2.charAt(len - 1) == str1.charAt(0) && str2.charAt(len) == str1.charAt(1)) {
			String out = str2.substring(0, str1.length() - 2);
			String out1 = str1.substring(2, str1.length());
			if (out.equals(out1)) {
				bool = true;
			}
		}
		if (str1.charAt(len - 1) == str2.charAt(0) && str1.charAt(len) == str2.charAt(1)) {
			String out2 = str1.substring(0, str1.length() - 2);
			String out3 = str2.substring(2, str1.length());
			if (out2.equals(out3)) {
				bool = true;
			}
		}
		return bool;
	}

	// non repeating
	public String firstNonRepeating(String s) {
		s = s.toLowerCase();
		char ch = 0;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (s.indexOf(ch) == s.lastIndexOf(ch)) {
				return ch + "";
			}
		}
		return "no matching character";
	}

	public ArrayList<String> possibleString(String[] arr) {
		ArrayList<String> arrList = new ArrayList<String>();
		String out = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					out = arr[i];
				} else {
					out = arr[i] + arr[j];
				}
				arrList.add(out);
			}
		}
		return arrList;
	}

	// longest non repeating substring
	public int longestUniqueSubsttr(String S) {
		ArrayList<Character> al = new ArrayList<>();
		int j = 0, max = 0;
		while (j < S.length()) {
			if (al.contains(S.charAt(j))) {
				al.remove(0);
			} else {
				al.add(S.charAt(j));
				max = Math.max(max, al.size());
				j++;
			}
		}
		return max;
	}

//anagram checker
	boolean areKAnagrams(String s1, String s2, int k) {
		int count = 0;
		char ch = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			ch = s1.charAt(i);
			if (map.get(ch) != null) {
				count++;
				map.put(ch, count);
			}
		}
		if (k >= count) {
			return true;
		}
		return false;
	}

//common fragments in all strings
	public Object commonFragment(String[] s1) {
		String temp = "";
		int count = 0;
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < s1[0].length(); i++) {
			if (s1[0].charAt(i) == ' ') {
				if (fragmentChecker(s1, temp) && count < 3) {
					count++;
					arr.add(temp);
					temp = temp + " ";
				} else {
					if (count == 3) {
						return arr.get(arr.size() - 1);
					} else {
						arr.clear();
					}
					count = 0;
					temp = "";
				}
			} else {
				temp += s1[0].charAt(i);
			}
		}
		// for the ending
		temp = temp.trim();
		if (fragmentChecker(s1, temp) && count < 3) {
			count++;
			arr.add(temp);
			if (count == 3) {
				return arr.get(arr.size() - 1);
			}
		}
		return "no consecutive same words";
	}

	public boolean fragmentChecker(String[] s1, String temp) {
		boolean bool[] = new boolean[s1.length];
		for (int i = 0; i < s1.length; i++) {
			if (s1[i].contains(temp)) {
				bool[i] = true;
			}

		}
		for (boolean boo : bool) {
			if (!boo) {
				return false;
			}
		}

		return true;
	}

//magic string
	public boolean magicString(String s1, String s2) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		char ch1 = 'z';
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			map.put(ch, ch1);
			ch1--;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (map.get(s1.charAt(i)) != s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

//calculation of weight after balance point
	public String balancePoint(String inp, int len) {
		int j = 1;
		if (len == inp.length() - 1) {
			return "not balanced";
		}
		char ch1 = inp.charAt(len);
		int out = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			map.put(ch, j);
			j++;
		}
		j = 1;
		int output = 0;
		int ind = inp.indexOf(ch1);
		for (int i = ind + 1; i < inp.length(); i++) {
			output += j * map.get(inp.charAt(i));
			j++;
		}
		j = 1;
		for (int i = 0; i < ind; i++) {
			out += j * map.get(inp.charAt(i));
			j++;
		}
		if (output - out == 0) {
			return "balanced at " + inp.charAt(len);
		} else {
			return balancePoint(inp, len + 1);
		}
	}

	public String numberToEnglish(int num) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "fourty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
		map.put(100, "hundred");
		map.put(1000, "thousand");

		StringBuilder inp = new StringBuilder(Integer.toString(num));
		int length = inp.length();
		int out = 1;
		String output = "";
		for (int i = 0; i < length - 1; i++) {
			out *= 10;
			if (i == length - 2 && inp.length() > 2) {
				output += " " + map.get(Integer.parseInt(inp.charAt(0) + ""));
				inp.deleteCharAt(0);
				output += " " + map.get(out);
				i = 0;
				length = length - 1;
				out = 10;
			}
		}
		if (map.get(Integer.parseInt(inp.charAt(0) + "0")) != null) {
			if (output.length() > 1) {
				output += " and " + map.get(Integer.parseInt(inp.charAt(0) + "0"));
			} else {
				output += " " + map.get(Integer.parseInt(inp.charAt(0) + "0"));
			}
			inp.deleteCharAt(0);
		}
		if (map.get(Integer.parseInt(inp + "")) != null) {
			output += " " + map.get(Integer.parseInt(inp + ""));
		}
		return output.trim();
	}

	public void shuffle(int[] nums, int n) {
		List<Integer> arr1 = new ArrayList<Integer>();
		for (int geek : nums) {
			arr1.add(geek);
		}

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 1) {
				arr1.add(i, nums[n]);
				n++;
			}
		}
		for (int i = nums.length; i < arr1.size() + 1; i++) {
			arr1.remove(arr1.size() - 1);
		}
		System.out.println(arr1);
	}

	public int firstNonRepeating(int arr[], int n) {
		for (int i = 0; i < arr.length; i++) {

		}
		return 0;
	}

	int minDist(int a[], int n, int x, int y) {

		List<Integer> arr = new ArrayList<Integer>();
		for (int geek : a) {
			arr.add(geek);
		}
		int pos = arr.indexOf(x);
		int pos1 = arr.indexOf(y);
		if (pos == -1 || pos1 == -1) {
			return -1;
		}
		if (pos1 - pos > 0) {
			return pos1 - pos;
		} else {
			return pos - pos1;
		}
	
	}

	public static void main(String[] args) {
		String3 strObj = new String3();

//		System.out.print(strObj.doNotMatch("abcddefgikom","abdcdeffgklm"));
//		System.out.print(strObj.removePalindrome("He did a good deed"));
//		System.out.println(strObj.firstNonRepeating("Character"));
//		System.out.println(strObj.longestUniqueSubsttr("abcdeab"));
//		System.out.println(strObj.areKAnagrams("ukdbgygrsjlaukwsgc","memdwhetaewfahkc",14));
//		System.out.println(strObj.encode("abcdeab"));
//		String[] arr = { "a", "b", "c" };
//		System.out.println(strObj.possibleString(arr));
		String[] s1 = { "Every morning I want to", "Every morning I want to", "It is important that I want to" };
		System.out.println(strObj.commonFragment(s1));
//		System.out.println(strObj.magicString("abc", "zyx"));
//		System.out.println(strObj.balancePoint("aabc",1));
//		System.out.println(strObj.numberToEnglish(5000));
//		System.out.println(strObj);

//	strObj.shuffle(arr, 3);
//		System.out.println(strObj.firstNonRepeating(arr, 5));
//		System.out.println(strObj.minDist(arr, 62, 36,33));
	}

}
