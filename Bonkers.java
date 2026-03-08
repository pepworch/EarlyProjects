public class Bonkers {
	
	public static void main(String[] args) {
		 runGame();
	}
	public static void instructions(int numDigits,int maxGuesses) {
		
		// All of these print statements are to format the text in the same way as the output shown in the word document.
		System.out.println("You will have " + maxGuesses + " guesses to guess a " + numDigits + "-digit number.");
		System.out.println("After each subsequent incorrect guess, you will be given clues categorized as follows:");
		System.out.println("Clue:		Meaning:");
		System.out.println("Bonkers		None of the digits in your guess is correct.");
		System.out.println("Close		One digit is correct but in the wrong position.");
		System.out.println("@		One digit is correct and in the right position."); // Weird indent to fit compiler text.

	}
	public static boolean containsCharacter(String word, char literal) {
		int loopCounter = 0;			// Value for our char e.g 0,1,2,3 etc			
		int wordLength = word.length();	 // Turned word.length() into a variable for ease of use
		while (loopCounter < wordLength) {			// Makes sure it only checks the length of the number to prevent infinity
			if (word.charAt(loopCounter) == literal) // loopCounter here is used as a charValue to assign each digit of the String to the char
			{
				return true;						// Returns true if one digit is correct
			}
			loopCounter++;							// Continues the search if output isn't true by moving on to the next digit
		}
		return false;								// Returns false if no digits are correct
	}
	
	public static String generateSecretNum(int numDigits) {
    java.util.Random rand = new java.util.Random();
    String secretNum = "";												// To turn the int value into a String
    
    while (secretNum.length() < numDigits) {
        int randDigit = rand.nextInt(10); // random digit 0-9
        char digitChar = (char)(randDigit + '0'); // convert to char
        
        // check for dupes
        boolean duplicateFound = false;						// if there is a duplicate, it will return false
        int secretCounter = 0;								// secretCounter refers to a loopCounter for generateSecretNum method
        while (secretCounter < secretNum.length()) {				// Code in the while statement runs until the number of digits has been checked
            if (secretNum.charAt(secretCounter) == digitChar) {		// When a digit is repeated, the boolean returns false from and restarts the loop
                duplicateFound = true;									
            }
            secretCounter++;										// increment to progress
        }
        
        if (!duplicateFound) {										// if no dupes are found
            secretNum += digitChar;									// add digit to the secret number
        }
    }
    
    return secretNum;												// return statement
	
	
}
	public static String concatenateClues(int countAt, int countClose) {
    int atCounter = 0;			// loopCounter for countAt
    int closeCounter = 0;		// loopCounter for countClose
    String result = "";			// To help with concatenating

    while (atCounter < countAt) {
        result += "@";										// adds @ everytime a digit is correct
        atCounter++;			// increment
        if (atCounter < countAt || countClose > 0) {          // add a space after each one if there are more @ clues coming OR if there will be any Close clues after
            result += " ";
        }
    }

    while (closeCounter < countClose) {
        result += "Close";									// adds Close everytime the digit guessed was in the wrong place
        closeCounter++;			// increment
        if (closeCounter < countClose) {					// add a space after each one only if there are more Close clues coming
            result += " ";
        }
    }

    return result;													// return statement
	}
	
	public static String getClues(String secretNum, String userGuess) {
    int countAt = 0;     // correct digit in correct position
    int countClose = 0;  // correct digit in wrong position

    // Check if the guess is perfect
    if (userGuess.equals(secretNum)) {
        return "Congratulations! Your guess is correct!";
    }

    // Loop through each character in the guess
    for (int clueCounter = 0; clueCounter < secretNum.length(); clueCounter++) {					// clueCounter is the loopCounter for getClues method
        char guessChar = userGuess.charAt(clueCounter);											// Using for loop for clearance   
        char secretChar = secretNum.charAt(clueCounter);

        if (guessChar == secretChar) {
            countAt++;  // correct digit, correct position
        } else if (containsCharacter(secretNum, guessChar)) {
            countClose++; // correct digit, wrong position
        }
    }

    // If no digits match at all
    if (countAt == 0 && countClose == 0) {
        return "Bonkers";
    }

    // Return the clues using your concatenateClues method
    return concatenateClues(countAt, countClose);
}
	
	public static void playRound(String secretNum, int maxGuesses) {
		java.util.Scanner reader = new java.util.Scanner(System.in);
		int roundCounter = 0;		// loopCounter for playRound method
		int numDigits = secretNum.length(); // getting numDigits variable to use for valid method
		while (roundCounter < maxGuesses) {
			System.out.print("Guess #" + (roundCounter + 1) + ": ");
			String userGuess = reader.nextLine();

			userGuess = valid(userGuess, numDigits);		// Validating input before proceeding
			
			String clue = getClues(secretNum, userGuess);    // Calling getClues method
			System.out.println(clue);
			
			if (clue.equals("Congratulations! Your guess is correct!")) {
            return; // End the round early if guessed correctly
        }

        roundCounter++;
		}
		System.out.println("You ran out of guesses.  The answer was " + secretNum +".  GAME OVER!!! Thanks for playing!");
		}
	
	public static void runGame() {
		java.util.Scanner reader = new java.util.Scanner(System.in);					// Reader :)
		
		System.out.println("Enter number of digits of secret number: ");
		int digitNum = reader.nextInt();
		System.out.println("Enter the number of guesses the player has: ");
		int guessMax = reader.nextInt();
		
		instructions(digitNum,guessMax);											// Call to intructions method
		String secretNum = generateSecretNum(digitNum);								// Shortcut to simply generateSecretNum method for the next line of code
		playRound(secretNum,guessMax);												// Call to playRound method 
	}
	
	public static boolean allDigits(String userGuess) {
		for (int digitCounter = 0; digitCounter < userGuess.length(); digitCounter++) {		// digitCounter is the loopCounter of this method
        char c = userGuess.charAt(digitCounter);											// Setting up c char as a representative 
        if (c < '0' || c > '9') {															// returns false if the character is outside of the range of 0-9
            return false;
        }
    }
    return true;																			// returs true if every char is a digit from 0-9

	}
	public static String valid(String userGuess, int numDigits) {
    java.util.Scanner reader = new java.util.Scanner(System.in);
   
	while (true) {																							// Check both conditions: correct length AND all digits
        if (allDigits(userGuess) && userGuess.length() == numDigits) {
            return userGuess; 																	//  valid guess, return it
        } else {
            System.out.println("Guess a number that is " + numDigits + " digits long:");		// resets input when invalid to prompt again
            userGuess = reader.nextLine();
			}
		}
	}

}
