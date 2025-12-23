import java.util.*;

class User {
    String name;
    int age;
    List<User> friends;
    
    User(String name, int age) {
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }
    
    void addFriend(User u) {
        if (!friends.contains(u)) {
            friends.add(u);
            u.friends.add(this);
        }
    }
    
    List<User> getMutualFriends(User u) {
        List<User> mutual = new ArrayList<>();
        for (User f : friends) {
            if (u.friends.contains(f)) {
                mutual.add(f);
            }
        }
        return mutual;
    }
    
    List<User> getSuggestedFriends() {
        List<User> suggestions = new ArrayList<>();
        for (User f : friends) {
            for (User ff : f.friends) {
                if (!friends.contains(ff) && ff != this && !suggestions.contains(ff)) {
                    suggestions.add(ff);
                }
            }
        }
        return suggestions;
    }
    
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
        System.out.print("Friends: ");
        for (User f : friends) {
            System.out.print(f.name + " ");
        }
        System.out.println();
    }
}

public class FriendSystem {
    public static void main(String[] args) {
        User user1 = new User("Alice", 22);
        User user2 = new User("Bob", 23);
        User user3 = new User("Charlie", 24);
        User user4 = new User("David", 21);
        User user5 = new User("Eve", 20);
        
        // Creating friend connections
        user1.addFriend(user2);  // Alice & Bob are friends
        user1.addFriend(user3);  // Alice & Charlie are friends
        user2.addFriend(user4);  // Bob & David are friends
        user3.addFriend(user5);  // Charlie & Eve are friends
        
        System.out.println("=== User Details ===");
        user1.display();
        user2.display();
        user3.display();
        user4.display();
        user5.display();
        
        System.out.println("\n=== Mutual Friends ===");
        List<User> mutual1 = user1.getMutualFriends(user2);
        System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
        if (mutual1.isEmpty()) {
            System.out.println("None");
        } else {
            for (User m : mutual1) {
                System.out.print(m.name + " ");
            }
            System.out.println();
        }
        
        System.out.println("\n=== Friend Suggestions ===");
        System.out.print("Suggested friends for " + user2.name + ": ");
        List<User> suggestions2 = user2.getSuggestedFriends();
        if (suggestions2.isEmpty()) {
            System.out.println("None");
        } else {
            for (User s : suggestions2) {
                System.out.print(s.name + " ");
            }
            System.out.println();
        }
        
        System.out.print("Suggested friends for " + user1.name + ": ");
        List<User> suggestions1 = user1.getSuggestedFriends();
        if (suggestions1.isEmpty()) {
            System.out.println("None");
        } else {
            for (User s : suggestions1) {
                System.out.print(s.name + " ");
            }
            System.out.println();
        }
    }
}