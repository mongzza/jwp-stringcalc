import java.util.Scanner;
import java.util.regex.Matcher;

public class StringCalc {
	public static void main(String[] args) {
		StringCalc calc = new StringCalc();
		String str = calc.inputString();
		String sep = calc.getSeparator(str);
		int[] intArr = calc.splitStr(str);

		System.out.println(calc.addAll(intArr));
	}

	public String inputString() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public String getSeparator(String str) {
		String separator = new String();
		if(str.startsWith("//")) {
			separator = "\\" + str.replace("//", "").replace("\\n", "").charAt(0);
		} else {
			separator = "\\,|\\:";
		}
		return separator;
	}

	public int[] splitStr(String str) {
		String separator = this.getSeparator(str);
		str = str.substring(str.indexOf("n")+1);

		String[] strArr = str.split(separator);
		int[] intArr = new int[strArr.length];

		for(int i=0; i<strArr.length; i++) {
			if(Integer.parseInt(strArr[i]) < 0) throw new RuntimeException("음수 에러");
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

	public int addAll(int[] intArr) {
		int sum = 0;
		for(int i : intArr) {
			sum += i;
		}
		return sum;
	}
}
