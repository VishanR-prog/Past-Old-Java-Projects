import java.util.Arrays;

public class BinarySearch {
    private static String[] PROVINCES = {
            "British Columbia",
            "Alberta",
            "Saskatchewan",
            "Manitoba",
            "Ontario",
            "Quebec",
            "New Brunswick",
            "Nova Scotia",
            "Prince Edward Island",
            "Newfoundland",
            "Yukon",
            "Northwest Territories",
            "Nunavut"
    };

    public static String search(City[] cityName, City City) {
        // implement either iteratively or recursively
            int low = 0;
            int high = cityName.length - 1;
            int mid;

            while (low <= high) {
                mid = (low + high) / 2;

                if (cityName[mid].compareTo(City) == 0) {
                    return String.valueOf(cityName[mid]);
                }
                else if (cityName[mid].compareTo(City) < 0) {
                    low = mid + 1;
                } else if (cityName[mid].compareTo(City) > 0) {
                    high = mid - 1;
                }
            }
            return null;
        }




    public static void main(String[] args) {
        City[] cities = new City[26];
        String[][] names = {
                {"Vancouver", "Victoria"},
                {"Edmonton", "Calgary"},
                {"Saskatoon", "Regina"},
                {"Winnipeg", "Brandon"},
                {"Toronto", "Ottawa"},
                {"Montreal", "Quebec City"},
                {"St. John", "Fredericton"},
                {"Halifax", "Cape Breton"},
                {"Charlottetown", "Prince George"},
                {"St. John's", "Gander"},
                {"Whitehorse", "Potato"},
                {"Yellowknife", "The Northwest Passage"},
                {"Iqalit", "Hubada"}
        };
        for (int i = 0; i < PROVINCES.length; i++) {
            for (int c = 0; c < 2; c++) { // c is our city index
                cities[i * 2 + c] = new City(names[i][c], PROVINCES[i], 0);
            }
        }

        // sort our city array
        Arrays.sort(cities);

        for (City c : cities) {
            System.out.println(c);
        }
        City e = new City("Edmonton", "Alberta", 0);
        BinarySearch bs = new BinarySearch();
        System.out.println();
        System.out.println("Found: "+bs.search(cities, e));
    }
}