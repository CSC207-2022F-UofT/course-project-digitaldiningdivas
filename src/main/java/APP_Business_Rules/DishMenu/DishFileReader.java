package APP_Business_Rules.DishMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A Dish file reading class that implements the dish data access interface to access the methods needed.
 * Reads from the dish file and produces a hashmap of the information to be presented.
 */
public class DishFileReader implements DishDataAccess{
    String file;
    HashMap<String, List<List<String>>> dishes = new HashMap<>();

    /**
     * Instantiates a new file reader.
     * @param file: A string of the file name to be read by the file reading object.
     */
    public DishFileReader(String file){
        this.file = file;
    }

    /**
     * Creates a hashmap from reading the given file. Each line in the CSV is split by the commas, the first item
     * which is always the restaurant name each dish belongs to becomes a key. The function checks if this key is
     * not in the hashmap, if not it creates it, otherwise it places the remaining values of the line in a list of
     * strings corresponding to the restaurant key. Each line is a dish.
     * @return a hashmap of strings to list of list of strings. Each key is a restaurant name, the list contains
     * dish objects represented as lists of strings.
     */
    public HashMap<String, List<List<String>>> createList() {
        String line = "";
        String splitBy = ",";
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine(); // skip header
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] dish = line.split(splitBy);
                String key = dish[0];

                if (!dishes.containsKey(key)){
                    List<List<String>> values = new ArrayList<>();
                    dishes.put(key, values);
                }
                List<String> listPiece = new ArrayList<>(dish.length);
                for(int i = 1; i < dish.length; i++)
                {
                    listPiece.add(dish[i]);
                }
                dishes.get(key).add(listPiece);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    /**
     * An implementation of the DishDataAccess interface method getDish which returns the dishes in the file.
     * @param file: The chosen file to read from.
     * @return: a hashmap of strings to list of list of strings. Each key is a restaurant name, the list contains
     * dish objects represented as lists of strings.
     */
    @Override
    public HashMap<String, List<List<String>>> getDish(String file){
        DishFileReader fileReader = new DishFileReader(file);
        return fileReader.createList();
    }

    /**
     * Checks if the given dish name exists in the hashmap.
     * @param identifier: the string that will be checked for matches in hashmap.
     * @return true iff string identifier is found.
     */
    @Override
    public boolean dishExistsByName(String identifier){
        return dishes.equals(identifier);
    }

}