package collection_Maps;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] arg){
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, object-oriented, platform language");
        languages.put("Python", " a interpreted, o-o, high-level programiing with dynamic semantics");
        languages.put("Algol", "an algotirhimc languahe");
        languages.put("BASIC", "BEginners All Pruposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));
        languages.put("Java", "This course is about Java ");
        System.out.println(languages.get("Java"));

        if(languages.containsKey("Java")){
            System.out.println("Java exists");
        }else{
            languages.put("Java", "This course is about Java ");
        }

        System.out.println("==============");

        for(String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }

    }


}
