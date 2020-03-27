package com.group1.library.unitary.tests.service;

import com.group1.library.entity.Category;
import com.group1.library.exception.alreadyexists.CategoryAlreadyExistsException;
import com.group1.library.exception.notfound.CategoryNotFoundException;
import com.group1.library.repository.CategoryRepository;
import com.group1.library.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private static CategoryServiceImpl categoryService; //System under test

    private static Instant startedAt;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Avant tout");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void timeCalculAfterClass() {
        System.out.println("Après tout");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @BeforeEach
    public void setUpBeforeMethod() {
        System.out.println("Avant un test");
    }

    @AfterEach
    public void AfterMethod() {
        System.out.println("Après un test");
    }

    @Test
    public void testAddCategory() throws CategoryAlreadyExistsException {
        System.out.println("addCategory()");
        Category expResult = new Category("easy");
        when(categoryRepository.save(any(Category.class))).then(returnsFirstArg());
        Category result = categoryService.add(expResult);
        assertEquals(expResult, result);
        if (!result.getName().equals(expResult.getName())) {
            fail("The add method doesn't return a proper value");
        }
    }

    @Test
    public void testGetCategoryById() throws CategoryNotFoundException {
        System.out.println("getCategoryById()");
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(new Category(1L, "Lokesh")));
        Category result = categoryService.getById(1L);
        assertEquals("Lokesh", result.getName());
        if (!result.getName().equals("Lokesh")) {
            fail("The getCategoryById method doesn't a proper value");
        }
    }

    @Test
    public void testEditCategory() throws CategoryNotFoundException {
        System.out.println("editCategory()");
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(new Category(1L, "Audrey")));
        Category oldCat = categoryService.getById(1L);
        oldCat.setName("Audrey");
        categoryService.editById(oldCat.getId(), oldCat);
        verify(categoryRepository).save(eq(oldCat));
    }

    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory()");
        Long catId = 1L;

        // perform the call
        categoryService.removeById(catId);

        // verify the mocks
        verify(categoryRepository).deleteById(eq(catId));
    }

    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories()");
        List<Category> expList = new ArrayList<Category>();
        Category category1 = new Category(1L, "a");
        Category category2 = new Category(2L, "b");
        Category category3 = new Category(3L, "c");
        Category category4 = new Category(4L, "d");
        Category category5 = new Category(5L, "e");
        Category category6 = new Category(6L, "f");
        expList.add(category1);
        expList.add(category2);
        expList.add(category3);
        expList.add(category4);
        expList.add(category5);
        expList.add(category6);

        when(categoryRepository.findAll()).thenReturn(expList);

        Iterable<Category> testList = categoryService.getAll();

        assertEquals(expList.size(), StreamSupport.stream(testList.spliterator(), false).count());
        if (expList.size() != (StreamSupport.stream(testList.spliterator(), false).count())) {
            fail("The getAllCategories method doesn't return a proper value");
        }
    }
}
