import java.util.*;

class OnlineExamSystem {

    Scanner sc = new Scanner(System.in);
    String username = "user";
    String password = "1234";
    boolean loggedIn = false;

    // MCQ Data
    String[] questions = {
            "1) Who invented Java?\n a) James Gosling\n b) Dennis Ritchie\n c) Bjarne Stroustrup\n d) Guido van Rossum",
            "2) Which company owns Java?\n a) Google\n b) Microsoft\n c) Oracle\n d) IBM",
            "3) Which is not a Java keyword?\n a) static\n b) void\n c) then\n d) int"
    };

    char[] answers = { 'a', 'c', 'c' };
    char[] userAnswers = new char[questions.length];

    // Login Method
    void login() {
        System.out.println("===== LOGIN =====");

        while (!loggedIn) {
            System.out.print("Enter Username: ");
            String u = sc.next();
            System.out.print("Enter Password: ");
            String p = sc.next();

            if (u.equals(username) && p.equals(password)) {
                System.out.println("\n Login Successful! ✔");
                loggedIn = true;
            } else {
                System.out.println("Invalid Credentials! Try again.\n");
            }
        }
        menu();
    }

    // Update Profile Method
    void updateProfile() {
        System.out.println("\n===== UPDATE PROFILE =====");

        System.out.print("Enter New Username: ");
        username = sc.next();

        System.out.print("Enter New Password: ");
        password = sc.next();

        System.out.println("\n✔ Profile Updated Successfully!\n");
        menu();
    }

    // Exam Method with Timer
    void startExam() {
        System.out.println("\n===== EXAM STARTED (You have 60 seconds) =====\n");

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60 * 1000; // 60 seconds timer

        for (int i = 0; i < questions.length; i++) {

            if (System.currentTimeMillis() >= endTime) {
                System.out.println("\n⏳ Time Over! Auto submitting...\n");
                break;
            }

            System.out.println(questions[i]);
            System.out.print("Answer (a/b/c/d): ");

            userAnswers[i] = sc.next().charAt(0);
        }

        calculateResult();
    }

    // Calculate score
    void calculateResult() {
        System.out.println("\n===== RESULT =====");

        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (userAnswers[i] == answers[i]) {
                score++;
            }
        }

        System.out.println("Your Score: " + score + "/" + answers.length);

        if (score >= 2)
            System.out.println("🎉 Status: PASS");
        else
            System.out.println("❌ Status: FAIL");

        logout();
    }

    // Logout method
    void logout() {
        System.out.println("\nLogging out... 🔒");
        loggedIn = false;
        System.out.println("Session Closed.");
        System.exit(0);
    }

    // Menu
    void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Update Profile");
        System.out.println("2) Start Exam");
        System.out.println("3) Logout");
        System.out.print("Enter option: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateProfile();
                break;
            case 2:
                startExam();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid Input!");
                menu();
        }
    }

    public static void main(String[] args) {
        OnlineExamSystem app = new OnlineExamSystem();
        app.login();
    }
}