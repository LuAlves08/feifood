package model;

import java.util.HashMap;
import java.util.Map;

public class PizzaDatabase {

    // Banco Global de Pizzas Personalizadas
    private static final Map<String, String> pizzasPersonalizadas = new HashMap<>();

    public static void adicionarPizza(String nome, String ingredientes) {
        pizzasPersonalizadas.put(nome.toLowerCase(), ingredientes);
    }

    public static Map<String, String> getPizzas() {
        return pizzasPersonalizadas;
    }

    public static boolean existe(String nome) {
        return pizzasPersonalizadas.containsKey(nome.toLowerCase());
    }

    public static String getIngredientes(String nome) {
        return pizzasPersonalizadas.get(nome.toLowerCase());
    }
}
