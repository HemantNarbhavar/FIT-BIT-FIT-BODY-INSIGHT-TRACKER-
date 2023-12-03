import java.util.Scanner;
import java.util.InputMismatchException;

public class BurnCalorieCal {

    public static boolean checkTime(String s) {
        int p1 = Integer.parseInt(s.substring(0, 2));

        int p2 = Integer.parseInt(s.substring(3, 5));
        if (s.charAt(2) == ':' && ((p1 < 0 || p1 > 12) || (p2 < 0 || p2 > 60)))
            return true;
        return false;
    }

    public static void main(String[] args) {
        int choice;
        float w; // take this from database
        float met = 0.0f;
        int CalBurn;
        String time;
        Scanner sc = new Scanner(System.in);
        Activitie act = new Activitie();
        try {
            do {
                System.out.print("Enter Time in format hh:mm :-  ");
                time = sc.next();
                if (checkTime(time))
                    System.out.println("Invalid Input Try Again");
            } while (checkTime(time));

            do {
                System.out.print("Enter weight in kg (between 35 to 175): ");
                w = sc.nextFloat();
                if (w < 35 || w > 175) {
                    System.out.print("Invalid Input Try Again\n");
                }
            } while (w < 35 || w > 175);

            do {
                System.out.print("Enter choice: ");
                System.out.println("\n1.Walking\n2.Running\n3.Cycling\n4.Gym Activities\n5.Training Sports Activities");
                choice = sc.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid Input Try Again");
                }
            } while (choice < 1 || choice > 5);

            int level;
            int type;
            switch (choice) {
                case 1:
                    System.out.println("1.slow\n2.moderate\n3.fast\n4.very fast");
                    level = sc.nextInt();
                    met = act.Walk(level);
                    break;
                case 2:
                    System.out.println("1.slow\n2.moderate\n3.fast");
                    level = sc.nextInt();
                    met = act.Run(level);
                    break;
                case 3:
                    System.out.println("1.slow\n2.moderate\n3.fast\n4.very fast");
                    level = sc.nextInt();
                    met = act.Cycle(level);
                    break;
                case 4:
                    System.out.println("1.Aerobics\n2.Weight Lifting");
                    type = sc.nextInt();
                    switch (type) {
                        case 1:
                            System.out.println(
                                    "1.Low Impact\n2.Medium Impact\n3.High Impact");
                            level = sc.nextInt();
                            met = act.Arobic(level);
                            break;
                        case 2:
                            System.out.println("1.low Intensity\n2.Medium Intensity\n3.High Intensity");
                            level = sc.nextInt();
                            met = act.Gym(level);
                            break;
                    }
                case 5:
                    System.out.println("1.Badminton\n2.Basketball\n3.Boxing");
                    level = sc.nextInt();
                    met = act.Sport(level);
                    break;
            }

            int p1 = Integer.parseInt(time.substring(0, 2));
            int p2 = Integer.parseInt(time.substring(3, 5));
            int t = p1 * 60 + p2;

            float BurnCal = ((met * w * t) / 200);
            System.out.println("\nCalories Burn Today : " + (int) BurnCal);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
            return; // Exit the method if there's an exception
        }

    }
}

class Activitie {

    public float Walk(int l) {
        float met = 0f;
        switch (l) {
            case 1:
                met = 7.42f;
                break;
            case 2:
                met = 9.71f;
                break;
            case 3:
                met = 12.57f;
                break;
            case 4:
                met = 16.0f;
                break;
        }
        return met;
    }

    public float Run(int l) {
        float met = 0f;
        switch (l) {
            case 1:
                met = 28.0f;
                break;
            case 2:
                met = 36.0f;
                break;
            case 3:
                met = 44.0f;
                break;
            case 4:
                met = 50.0f;
        }

        return met;
    }

    public float Cycle(int l) {
        float met = 0f;
        switch (l) {
            case 1:
                met = 28.0f;
                break;
            case 2:
                met = 35.42f;
                break;
            case 3:
                met = 42.28f;
                break;
            case 4:
                met = 57.14f;
                break;
        }
        return met;
    }

    public float Arobic(int l) {
        float met = 0f;
        switch (l) {
            case 1:
                met = 14.28f;
                break;
            case 2:
                met = 24.57f;
                break;
            case 3:
                met = 32.42f;
                break;
        }
        return met;
    }

    public float Gym(int l) {
        float met = 0f;
        switch (l) {
            case 1:
                met = 10.9f;
                break;
            case 2:
                met = 15.3f;
                break;
            case 3:
                met = 21.14f;
                break;
        }
        return met;
    }

    public float Sport(int l) {
        float met = 0f;
        switch (l) {
            case 1:
                met = 13.14f;
                break;
            case 2:
                met = 28.0f;
                break;
            case 3:
                met = 32.0f;
                break;
        }
        return met;
    }

}
