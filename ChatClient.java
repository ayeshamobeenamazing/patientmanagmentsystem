
package assignment3.models;

public interface ChatClient {
    void sendMessage(User receiver, String message);
    void viewChatHistory();
}

