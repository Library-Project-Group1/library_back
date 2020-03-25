package com.group1.library.test.service;

import com.group1.library.entity.User;
import com.group1.library.exception.notfound.UserNotFoundException;
import com.group1.library.repository.UserRepository;
import com.group1.library.service.impl.UserServiceImpl;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

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

    /*@Test
    public void testAddUser() throws UserAlreadyExistsException {
        System.out.println("addUser()");
        User expResult = new User("abc@gmail.com", "******");
        when(userRepository.save(any(User.class))).then(returnsFirstArg());
        userService.addUser(expResult);
        verify(userRepository).save(eq(expResult));
    }*/

    @Test
    public void testRemoveUserByEmail() throws UserNotFoundException {
        System.out.println("removeUserByEmail()");
        when(userRepository.getUserByEmail("azerty@hotmail.fr")).thenReturn(new User("azerty@hotmail.fr", "123456"));
        User userToRemove = userService.findUserByEmail("azerty@hotmail.fr");
        userService.removeUserByEmail("azerty@hotmail.fr");
        verify(userRepository).deleteById(eq(userToRemove.getId()));
    }

    @Test
    public void testRemoveUserById() throws UserNotFoundException {
        System.out.println("removeUserById()");
        Long userId = 1L;

        // perform the call
        userService.removeUserById(userId);

        // verify the mocks
        verify(userRepository).deleteById(eq(userId));
    }

    @Test
    public void testFindUserById() throws UserNotFoundException {
        System.out.println("findUserById()");
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L,"hello@coucou.com", "salut")));
        User userToFind = userService.findUserById(1L);
        assertEquals(1L, userToFind.getId());
        if (userToFind.getId() != (1L)) {
            fail("The findUserById method doesn't return a proper id");
        }
    }

    @Test
    public void testFindUserByEmail() throws UserNotFoundException {
        System.out.println("findUserByEmail()");
        when(userRepository.getUserByEmail("blabla@gmail.com")).thenReturn(new User(1L,"blabla@gmail.com", "abc321"));
        User userToFind = userService.findUserByEmail("blabla@gmail.com");
        assertEquals("blabla@gmail.com", userToFind.getEmail());
        if (!userToFind.getEmail().equals("hello@coucou.com")) {
            fail("The findUserById method doesn't return a proper email");
        }
    }

    @Test
    public void testUpdateUserById() throws UserNotFoundException {
        System.out.println("updateUserPasswordById()");
        when(userRepository.findById(2L)).thenReturn(Optional.of(new User(2L, "a@b.com", "newPassword")));
        User oldUser = userService.findUserById(2L);
        oldUser.setPassword("newPassword");
        userService.updateUserById(oldUser.getId(), oldUser.getPassword());
        verify(userRepository).save(eq(oldUser));
    }

    @Test
    public void testUpdateUserByEmail() throws UserNotFoundException {
        System.out.println("updateUserPasswordByEmail()");
        when(userRepository.getUserByEmail("123@mdr.fr")).thenReturn(new User("123@mdr.fr", "newPassword"));
        User oldUser = userService.findUserByEmail("123@mdr.fr");
        oldUser.setPassword("newPassword");
        userService.updateUserByEmail(oldUser.getEmail(), oldUser.getPassword());
        verify(userRepository).save(eq(oldUser));
    }

    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers()");
        List<User> expList = new ArrayList<User>();
        User u1 = new User(1L, "a@yahoo.fr", "*");
        User u2 = new User(2L, "b@yahoo.fr", "**");
        User u3 = new User(3L, "c@yahoo.fr", "***");
        User u4 = new User(4L, "d@yahoo.fr", "****");
        User u5 = new User(5L, "e@yahoo.fr", "*****");
        User u6 = new User(6L, "f@yahoo.fr", "******");
        expList.add(u1);
        expList.add(u2);
        expList.add(u3);
        expList.add(u4);
        expList.add(u5);
        expList.add(u6);

        when(userRepository.findAll()).thenReturn(expList);

        Iterable<User> testList = userService.getAllUsers();

        assertEquals(expList.size(), StreamSupport.stream(testList.spliterator(), false).count());
        if (expList.size() != (StreamSupport.stream(testList.spliterator(), false).count())) {
            fail("The getAllUsers method doesn't return a proper value");
        }
    }
    }
