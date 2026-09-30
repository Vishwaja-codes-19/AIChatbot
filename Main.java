import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<String, String> knowledgeBase = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        loadKnowledgeBase();

        System.out.println("======================================");
        System.out.println("              AI CHATBOT");
        System.out.println("======================================");
        System.out.println("Bot: Hello! I am your Java chatbot.");
        System.out.println("Bot: Ask me about Java, OOP, DSA, SQL,");
        System.out.println("Bot: GitHub, CodeAlpha, or programming.");
        System.out.println("Bot: Type 'bye' to exit.");

        while (true) {

            System.out.print("\nYou: ");
            String input = scanner.nextLine();

            String response = getResponse(input);

            System.out.println("Bot: " + response);

            if (isExitCommand(input)) {
                break;
            }
        }

        scanner.close();

        System.out.println("\nChatbot session ended.");
    }

    public static void loadKnowledgeBase() {

        knowledgeBase.put("java",
                "Java is a popular object-oriented programming language used to build many types of applications.");

        knowledgeBase.put("oop",
                "OOP stands for Object-Oriented Programming. Its four main concepts are Encapsulation, Inheritance, Polymorphism, and Abstraction.");

        knowledgeBase.put("dsa",
                "DSA stands for Data Structures and Algorithms. Data structures organize data, while algorithms provide steps to solve problems efficiently.");

        knowledgeBase.put("array",
                "An array stores multiple values of the same data type in a fixed-size collection.");

        knowledgeBase.put("string",
                "A String in Java is a sequence of characters used to represent text.");

        knowledgeBase.put("sql",
                "SQL stands for Structured Query Language. It is used to manage and retrieve data from relational databases.");

        knowledgeBase.put("dbms",
                "DBMS stands for Database Management System. It is software used to store, organize, retrieve, and manage data.");

        knowledgeBase.put("github",
                "GitHub is a platform used to store, manage, and collaborate on software projects using Git.");

        knowledgeBase.put("codealpha",
                "CodeAlpha is the organization through which this Java internship project was developed.");

        knowledgeBase.put("internship",
                "This chatbot was developed as part of a Java Programming Internship project.");

        knowledgeBase.put("programming",
                "Programming is the process of writing instructions that a computer can execute.");

        knowledgeBase.put("project",
                "This is a Java-based rule-driven chatbot that uses text preprocessing and a knowledge base to answer common questions.");

        knowledgeBase.put("help",
                "You can ask me about Java, OOP, DSA, arrays, strings, SQL, DBMS, GitHub, CodeAlpha, internships, or programming.");
    }

    public static String getResponse(String input) {

        String text = preprocess(input);

        // Greetings
        if (containsWord(text, "hello") ||
            containsWord(text, "hi") ||
            containsWord(text, "hey")) {

            return "Hello! How can I help you today?";
        }

        // General conversation
        if (text.equals("how are you") ||
            text.equals("how are u")) {

            return "I'm doing great! Thanks for asking.";
        }

        if (text.contains("your name") ||
            text.contains("who are you")) {

            return "I am a Java-based rule-driven AI chatbot.";
        }

        // Thank you
        if (text.contains("thank you") ||
            text.contains("thanks")) {

            return "You're welcome! I'm happy to help.";
        }

        // Search knowledge base
        for (String keyword : knowledgeBase.keySet()) {

            if (containsWord(text, keyword)) {
                return knowledgeBase.get(keyword);
            }
        }

        return "I'm sorry, I don't have an answer for that yet. Try asking me about Java, OOP, DSA, SQL, GitHub, or programming.";
    }

    public static String preprocess(String input) {

        return input
                .toLowerCase()
                .replaceAll("[^a-z0-9\\s]", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

    public static boolean containsWord(String text, String word) {

        String[] words = text.split("\\s+");

        for (String currentWord : words) {

            if (currentWord.equals(word)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isExitCommand(String input) {

        String text = preprocess(input);

        return text.equals("bye") ||
               text.equals("goodbye") ||
               text.equals("exit") ||
               text.equals("quit");
    }
}