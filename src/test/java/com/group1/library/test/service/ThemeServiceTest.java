package com.group1.library.test.service;

import com.group1.library.product.*;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ThemeServiceTest {

    @InjectMocks
    private ThemeServiceImpl themeService; // System under test

    @Mock
    private ThemeRepository themeRepository;

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
    public void setUpBeforeMethod() throws ThemeAlreadyExistsException {
        System.out.println("Avant un test");
        Theme theme1 = new Theme(1L, "Book");
        Theme theme2 = new Theme(2L, "Video Game");
        themeService.add(theme1);
        themeService.add(theme2);
    }

    @AfterEach
    public void AfterMethod() {
        System.out.println("Après un test");
    }

    @Test
    public void testAddTheme() throws ThemeAlreadyExistsException {
        System.out.println("addTheme()");
        Theme expResult = new Theme("easy");
        when(themeRepository.save(any(Theme.class))).then(returnsFirstArg());
        Theme result = themeService.add(expResult);
        assertEquals(expResult, result);
        if (!result.getName().equals(expResult.getName())) {
            fail("The addTheme method doesn't return a proper value");
        }
    }

    @Test
    public void testGetThemeById() throws ThemeNotFoundException {
        System.out.println("getThemeById()");
        when(themeRepository.findById(1L)).thenReturn(Optional.of(new Theme(1L, "Lokesh")));
        Theme result = themeService.getById(1L);
        assertEquals("Lokesh", result.getName());
        if (!result.getName().equals("Lokesh")) {
            fail("The getThemeById method doesn't return a proper value");
        }
    }

    @Test
    public void testEditTheme() throws ThemeNotFoundException {
        System.out.println("editTheme()");
        when(themeRepository.findById(1L)).thenReturn(Optional.of(new Theme(1L, "Audrey")));
        Theme oldTheme = themeService.getById(1L);
        oldTheme.setName("Audrey");
        themeService.editById(oldTheme.getId(), oldTheme.getName());
        verify(themeRepository).save(eq(oldTheme));
    }

    @Test
    public void testDeleteTheme() {
        System.out.println("deleteTheme()");
        Long themeId = 1L;

        // perform the call
        themeService.removeById(themeId);

        // verify the mocks
        verify(themeRepository).deleteById(eq(themeId));
    }

    @Test
    public void testGetAllThemes() {
        System.out.println("getAllThemes()");
        List<Theme> expList = new ArrayList<Theme>();
        Theme theme1 = new Theme(1L, "a");
        Theme theme2 = new Theme(2L, "b");
        Theme theme3 = new Theme(3L, "c");
        Theme theme4 = new Theme(4L, "d");
        Theme theme5 = new Theme(5L, "e");
        Theme theme6 = new Theme(6L, "f");
        expList.add(theme1);
        expList.add(theme2);
        expList.add(theme3);
        expList.add(theme4);
        expList.add(theme5);
        expList.add(theme6);

        when(themeRepository.findAll()).thenReturn(expList);

        Iterable<Theme> testList = themeService.getAll();

        assertEquals(expList.size(), StreamSupport.stream(testList.spliterator(), false).count());
        if (expList.size() != (StreamSupport.stream(testList.spliterator(), false).count())) {
            fail("The getAllThemes method doesn't return a proper value");
        }
    }
}

