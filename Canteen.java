import java.util.Scanner;

class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;

        char again;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Burger     - $80.00");
            System.out.println("2. Pizza      - $120.00");
            System.out.println("3. Pasta      - $100.00");
            System.out.println("4. Sandwich   - $70.00");
            System.out.println("5. Milk Tea   - $90.00");
            System.out.println();

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int itemQuantity = input.nextInt();

            // Check if item choice is 1-5 and quantity is 1-10
            if (itemNumber >= 1 && itemNumber <= 5 && itemQuantity >= 1 && itemQuantity <= 10) {
                System.out.print("Are you a student? (Y/N): ");
                char itemStudent = input.next().charAt(0);

                double itemPrice = 0;
                if (itemNumber == 1) {
                    itemPrice = 80.00;
                } else if (itemNumber == 2) {
                    itemPrice = 120.00;
                } else if (itemNumber == 3) {
                    itemPrice = 100.00;
                } else if (itemNumber == 4) {
                    itemPrice = 70.00;
                } else if (itemNumber == 5) {
                    itemPrice = 90.00;
                }

                double subtotal = itemPrice * itemQuantity;
                double discount = 0;

                // Discount logic according to Requirement 4
                boolean isStudent = (itemStudent == 'Y' || itemStudent == 'y');
                if (isStudent && subtotal >= 500) {
                    discount = subtotal * 0.15;
                } else if (subtotal >= 500) {
                    discount = subtotal * 0.05;
                } else if (isStudent) {
                    discount = subtotal * 0.10;
                }

                double orderTotal = subtotal - discount;

                System.out.printf("\nSubtotal: $%.2f\n", subtotal);
                System.out.printf("Discount: $%.2f\n", discount);
                System.out.printf("Order total: $%.2f\n\n", orderTotal);

                totalItems += itemQuantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;

            } else {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
            }

            System.out.print("Do you want to order again? (Y/N): ");
            again = input.next().charAt(0);
            System.out.println();

        } while (again == 'Y' || again == 'y');

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f\n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f\n", totalDiscount);
        System.out.printf("Final amount: $%.2f\n", finalAmount);
        System.out.println("Thank you for ordering!");

        input.close();
    }
}