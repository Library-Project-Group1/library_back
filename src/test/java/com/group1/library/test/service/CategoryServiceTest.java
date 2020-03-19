package com.group1.library.test.service;

import com.group1.library.product.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private static CategoryServiceImpl categoryService;

//    @Captor
//    private ArgumentCaptor<Category> categoryArgumentCaptor;

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
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @AfterEach
    public void AfterMethod() {
        System.out.println("Après un test");
    }

    @Test
    public void testAddCategory() throws CategoryAlreadyExistsException {
        System.out.println("addCategory()");
        Category addCatToTest = new Category("akim");
        when(categoryRepository.save(any(Category.class))).then(returnsFirstArg());
        Category catRegistered = categoryService.add(addCatToTest);
        Assert.assertEquals(catRegistered.getName(), addCatToTest.getName());
        if (!catRegistered.getName().equals(addCatToTest.getName())) {
            fail("The add method doesn't work properly");
        }
    }

    @Test
    public void testGetCategoryById() throws CategoryNotFoundException {
        System.out.println("getCategoryById()");
        Long catToFindId = 1L;
        Category expResult = new Category(catToFindId, "category name");
        when(categoryRepository.findById(catToFindId)).thenReturn(Optional.of(expResult));
        Category result = categoryService.getById(expResult.getId());
        Assert.assertEquals(result.getId(), expResult.getId());
        if (!result.getName().equals(expResult.getName())) {
            fail("The getCategoryById method doesn't work properly");
        }
    }

    @Test
    public void testDeleteCategory() {
        System.out.println("DeleteCategory()");
        Long catToFindId = 1L;
        Category expResult = new Category(catToFindId, "category name");
        when(categoryRepository.findById(catToFindId)).thenReturn(Optional.of(expResult));
        Category result = categoryService
//        Long catId=3L;
//
//        // perform the call
//        categoryService.remove(catId);
//
//        // verify the mocks
//        verify(categoryRepository, times(1)).deleteById(eq(catId));

//        doAnswer(new Answer<Void>() {
//            @Override
//            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
//
//                Object[] arguments = invocationOnMock.getArguments();
//                if (arguments != null && arguments.length > 1 && arguments[0] != null && arguments[1] != null) {
//                    Category catToDelete = (Category) arguments[0];
//                    Long id = (Long) arguments[1];
//                    catToDelete.setId(id);
//                }
//                return null;
//            }
//        }).when(categoryRepository).delete(any(Category.class));
//        // calling the method under test
//        Category category = categoryService.remove();
//        //some asserts
//        assertThat(category, is(notNullValue()));
//        assertThat(customer.getEmail(), is(equalTo("new@test.com")));
    }
}
