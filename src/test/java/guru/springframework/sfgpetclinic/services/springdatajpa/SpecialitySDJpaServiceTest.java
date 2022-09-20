package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.security.Provider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    //injectMocks means inject the SpecialityRepository Mock into the class
    //because the service constructor needs a SpecialityRepository
    //the class itself is no mock
    //it is a regular service
    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void deleteById() {
        service.deleteById(1l);
    }

    @Test
    void testDelete() {

        service.delete(new Speciality());
    }
}