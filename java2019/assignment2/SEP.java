//STAVROS ANDRONIS AM:3181 LOGIN:CSE63181
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.Math;

class Insert_New_Building_to_SEP {
    private HashMap<Integer, Insert_Location_to_SEP> locations = new HashMap<Integer, Insert_Location_to_SEP>();
    private Integer first_location_code = 0;

    public Insert_New_Building_to_SEP() {
    }

    public Insert_New_Building_to_SEP(HashMap<Integer, Insert_Location_to_SEP> locations) {
        this.locations = locations;
    }

    // Copy Constructor
    public Insert_New_Building_to_SEP(Insert_New_Building_to_SEP original_object) {
        this.first_location_code = original_object.first_location_code;
        HashMap<Integer, Insert_Location_to_SEP> locations_copy = new HashMap<Integer, Insert_Location_to_SEP>();
        locations = original_object.locations;
        for (Integer key : locations.keySet()) {
            locations_copy.put(key, locations.get(key));
        }
    }

    public void add_location_to_HashMap(Integer key, Insert_Location_to_SEP location) {
        locations.put(key, location);
    }

    public HashMap<Integer, Insert_Location_to_SEP> getLocations() {
        return locations;
    }

    public Integer getfirst_location_code() {
        return first_location_code;
    }

    public void setfirst_location_code(Integer first_location_code) {
        this.first_location_code = first_location_code;
    }

    public String toString() {
        String first_location_code_string = "first_location_code: " + first_location_code;
        String locations_string = "";
        for (Integer i : locations.keySet()) {
            locations_string = locations_string + "Key: " + i + " Location_String representation: "
                    + locations.get(i).toString();
        }
        return first_location_code_string + " " + locations_string;
    }

    public boolean equals(Insert_New_Building_to_SEP other_object) {
        if (this.first_location_code.equals(other_object.first_location_code)
                && this.locations.equals(other_object.locations)) {
            return true;
        }
        return false;
    }

}

class Insert_Location_to_SEP extends Refresh_Sensors_Measurements {
    private Integer location_code;
    private int temperature_sensor_value;
    private double brightness_sensor_value;
    private double reliabilty_sensor;

    // Default Counstructor
    public Insert_Location_to_SEP() {
    }

    // Constructor for the creation of a location in SEP!
    public Insert_Location_to_SEP(Integer location_code, int temperature_sensor_value, double brightness_sensor_value,
            double reliabilty_sensor) {
        this.location_code = location_code;
        this.temperature_sensor_value = temperature_sensor_value;
        this.brightness_sensor_value = brightness_sensor_value;
        this.reliabilty_sensor = reliabilty_sensor;
    }

    // Copy Constructor
    public Insert_Location_to_SEP(Insert_Location_to_SEP location) {
        Insert_Location_to_SEP location_copy = new Insert_Location_to_SEP(location_code, temperature_sensor_value,
                brightness_sensor_value, reliabilty_sensor);
    }

    // Accessors & Mutators
    public Integer getLocation_code() {
        return location_code;
    }

    public void setLocation_code(Integer location_code) {
        this.location_code = location_code;
    }

    public void setTemperature_sensor_value(int temperature_sensor_value) {
        this.temperature_sensor_value = temperature_sensor_value;
    }

    public int getTemperature_sensor_value() {
        return temperature_sensor_value;
    }

    public void setBrightness_sensor_value(double brightness_sensor_value) {
        this.brightness_sensor_value = brightness_sensor_value;
    }

    public double getBrightness_sensor_value() {
        return brightness_sensor_value;
    }

    public void setReliabilty_sensor(double reliabilty_sensor) {
        this.reliabilty_sensor = reliabilty_sensor;
    }

    public double getReliabilty_sensor() {
        return reliabilty_sensor;
    }

    public String toString() {
        return "Location code: " + location_code + "\n Temperature_sensor_value: " + temperature_sensor_value
                + "\n brightness_sensor_value: " + brightness_sensor_value + "\n reliabilty_sensor: "
                + reliabilty_sensor;
    }

    public boolean equals(Insert_Location_to_SEP other_object) {
        if (this.location_code.equals(other_object.location_code)
                && this.temperature_sensor_value == other_object.temperature_sensor_value
                && this.brightness_sensor_value == other_object.brightness_sensor_value
                && this.reliabilty_sensor == other_object.reliabilty_sensor) {
            return true;
        }
        return false;
    }
}

class CreateFile {
    private FileOutputStream outputStream = null;
    private PrintWriter outputWriter;
    private Integer previous_number = 0;

    public CreateFile(String name) {
        try {
            outputStream = new FileOutputStream("measures.txt");
            outputWriter = new PrintWriter(outputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            System.exit(0);
        }
    }

    public void write_toFile(Insert_New_Building_to_SEP building, Integer number_of_building) {
        HashMap<Integer, Insert_Location_to_SEP> locations = building.getLocations();
        if (number_of_building != previous_number) {

            previous_number = number_of_building;
            if (number_of_building > 1) {

                outputWriter.println("\n" + "Building Number:" + number_of_building + "\n");

            } else {

                outputWriter.println("Building Number:" + number_of_building + "\n");

            }

        }
        for (Integer i : locations.keySet()) {
            Insert_Location_to_SEP location = locations.get(i);
            outputWriter.println("Area: " + location.getLocation_code() + "; Thermokrasia "
                    + location.getTemperature_sensor_value() + "; Fotinotita " + location.getBrightness_sensor_value()
                    + "; Xronos " + location.getTime() + ";");
        }

    }

    public void close_file() {
        outputWriter.close();
        outputWriter.flush();
    }
}

class Refresh_Sensors_Measurements {
    private int time = 1;
    private HashMap<Integer, Insert_Location_to_SEP> locations;

    public Refresh_Sensors_Measurements() {
    }

    public Refresh_Sensors_Measurements(HashMap<Integer, Insert_Location_to_SEP> locations) {
        this.locations = locations;
    }

    // Copy Constructor
    public Refresh_Sensors_Measurements(Refresh_Sensors_Measurements original) {
        this.time = original.time;
        HashMap<Integer, Insert_Location_to_SEP> locations_copy = new HashMap<Integer, Insert_Location_to_SEP>();
        locations = original.locations;
        for (Integer key : locations.keySet()) {
            locations_copy.put(key, locations.get(key));
        }
    }

    Random random_number = new Random();

    public void renewing_sensor_readings() {
        for (Integer i : locations.keySet()) {

            Insert_Location_to_SEP location = locations.get(i);
            location.setTemperature_sensor_value(location.compute_temperature());
            location.setBrightness_sensor_value(location.compute_brightness());
            location.setReliabilty_sensor(location.compute_reliablity());
            location.setTime(location.getTime() + 1);

        }

    }

    public int compute_temperature() {
        return random_number.nextInt(101);
    }

    public double compute_brightness() {
        return Math.round((random_number.nextDouble() * 200 * 100.00)) / 100.00;
    }

    public double compute_reliablity() {
        return Math.exp((-1) * time / (double) 1000);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public String toString() {
        String time_string = "time: " + time;
        String locations_string = "";
        for (Integer i : locations.keySet()) {
            locations_string = locations_string + "Key: " + i + " Location_String representation: "
                    + locations.get(i).toString();
        }
        return time_string + " " + locations_string;
    }

    public boolean equals(Refresh_Sensors_Measurements other_object) {
        if (this.time == other_object.time && this.locations.equals(other_object.locations)) {
            return true;
        }
        return false;
    }

}

class Area_Fire_Control extends Insert_New_Building_to_SEP {
    private double total_reliabilty;

    public Area_Fire_Control(HashMap<Integer, Insert_Location_to_SEP> locations) {

        super(locations);

    }

    // Copy Constructor
    public Area_Fire_Control(Area_Fire_Control original_object) {
        super(original_object.getLocations());
        this.total_reliabilty = original_object.total_reliabilty;
    }

    public void check_for_fire() {
        for (Integer i : super.getLocations().keySet()) {
            Insert_Location_to_SEP location = super.getLocations().get(i);
            compute_total_reliabilty(location);
            if (location.getTemperature_sensor_value() > 50 && location.getBrightness_sensor_value() > 140
                    && total_reliabilty > 0.9) {
                System.out.println("Thermokrasia: " + location.getTemperature_sensor_value() + "; Fotinotita: "
                        + location.getBrightness_sensor_value() + "; Synoliki aksiopistia: " + total_reliabilty
                        + ";\n Pyrkagia at Area " + location.getLocation_code());
            } else {
                System.out.println("Thermokrasia: " + location.getTemperature_sensor_value() + "; Fotinotita: "
                        + location.getBrightness_sensor_value() + "; Synoliki aksiopistia: " + total_reliabilty
                        + ";\n Den yparxei pyrkagia.");
            }
        }

    }

    public void compute_total_reliabilty(Insert_Location_to_SEP location) {

        total_reliabilty = Math.pow(location.getReliabilty_sensor(), 2);

    }

    public String toString() {
        return super.toString() + " total_reliabilty: " + total_reliabilty;
    }

    public boolean equals(Area_Fire_Control other_object) {
        if (this.total_reliabilty == other_object.total_reliabilty
                && this.getLocations().equals(other_object.getLocations())) {
            return true;
        }
        return false;
    }
}

public class SEP{
    public static void main(String[] args) {
        HashMap<Integer,Insert_New_Building_to_SEP> buildings = new HashMap<Integer,Insert_New_Building_to_SEP>();

        Scanner input = new Scanner(System.in);
        Integer building_counter = 0;
        boolean end = false;
        Random random_number = new Random();
        CreateFile file_handler = new CreateFile("measures.txt");
        do{


                System.out.println("1.Eisagogh enos ktiriou.");
                System.out.println("2.Eisagogh mias topothesias tou ktiriou.");
                System.out.println("3.Ananeosh ton metriseon.");
                System.out.println("4.Elegxos pyrkagias.");
                System.out.println("5.Exit.");
                System.out.print("Choose: ");
                Integer answer = input.nextInt();
                System.out.println();
                switch(answer){
                    case 1:
			building_counter ++;
                        HashMap<Integer,Insert_Location_to_SEP> locations = new HashMap<Integer,Insert_Location_to_SEP>();
                        Insert_New_Building_to_SEP building = new Insert_New_Building_to_SEP(locations);
                        buildings.put(building_counter,building);
                        System.out.println("Building insertion successful!\n");
                        break;
                    case 2:
                        System.out.println("Choose a building by giving a valid number! Available buildings: " + buildings.keySet());
                        boolean correct_input = false;
                        while (correct_input == false) {
                            answer = input.nextInt();
                            if (buildings.containsKey(answer)) {
                                building = buildings.get(answer);
                                Integer location_code = building.getfirst_location_code() + 1;
                                Insert_Location_to_SEP location = new Insert_Location_to_SEP(location_code,random_number.nextInt(101),Math.round((random_number.nextDouble() * 200 * 100.00)) / 100.00,Math.exp((-1) * 1 / (double) 1000));
                                building.setfirst_location_code(location_code);
                                building.add_location_to_HashMap(location.getLocation_code(),location);
                                correct_input = true;
                                System.out.println("Location insertion successful!\n");
                            } else {
                                System.out.println("Invalid Input!Try Again!Valid numbers: " + buildings.keySet() + "Choose: ");
                            }
                        }
                        break;
                    case 3:
                        for (Integer key : buildings.keySet()) {
                            building = buildings.get(key);
                            file_handler.write_toFile(building,key);
                        }
                        System.out.println("Choose a building by giving a valid number! Available buildings: " + buildings.keySet());
                        correct_input = false;
                        while (correct_input == false) {
                                answer = input.nextInt();
                                if ( buildings.containsKey(answer) ) {
                                    building = buildings.get(answer);
                                    Refresh_Sensors_Measurements refresher = new Refresh_Sensors_Measurements(building.getLocations());
                                    refresher.renewing_sensor_readings();
                                    System.out.println("Sensors Refresh Complete");
                                    if (building_counter != 1) {
                                        System.out.print("Thelete na pragmatopoihthei kai se allo ktirio i ananeosh twn metrisewn Yes or No:");
                                        String user_answer = input.next();
                                        if (!user_answer.equals("Yes")) {
                                                correct_input = true;
                                        }
                                    }else{
                                      correct_input = true;
                                    }
                                }else{
                                    System.out.print("Invalid Input!Try Again!Valid numbers: " + buildings.keySet() + "Choose: ");
                                }
                        }
                        break;
                    case 4:
                        System.out.println("Choose a building by giving a valid number! Available buildings: " + buildings.keySet());
                        correct_input = false;
                        while (correct_input == false) {
                            answer = input.nextInt();
                            if (buildings.containsKey(answer)) {
                                building = buildings.get(answer);
                                Area_Fire_Control object_handler = new Area_Fire_Control(building.getLocations());
                                object_handler.check_for_fire();
                                correct_input = true;
                            } else {
                                System.out.print("Invalid Input!Try Again!Valid numbers: " + buildings.keySet() + "Choose: ");
                            }
                        }
                        break;
                    case 5:
                        file_handler.close_file();
                        System.out.println("Program Ended!");
                        end = true;
                        break;
                }





        }while(end != true);
    }
}
