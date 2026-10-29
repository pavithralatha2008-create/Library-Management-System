
import java.util.*;

class Book {
    private int id;
    private String name;
    private int stock;

    Book(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void borrowBook() {
        if (stock > 0) {
            stock--;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available!");
        }
    }

    public void returnBook() {
        stock++;
        System.out.println("Book returned successfully!");
    }

    public void display() {
        System.out.println(id + " - " + name + " - Stock: " + stock);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n--- LIBRARY MANAGEMENT ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        boolean exists = false;
                        for (Book b : books) {
                            if (b.getId() == id) {
                                exists = true;
                                break;
                            }
                        }

                        if (exists) {
                            System.out.println("Book ID already exists!");
                            break;
                        }

                        System.out.print("Enter Book Name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter Stock: ");
                        int stock = sc.nextInt();

                        if (id <= 0 || name.isEmpty() || stock < 0) {
                            System.out.println("Invalid details!");
                        } else {
                            books.add(new Book(id, name, stock));
                            System.out.println("Book added successfully!");
                        }
                        break;

                    case 2:
                    case 3:
                        System.out.print("Enter Book ID: ");
                        id = sc.nextInt();

                        Book found = null;
                        for (Book b : books) {
                            if (b.getId() == id) {
                                found = b;
                                break;
                            }
                        }

                        if (found == null) {
                            System.out.println("Book not found!");
                        } else if (choice == 2) {
                            found.borrowBook();
                        } else {
                            found.returnBook();
                        }
                        break;

                    case 4:
                        if (books.isEmpty()) {
                            System.out.println("No books available!");
                        } else {
                            for (Book b : books) {
                                b.display();
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine();
            }
        }
    }
}