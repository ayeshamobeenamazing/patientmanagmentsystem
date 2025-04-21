
package assignment3.models;
import java.util.ArrayList;
import java.util.List;
public class ChatServer {
   private static final List<String> chatHistory = new ArrayList<>();

    public static void sendMessage(User sender, User receiver, String message) {
        String chatLine = sender.getName() + " to " + receiver.getName() + ": " + message;
        chatHistory.add(chatLine);
        System.out.println("\n " + chatLine);
    }

    public static void showChatHistory() {
        System.out.println("\n Chat History:");
        for (String msg : chatHistory) {
            System.out.println(msg);
        }
    }
}
