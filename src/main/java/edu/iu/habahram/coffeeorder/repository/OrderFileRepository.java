package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

@Repository
public class OrderFileRepository {
    private static final Logger LOG =
            LoggerFactory.getLogger(OrderFileRepository.class);
    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        Random rand = new Random();
        int id = rand.nextInt(9999);
        Receipt receipt = new Receipt(id, beverage.getDescription(), beverage.cost());

        try (FileWriter fileWriter = new FileWriter("db.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(id + "," + beverage.getDescription() + "," + beverage.cost());
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }

        return receipt;
    }
}
