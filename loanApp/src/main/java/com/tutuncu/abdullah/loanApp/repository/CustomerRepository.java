package com.tutuncu.abdullah.loanApp.repository;

import com.tutuncu.abdullah.loanApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.identityNumber=?1 and c.password=?2")
    Customer findByIdentityNumberAndPassword(String identityNumber, String password);

    @Query("select  c from Customer c where c.identityNumber=?1")
    Customer findByIdentityNumber(String identityNumber);

    @Query("select c.identityNumber from Customer c where c.identityNumber=?1")
    String smsIdentity(String identityNumber);

    @Query("select c.monthlyIncome from Customer c where c.identityNumber=?1")
    int findMonthlyIncome(String identityNumber);

    @Query("select c.loanScore from Customer c where c.identityNumber=?1")
    int findLoanScore(String identityNumber);

    @Query("select c.guarantee from Customer c where c.identityNumber=?1")
    int findGuarantee(String identityNumber);

    @Query("select c.phoneNumber from Customer c where c.identityNumber=?1")
    String findCustomerPhoneNumber(String identityNumber);


}
