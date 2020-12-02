package com.mhuffers.unittesting.unittesting.data;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mhuffers.unittesting.unittesting.model.Item;
import com.mhuffers.unittesting.unittesting.repository.ItemRepository;

/*
 * here we want the in memory database to be created and loaded with data.sql and for that we are using @DataJpaTest.
 * This also requires us to load the spring context. Therefore we are using SpringRunner. otherwise MockitoJunitRunner is sufficient.
 * 
 * Also, in a real world applications, we would be using some real database and not in-memory db. in such scenarios, we can create a resource
 * folder inside src/test and put your data.sql file there. Thus @DataJpaTest will use that to populate the in-memory database.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void testFindAll() {
		List<Item> items = itemRepository.findAll();
		assertEquals(5,items.size());
	}
}
