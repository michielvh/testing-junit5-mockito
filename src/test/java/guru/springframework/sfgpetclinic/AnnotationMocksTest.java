package guru.springframework.sfgpetclinic;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMock;


    // creates new mock for each testmethod
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

   @Test
    void testMock() {
        mapMock.put("keyvalue","foo");
    }
}
