package com.mhuffers.unittesting.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mhuffers.unittesting.unittesting.model.Item;

/*
 * for this repository we don't really need any unit test cases but if we had implemented some Hibernate repository where we have some 
 * custom logic, then there we can make use of @DataJpaTest
 */
public interface ItemRepository extends JpaRepository<Item,Integer>{

}
