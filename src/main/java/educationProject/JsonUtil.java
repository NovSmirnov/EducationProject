package educationProject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtil {
    private static final Logger logger = LogManager.getLogger(JsonUtil.class);

    private JsonUtil() {

    }

    public static String studSer(Student student) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(gson.toJson(student));
        return gson.toJson(je);
    }

    public static Student studDeSer(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, Student.class);
    }

//    public static String studColSer(ArrayList<Student> studList) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonElement je = JsonParser.parseString(gson.toJson(studList));
//        return gson.toJson(je);
//    }

//    public static ArrayList<Student> studColDeSer(String json) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Type type = new TypeToken<ArrayList<Student>>(){}.getType();
//        return gson.fromJson(json, type);
//    }

    public static String univSer(University university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(gson.toJson(university));
        return gson.toJson(je);
    }

    public static University univDeSer(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, University.class);
    }

//    public static String univColSer(ArrayList<University> univList) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonElement je = JsonParser.parseString(gson.toJson(univList));
//        return gson.toJson(je);
//    }

//    public static ArrayList<University> univColDeSer(String json) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Type type = new TypeToken<ArrayList<University>>(){}.getType();
//        return gson.fromJson(json, type);
//    }


    public static <E> String CollectionSerializer(ArrayList<E> objList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(gson.toJson(objList));
        String className = objList.get(0).getClass().toString();
        logger.info("Коллекция объектов типа " + className + " успешно сериализована");
        return gson.toJson(je);
    }

    public static <E> ArrayList<E> CollectionDeSerializer(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<ArrayList<E>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
