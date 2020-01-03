package com.revature;

import java.util.Random;

public final class RandomGenerator {
	
	public static Integer getNumbers(Integer length) {
		Random random = new Random();
		switch (length) {
		case 5 : return random.nextInt(100000);
		case 4 : return random.nextInt(10000);
		case 3 : return random.nextInt(1000);
		case 2 : return random.nextInt(100);
		case 1 : return random.nextInt(10);
		default : return 0;
		}
	}
	
}
