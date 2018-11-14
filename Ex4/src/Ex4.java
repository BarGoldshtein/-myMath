public class Ex4 {


	public static long robotAttacks(long start, long encounter, long target) {
		if ((start > target && encounter == 0) || start == 0) {//if the start number is bigger then target and encounter = 0 or start = 0 the function will not run
			return -1;
		} 
		else {
			if (start >= target) {//if the start is bigger or equal to the target 
				return 0;
			}
			start = start + (encounter * start);//if the start is little then the target every turn start is getting bigger by the the encounter * start
			return robotAttacks(start, encounter, target) + 1;//every turn when the func calling itself its write 1 and when its stop its write 0 and then counting the +1's
		}
	}
	public static void sortByFreq(double[] arr) {
		double[] arr2 = new double[arr.length];//making new array that will resamle how much times a number is showen
		for (int i = 0; i < arr.length; i++) {//copying the first array
			arr2[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {//for that filling the arr2 with the times number shown instand of the number
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					arr2[i] = count;
				}
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {//this 2 fors will arrange the first array according to the times number are shown
			for (int j = arr.length - 1; j >= 0; j--) {
				if (arr2[i] < arr2[j]) {
					double temp = arr[i];//arrange the first array
					arr[i] = arr[j];
					arr[j] = temp;
					double temp2 = arr2[i];//changing also arr2 according to the first array so its wont make mistake in the if 
					arr2[i] = arr2[j];
					arr2[j] = temp2;
				}
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {//this 2 for will arrange the arr acording to the number so 4.0 will be near 4.0
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i < j) {
					if (i != arr.length - 1) {
						double temp = arr[(i + 1)];
						arr[(i + 1)] = arr[j];
						arr[j] = temp;
						if (i == 0 && j > arr2[0]) {
							i = arr.length - 1;
						}
					}
				}
			}
		}
	}

	public static int minSwaps(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {// in this for we will look for 1 and when we will find it we will go to the second for
			if (arr[i] == 1) {
				for (int j = arr.length - 1; j > i; j--) {//in this for we will go backward from the end of the array and look for 0 when we find it count will go +1 
					if (arr[j] == 0) {
						count++;
					}
				}
			}
		}
		return count;//the times of count is the minimum swaps we need to arrange the array
	}

	public static void calculator() {
		char[] abc = new char[26];//making and array of chars and fill it with a-z
		for (int i = 0; i < abc.length; i++) {
			abc[i] = (char) (i + 97);
		}
		boolean[] identifier = new boolean[26];//making an boolean array in the size of a-z so we can know if an variable is initialized

		double[] num = new double[26];//an double array for placing the initialized variable numbers
		int go = 1;
		while (go != 0) {// while go = 1 the function will run
			String pelet = MyConsole.readString(">");//getting an input from the user
			if (pelet.length()>2 && pelet.length()<5 && pelet.length()<9){// this if is input check for the user to know if he enter a good input
				System.out.println("invaild input");
			}
			else {//if the user enter a good input its will enter the function
				String[] m = pelet.split(" ");//split the input according to space
				if (m.length == 1) {//Checking the size of the new array after the split
					if (m[0].equals("Exit")) {//if its Exit the function end
						System.out.println("Good bye....");
						go = 0;
					}
					else if (Character.isLetter(m[0].charAt(0))) {//if its an letter
						if (identifier[m[0].codePointAt(0) - 97]) {//Checking if it initialized
							System.out.println(num[m[0].codePointAt(0) - 97]);
						} 
						else {
							System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0] + " ' was found");//if the variable is not initialized
						}
					}
					else {
						System.out.println(m[0]);//if its not a letter will print the number out
					}
				}
				if (m.length == 3) {//if the size is 3
					if (m[0].contains("-") == false && m[2].contains("-") == false) {//and no -
						if (m[1].equals("=")) {//if = is in the middle
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(0))) {//Checking if both side are letters
								if(identifier[m[2].codePointAt(0) - 97]){//Checking if the left side is initialized
									num[m[0].codePointAt(0) - 97]=num[m[2].codePointAt(0) - 97];
									identifier[m[0].codePointAt(0) - 97] = true;//the variable is now initialized
								}
								System.out.println(num[m[0].codePointAt(0) - 97]);
							}
							else {
								identifier[m[0].codePointAt(0) - 97] = true;//the variable is now initialized
								num[m[0].codePointAt(0) - 97] = Double.parseDouble(m[2]);//initialized the variable
								System.out.println(num[m[0].codePointAt(0) - 97]);
							}
						}
						if (m[1].equals("+")) {//if it the operator + in the middle
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(0))) {//Checking if both side are letters
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(0) - 97]) {//if they both letter checking if they initialized
									System.out.println((num[m[0].codePointAt(0) - 97]) + (num[m[2].codePointAt(0) - 97]));
								} 
								else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is letter and not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0] + "' was found");
								} else if (identifier[m[2].codePointAt(0) - 97] == false) {//if right side is letter and not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							}
							else if (Character.isLetter(m[0].charAt(0))) {// checking if only left side is letter
								if (identifier[m[0].codePointAt(0) - 97]) {//checking if the letter is initialized
									System.out.println((num[m[0].codePointAt(0) - 97]) + Double.parseDouble(m[2]));
								}

							} 
							else if (Character.isLetter(m[2].charAt(0))) {//checking if only right side is letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if the letter is initialized
									System.out.println((num[m[2].codePointAt(0) - 97]) + Double.parseDouble(m[0]));
								}
							}
							else {
								System.out.println(Double.parseDouble(m[0]) + Double.parseDouble(m[2]));//if they both numbers
							}
						} else if (m[1].equals("-")) {//if its the operator -
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(0))) {//checking if both letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(0) - 97]) {//checking if both variable are initialized 
									System.out.println((num[m[0].codePointAt(1) - 97]) - (num[m[2].codePointAt(0) - 97]));
								} 
								else if (identifier[m[0].codePointAt(0) - 97] == false) {//checking if the left side is letter and not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(0) - 97] == false) {//checking is the right side is letter and not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} else if (Character.isLetter(m[0].charAt(0))) {//Checking if only the left side is letter
								if (identifier[m[0].codePointAt(0) - 97]) {//Checking if the letter is initialized
									System.out.println((num[m[0].codePointAt(1) - 97]) - Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[2].charAt(0))) {//Checking if the right side is letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if the letter is initialized
									System.out.println(Double.parseDouble(m[0]) - (num[m[2].codePointAt(0) - 97]));
								}
							}

							else {//if they both numbers
								System.out.println(Double.parseDouble(m[0]) - Double.parseDouble(m[2]));
							}

						}
						if (m[1].equals("*")) {//checking if it the operator * in the middle
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(0))) {//Checking if both side are letters
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(0) - 97]) {//checking if both side are initialized
									System.out.println((num[m[0].codePointAt(0) - 97]) * (num[m[2].codePointAt(0) - 97]));
								} 
								else if (identifier[m[0].codePointAt(0) - 97] == false) {//checking if left side is initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0] + "' was found");
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//checking if  right side is initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} else if (Character.isLetter(m[0].charAt(0))) {//checking if only left side is letter
								if (identifier[m[0].codePointAt(0) - 97]) {//Checking if left side is initialized
									System.out.println((num[m[0].codePointAt(0) - 97]) * Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[2].charAt(0))) {//Checking if only right side is letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if the right side is initialized
									System.out.println((num[m[2].codePointAt(0) - 97]) * Double.parseDouble(m[0]));
								}
							}

							else {// if both are numbers
								System.out.println(Double.parseDouble(m[0]) * Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("/")) {//checking if the operator / is in the middle
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(0))) {//Checking if both letter
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(0) - 97]) {// checking if both initialized
									System.out.println((num[m[0].codePointAt(0) - 97]) / (num[m[2].codePointAt(0) - 97]));
								} 
								else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0] + "' was found");
								} else if (identifier[m[2].codePointAt(0) - 97] == false) {//if right size is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} else if (Character.isLetter(m[0].charAt(0))) {// checking if only left side is letter
								if (identifier[m[0].codePointAt(0) - 97]) {//checking if left side is initialized
									if (Double.parseDouble(m[2])==0) {
										System.out.println("cannot divine by 0");
									}
									else {
										System.out.println((num[m[0].codePointAt(0) - 97]) / Double.parseDouble(m[2]));
									}
								}
							} else if (Character.isLetter(m[2].charAt(0))) {//checking if only right size is letter
								if (identifier[m[2].codePointAt(0) - 97]) {//Checking if right side is initialized
									System.out.println(Double.parseDouble(m[0]) / (num[m[2].codePointAt(0) - 97]));
								}
							}

							else {//if both are numbers
								if (Double.parseDouble(m[2])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									System.out.println(Double.parseDouble(m[0]) / Double.parseDouble(m[2]));
								}
							}
						}

					}
					else if(m[0].contains("-") && m[2].contains("-")) {// if both sides contains -
						if (m[1].equals("=")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(1))) {//if both side are letters
								if(identifier[m[2].codePointAt(1) - 97]) {//checking if right size is initialized
									num[m[0].codePointAt(1) - 97]=(num[m[2].codePointAt(1) - 97]);
									identifier[m[0].codePointAt(1) - 97] = true;//variable is now initialized
								}
								System.out.println(num[m[0].codePointAt(1) - 97]);
							}
							else {
								identifier[m[0].codePointAt(1) - 97] = true;//variable is now initialized
								num[m[0].codePointAt(1) - 97] = Double.parseDouble(m[2]);
								System.out.println(num[m[0].codePointAt(1) - 97]);
							}
						}
						if (m[1].equals("+")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(1))) {//checking if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if both are initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) + ((num[m[2].codePointAt(1) - 97])*(-1)));
								} 
								else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized 
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if left side is initialized 
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) + Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[2].charAt(1))) {//if only right side is letter 
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[2].codePointAt(1) - 97])*(-1)) + Double.parseDouble(m[0]));
								}
							}

							else {//if both are numbers
								System.out.println(Double.parseDouble(m[0]) + Double.parseDouble(m[2]));
							}
						} else if (m[1].equals("-")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(1))) {//checking if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if both initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) - ((num[m[2].codePointAt(1) - 97])*(-1)));
								} else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) - Double.parseDouble(m[2]));
								}
							} 
							else if (Character.isLetter(m[2].charAt(1))) {//if only right side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(Double.parseDouble(m[0])- (num[m[2].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if both are numbers
								System.out.println(Double.parseDouble(m[0]) - Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("*")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(1))) {//if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if they are initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) * (num[m[2].codePointAt(1) - 97])*(-1));
								} else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							}
							else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) * Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[2].charAt(1))) {//if only right side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(Double.parseDouble(m[0])*(num[m[2].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if both are numbers
								System.out.println(Double.parseDouble(m[0]) * Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("/")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(1))) {//if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) / ((num[m[2].codePointAt(1) - 97])*(-1)));
								}
								else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if it initialized
									if (Double.parseDouble(m[2])==0) {// if right side = 0
										System.out.println("cannot divine by 0");
									}
									else {
										System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) / Double.parseDouble(m[2]));
									}
								}
							} 
							else if (Character.isLetter(m[2].charAt(1))) {//if only right side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if right side is initialized 
									System.out.println(Double.parseDouble(m[0])/(num[m[2].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[2])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									System.out.println(Double.parseDouble(m[0]) / Double.parseDouble(m[2]));
								}
							}
						}
					}	

					else if (m[0].contains("-")) {// - in left side
						if (m[1].equals("=")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(0))) {//if both side are letters
								if(identifier[m[2].codePointAt(0) - 97]) {//checking if right side is initialized
									num[m[0].codePointAt(1) - 97]=(num[m[2].codePointAt(0) - 97])*(-1);
									identifier[m[0].codePointAt(1) - 97] = true;
									System.out.println((num[m[0].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if left side is a number
								identifier[m[0].codePointAt(1) - 97] = true;
								num[m[0].codePointAt(1) - 97] = Double.parseDouble(m[2]);
								System.out.println(num[m[0].codePointAt(1) - 97]);
							}
						}
						if (m[1].equals("+")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(0))) {// if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(0) - 97]) {//checking if both initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) + (num[m[2].codePointAt(0) - 97]));
								}
								else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} 
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) + Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[2].charAt(0))) {//if only right side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println((num[m[2].codePointAt(0) - 97]) + Double.parseDouble(m[0]));
								}
							}

							else {//if both are number
								System.out.println(Double.parseDouble(m[0]) + Double.parseDouble(m[2]));
							}
						} 
						else if (m[1].equals("-")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(0))) {//if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(0) - 97]) {//checking if they are initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) - (num[m[2].codePointAt(0) - 97]));
								} else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) - Double.parseDouble(m[2]));
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {//checking if only right side is letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println((num[m[0].codePointAt(1) - 97]) - Double.parseDouble(m[2]));
								}
							}
							else {//if both are numbers
								System.out.println(Double.parseDouble(m[0]) - Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("*")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(0))) {//if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(0) - 97]) {//checking if they are initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) * (num[m[2].codePointAt(0) - 97]));
								} else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							}
							else if (Character.isLetter(m[0].charAt(1))) {//if only left side is letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) * Double.parseDouble(m[2]));
								}

							} 
							else if (Character.isLetter(m[2].charAt(0))) {//if only right side is letter 
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println((num[m[2].codePointAt(0) - 97]) * Double.parseDouble(m[0]));
								}
							}
							else {//if both are numbers
								System.out.println(Double.parseDouble(m[0]) * Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("/")) {
							if (Character.isLetter(m[0].charAt(1)) && Character.isLetter(m[2].charAt(0))) {//if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[2].codePointAt(0) - 97]) {//checking if they are initialized
									System.out.println(((num[m[0].codePointAt(1) - 97]) * (-1)) / (num[m[2].codePointAt(0) - 97]));
								}
								else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[0].charAt(1))) {//if only left side is a letter
								if (identifier[m[0].codePointAt(1) - 97]) {//checking if left side is initialized
									if (Double.parseDouble(m[2])==0) {//if right side is 0
										System.out.println("cannot divine by 0");
									}
									else {
										System.out.println((num[m[0].codePointAt(1) - 97]) / Double.parseDouble(m[2]));
									}
								}

							} 
							else if (Character.isLetter(m[2].charAt(0))) {//if only right side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println((num[m[0].codePointAt(1) - 97]) / Double.parseDouble(m[2]));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[2])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									System.out.println(Double.parseDouble(m[0]) / Double.parseDouble(m[2]));
								}
							}
						}
					}
					else if (m[2].contains("-")) {// - in the right side
						if (m[1].equals("=")) {
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(1))) {//checking if both are letters
								if(identifier[m[2].codePointAt(1) - 97]) {//checking if right side initialized
									num[m[0].codePointAt(0) - 97]=num[m[2].codePointAt(1) - 97]*(-1);
									identifier[m[0].codePointAt(0) - 97] = true;
								}
							}
							else {//if only left side is a letter
								identifier[m[0].codePointAt(0) - 97] = true;
								num[m[0].codePointAt(0) - 97] = Double.parseDouble(m[2]);
								System.out.println(num[m[0].codePointAt(0) - 97]);
							}
						}
						if (m[1].equals("+")) {
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(1))) {//checking if both letters
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if both initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) + (num[m[2].codePointAt(1) - 97]));
								} else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							}
							else if (Character.isLetter(m[0].charAt(0))) {//if only left side is a letter
								if (identifier[m[0].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) + Double.parseDouble(m[2]));
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {//if only right side is a letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println((num[m[2].codePointAt(1) - 97]) + Double.parseDouble(m[0]));
								}
							}
							else {//if both are numbers
								System.out.println(Double.parseDouble(m[0]) + Double.parseDouble(m[2]));
							}
						}
						else if (m[1].equals("-")) {
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(1))) {//checking if both are letters
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if both initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) - (num[m[2].codePointAt(1) - 97]));
								} else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							}
							else if (Character.isLetter(m[0].charAt(0))) {//if only left side is a letter
								if (identifier[m[0].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) - Double.parseDouble(m[2]));
								}
							}
							else if (Character.isLetter(m[2].charAt(1))) {//if only right side is a letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(Double.parseDouble(m[0]) - (num[m[2].codePointAt(1) - 97]));
								}
							}
							else {//both are numbers
								System.out.println(Double.parseDouble(m[0]) - Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("*")) {
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(1))) {//checking if both are letters
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if they are initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) * (num[m[2].codePointAt(1) - 97]));
								} else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[0].charAt(0))) {//if only left side is a letter
								if (identifier[m[0].codePointAt(0) - 97]) {//checking if it initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) * Double.parseDouble(m[2]));
								}
							}
							else if (Character.isLetter(m[2].charAt(0))) {//if only right side is a letter 
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println((num[m[2].codePointAt(1) - 97]) * Double.parseDouble(m[0]));
								}
							}
							else {//both are numbers
								System.out.println(Double.parseDouble(m[0]) * Double.parseDouble(m[2]));
							}
						}
						if (m[1].equals("/")) {
							if (Character.isLetter(m[0].charAt(0)) && Character.isLetter(m[2].charAt(1))) {//Checking if both are letters
								if (identifier[m[0].codePointAt(0) - 97] && identifier[m[2].codePointAt(1) - 97]) {//checking if they are initialized
									System.out.println(((num[m[0].codePointAt(0) - 97]) * (-1)) / (num[m[2].codePointAt(1) - 97]));
								} 
								else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[0].charAt(0))) {//if only left side is a letter
								if (identifier[m[0].codePointAt(0) - 97]) {//checking if left side is initialized
									if (Double.parseDouble(m[2])==0) {//if right side is 0
										System.out.println("cannot divine by 0");
									}
									else {
										System.out.println((num[m[0].codePointAt(1) - 97]) / Double.parseDouble(m[2]));
									}
								}
							} else if (Character.isLetter(m[2].charAt(0))) {//if only right side is a letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									System.out.println(Double.parseDouble(m[0]) - (num[m[2].codePointAt(1) - 97]));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[2])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									System.out.println(Double.parseDouble(m[0]) / Double.parseDouble(m[2]));
								}
							}
						}
					}
				}
				if (m.length == 5) {
					if (m[0].contains("-") == false && m[2].contains("-") == false && m[4].contains("-")==false) {// no -
						identifier[m[0].codePointAt(0) - 97] = true;// Variable is not true

						if (m[3].equals("+")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(0))) {//checking if both are letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(0) - 97]) {//checking if both initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(0) - 97]) + (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {// if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(0) - 97]) + Double.parseDouble(m[2]));
								}
							}
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[4].codePointAt(0) - 97]) + Double.parseDouble(m[2]));
								}
							}
							else {//if both are numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) + Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						} 
						else if (m[3].equals("-")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(0))) {//checking if both are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(0) - 97]) {//Checking if both initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(1) - 97]) - (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								}
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {//if only left side is letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(1) - 97]) - Double.parseDouble(m[4]));
								}
							}
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter 
								if (identifier[m[4].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - (num[m[4].codePointAt(0) - 97]));
								}
							}
							else {//both numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);

						}
						if (m[3].equals("*")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(0))) {//Checking if both letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(0) - 97]) {//Checking if both initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(0) - 97]) * (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								} 
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {// if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(0) - 97]) * Double.parseDouble(m[4]));
								}

							}
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter 
								if (identifier[m[4].codePointAt(0) - 97]) {//cheking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[4].codePointAt(0) - 97]) * Double.parseDouble(m[2]));
								}
							}
							else {// both numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) * Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
						if (m[3].equals("/")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(0))) {//Checking if both are letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(0) - 97]) {//Checking if both initialized
									num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(0) - 97]) / (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {// if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									if (Double.parseDouble(m[4])==0) {// if right side = 0
										System.out.println("cannot divine by 0");
									}
									else {
										num[m[0].codePointAt(0) - 97]=((num[m[2].codePointAt(0) - 97]) / Double.parseDouble(m[4]));
									}
								}

							} 
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(0) - 97]) {//Checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) / (num[m[4].codePointAt(0) - 97]));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[4])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) / Double.parseDouble(m[4]));
								}
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
					}
					else if(m[2].contains("-") && m[4].contains("-")) {// if both sides contains -
						identifier[m[0].codePointAt(0) - 97] = true;
						if (m[3].equals("+")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(1))) {//checking if both are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(1) - 97]) {//checking if both are initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) + ((num[m[4].codePointAt(1) - 97])*(-1)));
								} 
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized 
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								} else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if left side is initialized 
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) + Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[4].charAt(1))) {//if only right side is letter 
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[4].codePointAt(1) - 97])*(-1)) + Double.parseDouble(m[2]));
								}
							}

							else {//if both are numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) + Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
						else if (m[3].equals("-")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(1))) {//checking if both are letters
								if (identifier[m[0].codePointAt(1) - 97] && identifier[m[4].codePointAt(0) - 97]) {//checking if both initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[0].codePointAt(1) - 97]) * (-1)) - ((num[m[4].codePointAt(0) - 97])*(-1)));
								} else if (identifier[m[0].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} else if (Character.isLetter(m[2].charAt(1))) {//if only left side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) - Double.parseDouble(m[4]));
								}
							} 
							else if (Character.isLetter(m[4].charAt(1))) {//if only right side is letter
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2])- (num[m[4].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if both are numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
						if (m[3].equals("*")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(1))) {//if both are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(1) - 97]) {//checking if they are initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) * (num[m[4].codePointAt(1) - 97])*(-1));
								} else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							}
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) * Double.parseDouble(m[2]));
								}

							} else if (Character.isLetter(m[4].charAt(1))) {//if only right side is letter
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2])*(num[m[4].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if both are numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) * Double.parseDouble(m[4]));
							}
						}
						if (m[3].equals("/")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(1))) {//if both are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) / ((num[m[4].codePointAt(1) - 97])*(-1)));
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								}
								else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									if (Double.parseDouble(m[4])==0) {// if right side = 0
										System.out.println("cannot divine by 0");
									}
									else {
										num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) / Double.parseDouble(m[4]));
									}
								}
							} 
							else if (Character.isLetter(m[4].charAt(1))) {//if only right side is letter
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if right side is initialized 
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2])/(num[m[4].codePointAt(1) - 97])*(-1));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[4])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) / Double.parseDouble(m[4]));
								}
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
					}
					else if (m[2].contains("-")) {// - in the left side
						identifier[m[0].codePointAt(0) - 97] = true;//variable is not true
						if (m[3].equals("+")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(0))) {//checking if both are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(0) - 97]) {//checking if both are initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) + (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								}
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) + Double.parseDouble(m[4]));
								}
							}
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter 
								if (identifier[m[4].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[4].codePointAt(0) - 97]) + Double.parseDouble(m[2]));
								}
							}
							else {//both numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) + Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						} 
						else if (m[3].equals("-")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(0))) {//checking if both are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(0) - 97]) {//checking if both initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) - (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								}
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							}
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) - Double.parseDouble(m[4]));
								}
							} 
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - (num[m[4].codePointAt(0) - 97]));
								}
							}
							else {//both numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);

						}

						if (m[1].equals("*")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(0))) {//checking if both sides are letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(0) - 97]) {//checking if both initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) * (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								} 
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) * Double.parseDouble(m[4]));
								}
							}
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[4].codePointAt(0) - 97]) * Double.parseDouble(m[2]));
								}
							}
							else {//both are numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) * Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
						if (m[1].equals("/")) {
							if (Character.isLetter(m[2].charAt(1)) && Character.isLetter(m[4].charAt(0))) {//checking if both side is letters
								if (identifier[m[2].codePointAt(1) - 97] && identifier[m[4].codePointAt(0) - 97]) {//checking if the letter are initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) / (num[m[4].codePointAt(0) - 97]));
								}
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								}
								else if (identifier[m[4].codePointAt(0) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							}
							else if (Character.isLetter(m[2].charAt(1))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(1) - 97]) {//checking if it initialized
									if (Double.parseDouble(m[4])==0) {// if right side = 0
										System.out.println("cannot divine by 0");
									}
									else {
										num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(1) - 97]) * (-1)) / Double.parseDouble(m[4]));
									}
								}
							} 
							else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((Double.parseDouble(m[2]) - (num[m[4].codePointAt(0) - 97])));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[4])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) / Double.parseDouble(m[4]));
								}
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
					}
					else if (m[4].contains("-")) {// - right side
						identifier[m[0].codePointAt(0) - 97] = true;
						if (m[3].equals("+")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(1))) {//checking if both are letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(1) - 97]) {//checking if both are initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) + (num[m[4].codePointAt(1) - 97]));
								}
								else if (identifier[m[0].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[0].charAt(1)+ "' was found");
								} 
								else if (identifier[m[2].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//cheking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) + Double.parseDouble(m[4]));
								}
							} 
							else if (Character.isLetter(m[4].charAt(1))) {//if only right side is letter
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=((num[m[4].codePointAt(1) - 97])*(-1) + Double.parseDouble(m[2]));
								}
							}
							else {//both are numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) + Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
						else if (m[3].equals("-")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(1))) {//checking if both are letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(1) - 97]) {//checking if they are initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) - (num[m[4].codePointAt(1) - 97]));
								} 
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								} else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							}
							else if (Character.isLetter(m[2].charAt(0))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) - Double.parseDouble(m[4]));
								}
							} else if (Character.isLetter(m[4].charAt(1))) {//if only right side is a letter 
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - (num[m[4].codePointAt(1) - 97]));
								}
							}
							else {//both numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - Double.parseDouble(m[4]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}


						if (m[3].equals("*")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(1))) {//Checking if both are letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(1) - 97]) {//cheking if both initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) * (num[m[4].codePointAt(1) - 97]));
								} 
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(1)+ "' was found");
								} 
								else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							}
							else if (Character.isLetter(m[2].charAt(0))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//Checking if it initialized
									num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) * Double.parseDouble(m[4]));
								}
							} else if (Character.isLetter(m[4].charAt(0))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - (num[m[4].codePointAt(0) - 97]));
								}
							}
							else {//both numbers
								num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[0]) * Double.parseDouble(m[2]));
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
						if (m[3].equals("/")) {
							if (Character.isLetter(m[2].charAt(0)) && Character.isLetter(m[4].charAt(1))) {//Checking if both are letters
								if (identifier[m[2].codePointAt(0) - 97] && identifier[m[4].codePointAt(1) - 97]) {//checking if they are initialized
									System.out.println(((num[m[2].codePointAt(0) - 97]) * (-1)) / (num[m[4].codePointAt(1) - 97]));
								}
								else if (identifier[m[2].codePointAt(0) - 97] == false) {//if left side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[2].charAt(0)+ "' was found");
								}
								else if (identifier[m[4].codePointAt(1) - 97] == false) {//if right side is not initialized
									System.out.println("ERROR: Invalid identifier. No variable with name '" + m[4] + "' was found");
								}
							} 
							else if (Character.isLetter(m[2].charAt(0))) {//if only left side is a letter
								if (identifier[m[2].codePointAt(0) - 97]) {//checking if it initialized
									if (Double.parseDouble(m[4])==0) {// if right side = 0
										System.out.println("cannot divine by 0");
									}
									else {
										num[m[0].codePointAt(0) - 97]=(((num[m[2].codePointAt(0) - 97]) * (-1)) / Double.parseDouble(m[4]));
									}
								}
							}
							else if (Character.isLetter(m[4].charAt(1))) {//if only right side is a letter
								if (identifier[m[4].codePointAt(1) - 97]) {//checking if it initialized
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) - (num[m[4].codePointAt(1) - 97]));
								}
							}
							else {//if both are numbers
								if (Double.parseDouble(m[4])==0) {//if right side is 0
									System.out.println("cannot divine by 0");
								}
								else {
									num[m[0].codePointAt(0) - 97]=(Double.parseDouble(m[2]) / Double.parseDouble(m[4]));
								}
							}
							System.out.println(num[m[0].codePointAt(0) - 97]);
						}
					}

				}
			}
		}
	}


public static void main(String [] args) {
calculator();	
}
}