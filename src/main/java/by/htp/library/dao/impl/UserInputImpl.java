package by.htp.library.dao.impl;

import java.util.Scanner;

import by.htp.library.dao.UserInput;

public class UserInputImpl implements UserInput {

	@Override
	public String inputString() {
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		return result;
	}

	@Override
	public int inputInt() {
		Scanner sc = new Scanner(System.in);
		int result = sc.nextInt();
		return result;
	}

}
