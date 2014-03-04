import java.util.Scanner;
import java.util.List;
/**
 * This class is the user interface used 
 * for testing out the BST and handling the
 * Users for the startup
 * @author Manav Dutta
 * @version 2.0
 */
public class Driver
{
    /**
     * This adds a new user to the tree
     * @param tree- the tree
     * @param user- the user
     */
    public static void addStuff(BST<User> tree, User user) {
        tree.add(user);
    }
    /**
     * This removes a user from the tree
     * @param tree- the tree
     * @param user- the user
     */
    public static void removeStuff(BST<User> tree, String data) {
        tree.remove(new User(data, " "));
    }
    /**
     * Returns a name given the appropriate username
     * @param tree- the tree
     * @param user- the user
     * @return the name
     */
    public static String findStuff(BST<User> tree, String name) {
       if (tree.contains(new User(name, " "))) {
           return tree.get(new User(name, " ")).getFirstName();
       } 
       else {
           return "Username not found";
       }
    }   
    /**
     * This lists out the users and their usernames
     * @param tree- the tree
     */
    public static void listUsers(BST<User> tree) {
        List<User> userList = tree.inOrder();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    /**
     * This lists out the entire tree
     * @param tree- the tree
     */
    public static void debugStuff(BST<User> tree) {
        System.out.println(tree);
    }
    public static void main(String [] args) {
        boolean shouldContinue = true;
        BST<User> tree = new BST<User>();
        Scanner scanny = new Scanner(System.in);
        while (shouldContinue) {
          System.out.println("Welcome to the BST Manipulator Driver thing");
          System.out.println("Here are your options.\n1. Add\n2. Remove\n3. Find user\n4. List users\n5. Debug\n6. Exit");
          System.out.println("Enter a number from 1-6");
          int response = scanny.nextInt();
          switch (response) {
              case 1: scanny.nextLine();
                      System.out.println("Enter the user's name");
                      String firstName = scanny.next();
                      System.out.println("Enter the userName");
                      String userName = scanny.next();
                      addStuff(tree, new User(userName, firstName));
                      break;
              case 2: scanny.nextLine();
                      System.out.println("Enter the userName");
                      String uName = scanny.next();
                      removeStuff(tree, uName);
                      break;
              case 3: scanny.nextLine();
                      System.out.println("Enter userName to be looked up");
                      String userNamen = scanny.next();
                      System.out.println(findStuff(tree, userNamen));
                      break;
              case 4: listUsers(tree);
                      break;
              case 5: debugStuff(tree);
                      break;
              case 6: shouldContinue = false;
                      break;
              default: System.out.println("You're a goober. Only input 1-6");
                       break;
          }
          System.out.println();
          System.out.println();
          System.out.println("The tree's size is " + tree.size());
        }
    }
}
