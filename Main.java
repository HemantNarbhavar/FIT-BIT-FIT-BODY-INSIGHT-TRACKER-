import java.util.*;

public class Main {
    public static void main(String[] args) {

        float h;
        float w;
        int age;
        int gender;
        int choice;
        int goal;

        Scanner scanner = new Scanner(System.in);

        try {
            do {
                System.out.print("Enter Height in cm (between 150 to 250) :");
                h = scanner.nextFloat();
                if (h < 150 || h > 250) {
                    System.out.print("Invalid Input try again\n");
                }
            } while (h < 150 || h > 250);

            do {
                System.out.print("Enter weight in kg (between 35 to 175): ");
                w = scanner.nextFloat();
                if (w < 35 || w > 175) {
                    System.out.print("Invalid Input try again\n");
                }
            } while (w < 35 || w > 175);

            do {
                System.out.print("Enter age (between 16 and 60): ");
                age = scanner.nextInt();
                if (age < 16 || age > 60) {
                    System.out.print("Invalid Input try again\n");
                }
            } while (age < 16 || age > 60);

            do {
                System.out.print("Enter gender (0 for male, 1 for female): ");
                gender = scanner.nextInt();
                if (gender != 0 && gender != 1) {
                    System.out.print("Invalid Input try again\n");
                }
            } while (gender != 0 && gender != 1);

            do {

                System.out.println("Enter your weekly exercise level:");
                System.out.println("1. No exercise");
                System.out.println("2. Light exercise");
                System.out.println("3. Moderate exercise");
                System.out.println("4. Active exercise");
                System.out.println("5. Extra Active exercise");
                choice = scanner.nextInt();
                if (choice < 1 && choice > 5) {
                    System.out.print("Invalid Input try again\n");
                }

            } while (choice < 1 || choice > 5);

            do {
                System.out.print("Maintain Weight : 0\nWeight Loss : 1\nWeight Gain: 2\n");
                goal = scanner.nextInt();
                if (goal != 0 && goal != 1 && goal != 2) {
                    System.out.print("Invalid Input try again\n");
                }
            } while (goal != 0 && goal != 1 && goal != 2);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
            return; // Exit the method if there's an exception
        }

        UserInfo u1 = new UserInfo(h, w, age, gender);

        float bmi = u1.BMI(h, w);
        float bfp = u1.BFP(bmi, age, gender);
        float lbm = u1.LBM(bfp, w);
        int bmr = u1.BMR(lbm);

        int wa = u1.weeklyActivity(bmr, choice);

        System.out.println("BMI : " + bmi + "\nBFP : " + bfp + "\nLBM : " + lbm + "\nBMR : " + bmr
                + "\nCaloriesBurnWeekly : " + wa + "\n");

        if (goal == 1) {
            int[] weightLoss = u1.Weight_loss(wa);
            float x = 0.25f;
            for (int num : weightLoss) {
                System.out.println(x + " kg/week: " + num + " calories");
                x = x * 2;
            }
        } else if (goal == 2) {
            int[] weightGain = u1.Weight_gain(wa);
            float x = 0.25f;
            for (int num : weightGain) {
                System.out.println(x + " kg/week: " + num + " calories");
                x = x * 2;
            }
        } else {
            System.out.println("0.00 kg/week: " + bmr + " calories");
        }
    }

}

class UserInfo {

    private float h;
    private float w;
    private int age;
    private int gender;

    UserInfo(float h, float w, int age, int gender) {
        this.h = h;
        this.w = w;
        this.age = age;
        this.gender = gender;
    }

    public float BMI(float h, float w) {
        return w / ((h / 100) * (h / 100));
    }

    // Body fat percentage
    public float BFP(float BMI, int Age, int gender) {
        float bfp = 0;
        if (gender == 0 && Age >= 21) {
            bfp = (1.20f * BMI) + (0.23f * Age) - (16.2f);
        } else if (gender == 1 && Age >= 21) {
            bfp = (1.20f * BMI) + (0.23f * Age) - (5.4f);
        } else if (gender == 0 && Age < 21) {
            bfp = (1.51f * BMI) - (0.70f * Age) - (2.2f);
        } else if (gender == 1 && Age < 21) {
            bfp = (1.51f * BMI) - (0.70f * Age) + (1.4f);
        }
        return bfp;
    }

    // Lean body mass
    public float LBM(float BFP, float w) {
        return ((1 - (BFP / 100)) * w);
    }

    // Basic metabolic rate
    public int BMR(float LBM) {
        return 370 + (int) (21.6 * LBM);
    }

    // User weekly Activity rate
    public int weeklyActivity(int bmr, int choice) {

        int x;
        switch (choice) {
            case 1:
                x = (int) (1.2f * bmr);
                break;
            case 2:
                x = (int) (1.375f * bmr);
                break;
            case 3:
                x = (int) (1.55f * bmr);
                break;
            case 4:
                x = (int) (1.725f * bmr);
                break;
            case 5:
                x = (int) (1.9f * bmr);
                break;
            default:
                x = (int) (bmr);
                break;
        }
        return x;
    }

    // goal weight loss
    public int[] Weight_loss(int wc) {
        int[] weightLoss = new int[3];
        weightLoss[0] = wc - 250;
        weightLoss[1] = wc - 500;
        weightLoss[2] = wc - 1000;
        return weightLoss;
    }

    // goal weight gain
    public int[] Weight_gain(int wc) {

        int[] weightGain = new int[3];
        weightGain[0] = wc + 250;
        weightGain[1] = wc + 500;
        weightGain[2] = wc + 1000;
        return weightGain;
    }

}