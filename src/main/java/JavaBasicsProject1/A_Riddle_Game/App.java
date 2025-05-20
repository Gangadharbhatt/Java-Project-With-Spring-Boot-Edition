package JavaBasicsProject1.A_Riddle_Game;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		
//        int a = 5;
//        int b = 6;
//        int random1 = (int)Math.random();
//        double random = Math.random();
//        System.out.println(random1);
//        System.out.println(random);
		String[] riddles = {
				"I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
				"The more you take, the more you leave behind. What am I?",
				"I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?" };

		String[] answers = { "An echo", "Footsteps", "A fire" };

		String[] hints = { "Hint: This thing is known for its ability to reflect sound.",
				"Hint: Think about what you leave behind when you walk.", "Hint: It produces heat and light." };
		

		int numRiddles = riddles.length;
		boolean [] shownRiddles = new boolean[numRiddles];
		int showCount = 0;
		int totalLaps =0;
		int totalAttemptedRiddles =0;
		while (true) {
			int randomIndex;
			do {
				randomIndex = (int) (Math.random() * numRiddles);
			} while (shownRiddles[randomIndex] );
			totalLaps++;
			totalAttemptedRiddles++;
			String selectedRiddles = riddles[randomIndex];
			String correctAnswer = answers[randomIndex];
			String giveHint = hints[randomIndex];

			System.out.println("Riddle: " + selectedRiddles);
//			System.out.println("Give the answer");
			
			shownRiddles[randomIndex] = true;
			showCount++;

			String givenAnswer = scanner.nextLine();

			if (givenAnswer.equalsIgnoreCase(correctAnswer)) {
				System.out.println("Correct");
				score++;
			} else {
				System.out.println("Do you want hint");
				String hintdemand = scanner.nextLine().toLowerCase();
				if (hintdemand.equals("yes")) {
					System.out.println(giveHint);
				}
			}
			
			if(showCount==numRiddles) {
				System.out.println("All riddles have been shown, Do you want to continue");
				String playagain = scanner.nextLine().toLowerCase();
				if (!playagain.equals("yes")) {
					break;
				}
			shownRiddles = new boolean[numRiddles];
			showCount = 0;
			}
		}
		
		System.out.println("Your total Lap of attempts are " + totalLaps/3);
		System.out.println("Total Attempted Question " + totalAttemptedRiddles);
		System.out.println("Your total score is " + score + " Wrong answers are " + (totalAttemptedRiddles-score));
		System.out.println("Thanks for playing!");
	}
}
