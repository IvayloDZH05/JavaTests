package mockito;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PasswordValidatorTest {


    private User user;
    private User mockUser;
    @Before
    public void setUp() {
        user = new User("UserTest", "19223");
        mockUser = mock(User.class);
        when(mockUser.authenticate("19223")).thenAnswer(invocation -> {
            throw new Exception("Course Number");
        });
        when(mockUser.authenticate(anyString())).thenAnswer(invocation -> {
            Object arg = invocation.getArgument(0);
            return !"19212".equals(arg);
        });
    }
    @Test
    public void testExceptionOnMatchingPassword() {
        try {
            mockUser.authenticate("19212");
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals("Course Number", e.getMessage());
        }
    }
    @Test
    public void testFalseOnNonMatchingPassword() throws Exception {
        boolean result = mockUser.authenticate("passwords");
        assertFalse(result);
    }
}