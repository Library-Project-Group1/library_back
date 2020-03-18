package com.group1.library.test.service;

import com.group1.library.product.Category;
import com.group1.library.product.CategoryServiceImpl;
import org.junit.*;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.fail;

public class CategoryServiceTest {

    private static CategoryServiceImpl categoryService;
    private static Instant startedAt;
    private static List<Category> testList;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Avant tout");
        categoryService = new CategoryServiceImpl();
        testList = new LinkedList<>();
        startedAt =Instant.now();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Après tout");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Avant un test");
        Category cat1 = new Category("salut");
        Category cat2 = new Category("coucou");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Après un test");
    }

    @Test
    public void testAdd() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetById() {
        fail("Not yet implemented");
    }

    @Test
    public void testEdit() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemove() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAll() {
        fail("Not yet implemented");
    }
}
