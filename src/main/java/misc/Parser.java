package misc;

public class Parser {
    public static boolean isBye(String input) {
        return input.equalsIgnoreCase("bye");
    }


    public static boolean isAddPatient(String input) {
        return input.toLowerCase().startsWith("add-patient");
    }


    public static boolean isDeletePatient(String input) {
        return input.toLowerCase().startsWith("delete-patient");
    }


    public static boolean isViewPatient(String input) {
        return input.toLowerCase().startsWith("view-patient");
    }


    public static boolean isListPatient(String input) {
        return input.toLowerCase().startsWith("list-patient");
    }


    public static boolean isViewHistory(String input) {
        return input.toLowerCase().startsWith("view-history");
    }


    public static boolean isAddAppointment(String input) {
        return input.toLowerCase().startsWith("add-appointment");
    }


    public static boolean isDeleteAppointment(String input) {
        return input.toLowerCase().startsWith("delete-appointment");
    }


    public static boolean isListAppointments(String input) {
        return input.equalsIgnoreCase("list-appointments");
    }


    public static String[] parseAddAppointment(String input) {
        String temp = input.replaceFirst("(?i)add-appointment\\s*", "");
        String nric = extractValue(temp, "ic/");
        String date = extractValue(temp, "dt/");
        String time = extractValue(temp, "t/");
        String desc = extractValue(temp, "dsc/");
        if (nric == null || date == null || time == null || desc == null) {
            return null;
        }
        return new String[]{nric.trim(), date.trim(), time.trim(), desc.trim()};
    }


    public static String parseDeleteAppointment(String input) {
        String temp = input.replaceFirst("(?i)delete-appointment\\s*", "");
        return temp.isBlank() ? null : temp.trim();
    }


    public static String[] parseAddPatient(String input) {
        String temp = input.replaceFirst("(?i)add-patient\\s*", "");
        String name = extractValue(temp, "n/");
        String nric = extractValue(temp, "ic/");
        String birthdate = extractValue(temp, "dob/");
        String gender = extractValue(temp, "g/");
        String phone = extractValue(temp, "p/");
        String address = extractValue(temp, "a/");
        if (name == null || nric == null || birthdate == null || gender == null || phone == null || address == null) {
            return null;
        }
        return new String[]{nric.trim(), name.trim(), birthdate.trim(), gender.trim(), address.trim(), phone.trim()};
    }


    public static String parseViewHistory(String input) {
        return input.replaceFirst("(?i)view-history\\s*", "").trim();
    }


    private static String extractValue(String input, String prefix) {
        int start = input.toLowerCase().indexOf(prefix.toLowerCase());
        if (start < 0) {
            return null;
        }
        start += prefix.length();
        String[] possible = {"n/", "ic/", "dob/", "g/", "p/", "a/", "dt/", "t/", "dsc/"};
        int end = input.length();
        for (String p : possible) {
            if (p.equalsIgnoreCase(prefix)) {
                continue;
            }
            int idx = input.toLowerCase().indexOf(p.toLowerCase(), start);
            if (idx >= 0 && idx < end) {
                end = idx;
            }
        }
        return input.substring(start, end).trim();
    }
}
