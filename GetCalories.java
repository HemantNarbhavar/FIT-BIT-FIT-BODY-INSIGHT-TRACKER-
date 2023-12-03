import java.util.*;

class Dish {
	private String name;
	private int calories;

	public Dish(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}
}

public class GetCalories {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Dish> breakfastDishes = createSampleBreakfastDishes();
		List<Dish> lunchDishes = createSampleLunchDishes();
		List<Dish> dinnerDishes = createSampleDinnerDishes();
		List<Dish> snackDishes = createSampleSnackDishes();

		int totalCaloriesBreakfast = chooseDishes("Breakfast", breakfastDishes, scanner);
		int customCaloriesBreakfast = addCustomDishes("Breakfast", breakfastDishes, scanner);
		int totalCaloriesLunch = chooseDishes("Lunch", lunchDishes, scanner);
		int customCaloriesLunch = addCustomDishes("Lunch", lunchDishes, scanner);
		int totalCaloriesDinner = chooseDishes("Dinner", dinnerDishes, scanner);
		int customCaloriesDinner = addCustomDishes("Dinner", dinnerDishes, scanner);
		int totalCaloriesSnacks = chooseDishes("Snacks", snackDishes, scanner);
		int customCaloriesSnack = addCustomDishes("Snacks", snackDishes, scanner);

		int totalCalories = totalCaloriesBreakfast + totalCaloriesLunch + totalCaloriesDinner + totalCaloriesSnacks
				+ customCaloriesBreakfast + customCaloriesLunch + customCaloriesDinner + customCaloriesSnack;
		System.out.println("\nTotal calories consumed: " + totalCalories);
	}

	private static List<Dish> createSampleBreakfastDishes() {
		List<Dish> dishes = new ArrayList<>();
		dishes.add(new Dish("Black Tea", 1));
		dishes.add(new Dish("Milk Tea", 62));
		dishes.add(new Dish("Cold Drink", 40));
		dishes.add(new Dish("Fruit Juice", 50));
		dishes.add(new Dish("Milk", 52));
		dishes.add(new Dish("Bacon", 37));
		dishes.add(new Dish("Toast", 69));
		dishes.add(new Dish("Fruit Salad", 91));
		dishes.add(new Dish("Pancake", 93));
		dishes.add(new Dish("Banana", 105));
		dishes.add(new Dish("Buiscuit", 106));
		dishes.add(new Dish("Fruit Smoothie", 80));
		dishes.add(new Dish("Doughnut", 226));
		dishes.add(new Dish("Oatmeal", 143));
		dishes.add(new Dish("Scrambled Eggs", 142));
		dishes.add(new Dish("Pizza", 223));
		dishes.add(new Dish("Avocado Toast", 250));
		dishes.add(new Dish("Omelet", 282));
		dishes.add(new Dish("Sandwich", 584));
		return dishes;
	}

	private static List<Dish> createSampleLunchDishes() {
		List<Dish> dishes = new ArrayList<>();
		dishes.add(new Dish("Grilled Chicken Salad", 300));
		dishes.add(new Dish("Chicken Curry", 225));
		dishes.add(new Dish("Tandoori Chicken", 260));
		dishes.add(new Dish("Vegetable Sandwich", 250));
		dishes.add(new Dish("Butter Chicken", 490));
		dishes.add(new Dish("Soya Beans", 446));
		dishes.add(new Dish("Cabbage", 60));
		dishes.add(new Dish("Palak Paneer", 280));
		dishes.add(new Dish("Fried Potato", 200));
		dishes.add(new Dish("Mashed Potato", 100));
		dishes.add(new Dish("Mixed Veggies", 80));
		dishes.add(new Dish("Vegetable Curry", 130));
		dishes.add(new Dish("Poori", 75));
		dishes.add(new Dish("Roti", 100));
		dishes.add(new Dish("Paratha", 150));
		dishes.add(new Dish("Pav", 180));
		dishes.add(new Dish("Naan", 262));
		dishes.add(new Dish("Butter Naan", 310));
		dishes.add(new Dish("Papad", 45));
		dishes.add(new Dish("Idli", 100));
		dishes.add(new Dish("Dosa", 120));
		dishes.add(new Dish("Salad", 100));
		dishes.add(new Dish("Rice", 120));
		dishes.add(new Dish("Sambar", 120));
		dishes.add(new Dish("Dal", 150));
		dishes.add(new Dish("Pickel", 30));
		dishes.add(new Dish("Mutton Biryani", 225));
		dishes.add(new Dish("Chicken Curry", 225));
		dishes.add(new Dish("Fried Fish", 140));
		dishes.add(new Dish("Crab", 81));
		dishes.add(new Dish("Prawn", 65));
		dishes.add(new Dish("Omelette", 120));
		dishes.add(new Dish("Pav Bhaji", 610));

		return dishes;
	}

	private static List<Dish> createSampleDinnerDishes() {
		List<Dish> dishes = new ArrayList<>();
		dishes.add(new Dish("Salmon Rice", 400));
		dishes.add(new Dish("Pasta Tomato Sauce", 350));
		dishes.add(new Dish("Grilled Chicken Salad", 300));
		dishes.add(new Dish("Chicken Curry", 225));
		dishes.add(new Dish("Tandoori Chicken", 260));
		dishes.add(new Dish("Vegetable Sandwich", 250));
		dishes.add(new Dish("Butter Chicken", 490));
		dishes.add(new Dish("Soya Beans", 446));
		dishes.add(new Dish("Cabbage", 60));
		dishes.add(new Dish("Palak Paneer", 280));
		dishes.add(new Dish("Fried Potato", 200));
		dishes.add(new Dish("Mashed Potato", 100));
		dishes.add(new Dish("Mixed Veggies", 80));
		dishes.add(new Dish("Vegetable Curry", 130));
		dishes.add(new Dish("Poori", 75));
		dishes.add(new Dish("Roti", 100));
		dishes.add(new Dish("Paratha", 150));
		dishes.add(new Dish("Pav", 180));
		dishes.add(new Dish("Naan", 262));
		dishes.add(new Dish("Butter Naan", 310));
		dishes.add(new Dish("Papad", 45));
		dishes.add(new Dish("Idli", 100));
		dishes.add(new Dish("Dosa", 120));
		dishes.add(new Dish("Salad", 100));
		dishes.add(new Dish("Rice", 120));
		dishes.add(new Dish("Sambar", 120));
		dishes.add(new Dish("Dal", 150));
		dishes.add(new Dish("Pickel", 30));
		dishes.add(new Dish("Mutton Biryani", 225));
		dishes.add(new Dish("Chicken Curry", 225));
		dishes.add(new Dish("Fried Fish", 140));
		dishes.add(new Dish("Crab", 81));
		dishes.add(new Dish("Prawn", 65));
		dishes.add(new Dish("Omelette", 120));
		dishes.add(new Dish("Pav Bhaji", 610));

		return dishes;
	}

	private static List<Dish> createSampleSnackDishes() {
		List<Dish> dishes = new ArrayList<>();
		dishes.add(new Dish("Fried Nuts", 450));
		dishes.add(new Dish("Almomd", 602));
		dishes.add(new Dish("Pakodas", 175));
		dishes.add(new Dish("Vada", 70));
		dishes.add(new Dish("Samosa", 140));
		dishes.add(new Dish("Sandwich", 250));
		dishes.add(new Dish("Buiscuit", 30));
		dishes.add(new Dish("Chips", 120));
		dishes.add(new Dish("Pani Puri", 150));
		dishes.add(new Dish("Falooda", 300));
		dishes.add(new Dish("Sweet", 150));
		dishes.add(new Dish("Jam", 30));
		return dishes;
	}

	private static int chooseDishes(String mealType, List<Dish> dishes, Scanner scanner) {
		System.out.println("\nChoose " + mealType + " dishes ");
		int choice;
		int quantity;
		int totalCalories = 0;
		while (true) {
			for (int i = 0; i < dishes.size(); i++) {
				System.out.println(
						(i + 1) + ". " + dishes.get(i).getName() + " (" + dishes.get(i).getCalories() + " calories)");
			}
			System.out.println("Enter the no of the dish you want to add (0 to finish " + mealType + "): \n");
			choice = scanner.nextInt();

			if (choice == 0) {
				break;
			}

			if (choice >= 1 && choice <= dishes.size()) {
				Dish chosenDish = dishes.get(choice - 1);
				System.out.print("Enter quantity of " + chosenDish.getName() + " you consume (gram/ml): ");
				quantity = scanner.nextInt();
				System.out.println(chosenDish.getName() + " added to " + mealType + "\n");
				totalCalories += ((chosenDish.getCalories() * quantity) / 100);
			} else {
				System.out.println("Invalid choice. Please try again.\n");
			}
		}

		return totalCalories;
	}

	private static int addCustomDishes(String mealType, List<Dish> dishes, Scanner scanner) {
		System.out.println("\nAdd custom " + mealType + " dishes (or 0 to finish):");
		String customDishName;
		int customDishCalories;
		int quantity;
		int totalCalories = 0;
		while (true) {
			System.out.print("Enter the name of the custom dish (or 0 to finish): ");
			customDishName = scanner.next();
			if (!customDishName.equals("0")) {
				System.out.print("Enter the calories of the custom dish: ");
				customDishCalories = scanner.nextInt();
				Dish customDish = new Dish(customDishName, customDishCalories);
				dishes.add(customDish);
				System.out.print("Enter quantity of " + customDishName + " you consume (gram/ml): ");
				quantity = scanner.nextInt();
				System.out.println(customDishName + " added to " + mealType + "\n");
				totalCalories += ((customDishCalories * quantity) / 100);
			} else {
				break;
			}
		}
		return totalCalories;
	}
}
