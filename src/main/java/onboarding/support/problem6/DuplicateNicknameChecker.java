package onboarding.support.problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNicknameChecker {

    private final List<String> DuplicateUserEmails;

    public DuplicateNicknameChecker(List<List<String>> forms) {
        Set<String> duplicatedUserEmail = new HashSet<>();
        checkForms(forms, duplicatedUserEmail);
    }

    private static void checkForms(List<List<String>> forms, Set<String> duplicatedUserEmail) {
        for (List<String> first : forms) {
            for (List<String> second : forms) {
                if (first.equals(second)) return;

                String firstEmail = first.get(0);
                String firstName = first.get(1);

                String secondEmail = second.get(0);
                String secondName = second.get(1);

                checkDuplicate(duplicatedUserEmail, firstName, firstEmail, secondName, secondEmail);
            }
        }
    }

    private static void checkDuplicate(Set<String> duplicatedUserEmail, String firstName, String firstEmail, String secondName, String secondEmail) {
        for (int i = 0; i < firstName.length() - 1; i++) {
            for (int j = 0; j < secondName.length() - 1; j++) {
                if (isDuplicated(firstName, secondName, i, j)) {
                    duplicatedUserEmail.add(firstEmail);
                    duplicatedUserEmail.add(secondEmail);
                    return;
                }
            }
        }
    }

    private static boolean isDuplicated(String firstName, String secondName, int i, int j) {
        return firstName.charAt(i) == secondName.charAt(j) && firstName.charAt(i + 1) == secondName.charAt(j + 1);
    }

    public List<String> getDuplicateEmails() {
        return DuplicateUserEmails;
    }
}
