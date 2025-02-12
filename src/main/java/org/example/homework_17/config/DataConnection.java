package org.example.homework_17.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//public class DataConnection {
//    public static final String PASSWORD = "111";
//    public static final String USERNAME = "postgres";
//    public static final String URL = "jdbc:postgresql://localhost:5432/postgres\n";
//
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("111");
//        return dataSource;
//    }
//
////    @Bean
////    public RecipeDaoImpl recipeDao(DataSource dataSource) {
////        return new RecipeDaoImpl(dataSource);
////    }
//}
