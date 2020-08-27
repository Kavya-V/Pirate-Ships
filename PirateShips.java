package com.inffrd.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Kavya
 *
 */
public class PirateShips {

	static boolean sig = false;
	static int count = 0;

	public static void main(String[] args) {
		// Read the Loot levels
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter total number of Loot levels:");
		int size = ip.nextInt();
		
		Integer lootArray[] = new Integer[size];
		System.out.println("Enter each loot level:");

		for (int i = 0; i < size; i++) {
			lootArray[i] = ip.nextInt();
		}
		lootArray = verifyWithLeftElement(lootArray);
	}
	
	/**
	 * 
	 * Validate the loot with pre element
	 * @param lootDays
	 * @return
	 */
	private static Integer[] verifyWithLeftElement(Integer[] lootDays) {
		for (int i = 0; i < lootDays.length; i++) {
			if (i + 1 < lootDays.length) {
				if (lootDays[i] < lootDays[i + 1]) {
					sig = true;
					lootDays = deleteElement(lootDays, i + 1);
				} else {
					sig = false;
				}
			}

		}

		if (sig) {
			count++;
			System.out.println("\n Total no. of days to stop destroy: " + count + " for the loot levels ");
			for (int i = 0; i < lootDays.length; i++) {
				System.out.print(" " + lootDays[i]);
			}
			return verifyWithLeftElement(lootDays);

		} else {
			return lootDays;
		}

	}
	
	/**
	 * Delete the element
	 * @param arr
	 * @param i
	 * @return
	 */
	public static Integer[] deleteElement(Integer[] arr, int i) {
		ArrayList<Integer> response = new ArrayList<Integer>(Arrays.asList(arr));
		response.remove(i);
		return response.toArray(new Integer[0]);
	}
}
