package com.group1.library.test.service;

import com.group1.library.product.Category;
import com.group1.library.product.CategoryAlreadyExistsException;
import com.group1.library.product.CategoryServiceImpl;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
//import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CategoryServiceTest {

    private static CategoryServiceImpl categoryService;
    private static Instant startedAt;
//    private static List<Category> testCatList;
//    private static final Long MIN = 1L;
//    private static final Long MAX = 10L;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Avant tout");
        categoryService = new CategoryServiceImpl();
        startedAt = Instant.now();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Après tout");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @BeforeEach
    public void setUpBeforeMethod() {
        System.out.println("Avant un test");
//        Category cat1 = new Category("salut");
//        Category cat2 = new Category("coucou");
//        Category cat3 = new Category("a");
//        Category cat4 = new Category("b");
//        Category cat5 = new Category("c");
//        Category cat6 = new Category("d");
//        Category cat7 = new Category("e");
//        Category cat8 = new Category("f");
//            testCatList.add(cat1);
//            testCatList.add(cat2);
//            testCatList.add(cat3);
//            testCatList.add(cat4);
//            testCatList.add(cat5);
//            testCatList.add(cat6);
//            testCatList.add(cat7);
//            testCatList.add(cat8);
    }

    @AfterEach
    public void tearDownAfterMethod() {
        System.out.println("Après un test");
    }

    @Test
    public void testCRUDCategory() throws CategoryAlreadyExistsException {
        Category catToTest = new Category("akim");
        categoryService.add(catToTest);
        assertEquals(catToTest.getName(), "akim");
    }
//    @Test
//    public void testAddCategory() throws CategoryAlreadyExistsException {
//        Category newCatTest= new Category("g");
//        categoryService.add(newCatTest);
//        assertEquals(newCatTest, categoryService.add(newCatTest));
//    }
//        // Gets two random numbers for these tests
//        Long randomId = MIN + (long)(Math.random()*((MAX - MIN) + 1L));
//        Long updateRandom = MIN + (long)(Math.random()*((MAX - MIN) + 1L));
//
//        // Category is the domain object
//        Category category = new Category();
//
//        // The method findAll brings back all the categories from the DB
//        Iterable<Category> firstFindAll = categoryService.getAll();
//
//        // Category gets mock values and is persisted. Id is returned
//        category = getMockCategoryValues(category, randomId);
//        persist(category);
//        Long id = category.getId();
//
//        // Find the created object with the given Id and makes sure it has the right values
//        item = find(id);
//        assertNotNull("Object should exist", item);
//        checkMockItemValues(item, random);
//
//        // Updates the object with new random values
//        item = getMockItemValues(item, updateRandom);
//        merge(item);
//
//        // Find the updated object and makes sure it has the new values
//        item = em.find(Item.class, id);
//        assertNotNull("Object should exist", item);
//        checkMockItemValues(item, updateRandom);
//
//        // Gets all the objects from the database...
//        int secondFindAll = findAll();
//
//        // ...and makes sure there is one more object
//        if (firstFindAll + 1 != secondFindAll) fail("The collection size should have increased by 1");
//
//        // The object is now deleted
//        remove(item);
//
//        // Find the object and make sure it has been removed
//        item = em.find(Item.class, id);
//        assertNull("Object should not exist", item);
//
//        // Gets all the objects from the database...
//        int thirdFindAll = findAll();
//
//        // ...and makes sure we have the original size
//        if (firstFindAll != thirdFindAll) fail("The collection size should have be the same as original");

//
//    @Test
//    public void testAdd() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testGetById() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testEdit() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testRemove() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testGetAll() {
//        fail("Not yet implemented");
//    }
}
