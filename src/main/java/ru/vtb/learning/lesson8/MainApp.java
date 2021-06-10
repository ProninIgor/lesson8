package ru.vtb.learning.lesson8;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class MainApp {
    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Repository<User> repository = new Repository<>(factory, User.class);
        User user1 = repository.getById(1);

        User user2 = new User();
        user2.setName("Ivan");
        repository.save(user2);

        User testUser2 = repository.getById(2);
        System.out.println(testUser2.getId() + " - " + testUser2.getName());

        factory.close();
    }
}
