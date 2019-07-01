package com.globant.bootcamp.LoginService.repository;

import com.globant.bootcamp.LoginService.domain.Customer;
import com.globant.bootcamp.LoginService.utils.HibernateSqlUtil;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public class CustomCustomerRepository implements  CustomerRepository{
    @Override
    public List<Customer> findByLastName(String LastName) {
        return null;
    }

    @Override
    public <S extends Customer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    /*
    @Query("select u from User u where u.firstname = :#{#customer.firstname}")
    List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
    */
    @Override
    @Query( value="Select u from customer u where u.username =#{username}",
            nativeQuery = true
    )
    public Customer findByUsername(@Param("username") String username){
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {

    /*    Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateSqlUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            transaction.begin();

            // Obtain an entity using get() method
            Customer customer1 = session.get(Customer.class, 1L);
            if (customer1 != null) {
                System.out.println(customer1.getFirstName());
                transaction.commit();
                return Optional.of(customer1);
            }
            transaction.commit();
            return null;


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        HibernateSqlUtil.shutdown();
º       */
        return null;
    }



    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
