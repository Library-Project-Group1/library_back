//package com.group1.library.unitary.tests.service;
//
//import com.group1.library.entity.Product;
//import com.group1.library.exception.alreadyexists.ProductAlreadyExistException;
//import com.group1.library.exception.notfound.ProductNotFoundException;
//import com.group1.library.repository.ProductRepository;
//import com.group1.library.service.inter.ProductService;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.text.MessageFormat;
//import java.time.Duration;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.StreamSupport;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @InjectMocks
//    private ProductService productService;
//
//    @Mock
//    private ProductRepository productRepository;
//
//    private static Instant startedAt;
//
//    @BeforeAll
//    public static void setUpBeforeClass() {
//        System.out.println("Avant tout");
//        startedAt = Instant.now();
//    }
//
//    @AfterAll
//    public static void timeCalculAfterClass() {
//        System.out.println("Après tout");
//        Instant endedAt = Instant.now();
//        long duration = Duration.between(startedAt, endedAt).toMillis();
//        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
//    }
//
//    @BeforeEach
//    public void setUpBeforeMethod() {
//        System.out.println("Avant un test");
//    }
//
//    @AfterEach
//    public void AfterMethod() {
//        System.out.println("Après un test");
//    }
//
//    @Test
//    public void testAddProduct() throws ProductAlreadyExistException {
//        System.out.println("addProduct()");
//        Product expResult = new Product("p_title", "p_creator", "E yyyy.MM.dd", "p_description", 12L, 7L, 5L, 4, 3.99f,  );
//        when(productRepository.save(any(Product.class))).then(returnsFirstArg());
//        Product result = productService.addProduct(expResult);
//        assertEquals(expResult.getTitle(), result.getTitle());
//        if (!result.getTitle().equals(expResult.getTitle())) {
//            fail("The add method doesn't return a proper title");
//        }
//        assertEquals(expResult.getCreator(), result.getCreator());
//        if (!result.getCreator().equals(expResult.getCreator())) {
//            fail("The add method doesn't return a proper creator");
//        }
//        assertEquals(expResult.getQuantityTotal(), result.getQuantityTotal());
//        if (!result.getQuantityTotal().equals(expResult.getQuantityTotal())) {
//            fail("The add method doesn't return a proper total quantity");
//        }
//        assertEquals(expResult.getQuantityAvailableToRent(), result.getQuantityAvailableToRent());
//        if (!result.getQuantityAvailableToRent().equals(expResult.getQuantityAvailableToRent())) {
//            fail("The add method doesn't return a proper quantity available to rent");
//        }
//        assertEquals(expResult.getQuantityAvailableToRent(), result.getQuantityAvailableToRent());
//        if (!result.getQuantityAvailableToRent().equals(expResult.getQuantityAvailableToRent())) {
//            fail("The add method doesn't return a proper quantity available to rent");
//        }
//        assertEquals(expResult.getQuantityIsRenting(), result.getQuantityIsRenting());
//        if (!result.getQuantityIsRenting().equals(expResult.getQuantityIsRenting())) {
//            fail("The add method doesn't return a proper quantity already rents");
//        }
//        assertEquals(expResult.getPrice(), result.getPrice());
//        if (result.getPrice() != (expResult.getPrice())) {
//            fail("The add method doesn't return a proper price");
//        }
//        assertEquals(expResult.getReleaseDate(), result.getReleaseDate());
//        if (!result.getReleaseDate().equals(expResult.getReleaseDate())) {
//            fail("The add method doesn't return a proper released date");
//        }
//        assertEquals(expResult.getDescription(), result.getDescription());
//        if (!result.getDescription().equals(expResult.getDescription())) {
//            fail("The add method doesn't return a proper description");
//        }
//    }
//
//    @Test
//    public void testFindProductById() throws ProductNotFoundException {
//        System.out.println("findProductById()");
//        Product expResult = new Product("p_title", "p_creator", 12L, 7L, 5L, 4, 3.99f, "E yyyy.MM.dd", "p_description");
//        when(productRepository.findById(1L)).thenReturn(Optional.of(expResult));
//        Product result = productService.findProductById(1L);
//        assertEquals(expResult, result);
//        if (!result.equals(expResult)) {
//            fail("The getProductById method doesn't return a proper Product");
//        }
//    }
//
//    @Test
//    public void testRemoveProductById() throws ProductNotFoundException {
//        System.out.println("deleteProductById()");
//        Long prodId = 1L;
//
//        // perform the call
//        productService.removeProductById(prodId);
//
//        // verify the mocks
//        verify(productRepository).deleteById(eq(prodId));
//    }
//
//    @Test
//    public void testGetAllProducts() {
//        System.out.println("getAllProducts()");
//        List<Product> expList = new ArrayList<Product>();
//        Product p1 = new Product("p_title1", "p_creator", 12L, 7L, 5L, 4, 3.99f, "E yyyy.MM.dd", "p_description");
//        Product p2 = new Product("p_title2", "p_creator", 12L, 7L, 5L, 4, 3.99f, "E yyyy.MM.dd", "p_description");
//        Product p3 = new Product("p_title3", "p_creator", 12L, 7L, 5L, 4, 3.99f, "E yyyy.MM.dd", "p_description");
//        expList.add(p1);
//        expList.add(p2);
//        expList.add(p3);
//
//        when(productRepository.findAll()).thenReturn(expList);
//
//        Iterable<Product> testList = productService.findAllProducts();
//
//        assertEquals(expList.size(), StreamSupport.stream(testList.spliterator(), false).count());
//        if (expList.size() != (StreamSupport.stream(testList.spliterator(), false).count())) {
//            fail("The getAllProducts method doesn't return a proper value");
//        }
//    }
//}
