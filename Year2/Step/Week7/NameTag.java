package Step.Week7;

public final class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split("\\s+", 2);
        this.firstName = parts.length > 0 ? parts[0] : "";
        if (parts.length > 1 && !parts[1].isEmpty()) {
            this.lastInitial = parts[1].substring(0, 1) + ".";
        } else {
            this.lastInitial = "";
        }
    }

    public String getNickname() {
        if (lastInitial.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastInitial;
    }
}
