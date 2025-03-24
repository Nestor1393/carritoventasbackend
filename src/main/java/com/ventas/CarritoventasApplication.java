package com.ventas;

import com.ventas.entities.*;
import com.ventas.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class CarritoventasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarritoventasApplication.class, args);
    }

/*
    @Bean
    CommandLineRunner commandLineRunner(
            AddressRepository addressRepository,
            CategoryRepository categoryRepository,
            CityRepository cityRepository,
            CustomerRepository customerRepository,
            OrderDetailRepository orderDetailRepository,
            OrderRepository orderRepository,
            PersonRepository personRepository,
            ProductRepository productRepository,
            RoleRepository roleRepository,
            StateRepository stateRepository,
            SupplierRepository supplierRepository,
            UserRepository userRepository

    ) {

        return args -> {


            State state = new State(null, "CDMX", null);
            City city = new City(null, "Temixco", null, state);
            Address address = new Address(null, "Margaritas", 10, "Miguel Hidalgo", 5670, null, city);
            Address address2 = new Address(null, "Tornado", 15, "Alvaro Obregón", 5675, null, city);

            Person person = new Person(null, "Nestor", "Muñoz Jimenez", LocalDate.of(2023, 11, 21), "nestor@gmail.com", null);

            Person person2 = new Person(null, "Alejandro", "Muñoz Jimenez", LocalDate.of(2003, 12, 21), "ale@gmail.com", null);
            User user = new User(null, "nestor3@gmail.com", "abc2023", person, null, null);
            Role role = new Role(null, "Estandar", null);
            Customer customer = new Customer(null, null);
            Order order = new Order(null, 6743, 543.00, 630.00, LocalDateTime.of(LocalDate.now(), LocalTime.now()), null, user, customer);

            Product product = new Product(null, "Laptop L43", 543.00, 10, "LPl43", "Computadora portatil");
            OrderDetail orderDetail = new OrderDetail(null, 1, 543.00, null, order);
            Supplier supplier = new Supplier(null, "Lenovo");
            Category category = new Category(null, "Dispositivo Electrónico");

            //constructores creados en Address, Category, Customer, person, product, supplier


            state.setCities(Set.of(city));
            state = stateRepository.save(state);

            city.setAddresses(Set.of(address));
            city = cityRepository.save(city);

            person = personRepository.save(person);
            person2 = personRepository.save(person2);

            address.setPersons(Set.of(person));
            address = addressRepository.save(address);

            //Direccion registrada para customer
            address2.setPersons(Set.of(person2));
            address2 = addressRepository.save(address2);

            person.setId_address(address);
            person = personRepository.save(person);

            user.setRoles(Set.of(role));
            user.setOrders(Set.of(order));
            user = userRepository.save(user);

            role.setUsers(Set.of(user));
            role = roleRepository.save(role);

            //se registra una nueva persona para customer, asi sera diferente a user.
            person2.setId_address(address2);
            person2 = personRepository.save(person2);

            customer.setOrders(Set.of(order));
            customer.setId_person(person2);
            customer = customerRepository.save(customer);

            order.setOrderDetails(Set.of(orderDetail));
            order = orderRepository.save(order);

            product = productRepository.save(product);

            orderDetail.setId_product(product);
            orderDetail = orderDetailRepository.save(orderDetail);

            product.setOrderDetails(Set.of(orderDetail));
            product = productRepository.save(product);

            supplier = supplierRepository.save(supplier);
            supplier.setProducts(Set.of(product));
            supplier = supplierRepository.save(supplier);

            category = categoryRepository.save(category);
            category.setProducts(Set.of(product));
            category = categoryRepository.save(category);

            product.setId_category(category);
            product = productRepository.save(product);

            product.setId_supplier(supplier);
            product = productRepository.save(product);

        };

    } */


}
