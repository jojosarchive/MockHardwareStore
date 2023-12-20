public class Date {
    int month;
    int day;
    int year;

    Date(String dateS) {
        String[] values = dateS.split("/");
        if (values.length == 3) {
            this.month = checkValues(values[0], "month");
            this.day = checkValues(values[1], "day");
            this.year = checkValues(values[2], "year");
        }
    }
    //referenced from project 2 value checker
    private int checkValues(String str, String dateName) {

        int value = Integer.parseInt(str);
        if (dateCheck(value, dateName)) {
            return value;
        }
        return value;
    }
    private boolean dateCheck(int value, String dateName ) {
        switch (dateName) {
            case "month":
                return value >= 1 && value <= 12;
            case "day":
                return value >= 1 && value <= 31; // Note: This does not account for different days in each month
            case "year":
                return value > 0; // This checks if the year is a positive number
        }
        return false;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}

