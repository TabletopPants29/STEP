public class VIPCustomerCheck {
    public static void main(String[] args) {
        String id1 = "VIP-4589";
        String id2 = "CUS-4589";

        System.out.println("Input: \"" + id1 + "\" | Output: " + validateCustomerId(id1));
        System.out.println("Input: \"" + id2 + "\" | Output: " + validateCustomerId(id2));
    }

    public static String validateCustomerId(String customerId) {
        if (customerId.startsWith("VIP-")) {
            return "VIP Customer";
        }

        return "Regular Customer";
    }
}