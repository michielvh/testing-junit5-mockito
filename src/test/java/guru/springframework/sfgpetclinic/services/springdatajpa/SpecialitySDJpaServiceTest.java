package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.security.Provider;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    void findById() {

        Speciality speciality = new Speciality();

        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));

        Speciality foundSpeciality = service.findById(1L);

        //assertJ
        assertThat(foundSpeciality).isNotNull();

        verify(specialtyRepository,times(1)).findById(1L);
    }


    @Test
    void deleteById() {
        service.deleteById(1l);
        service.deleteById(1l);
       // service.delete(new Speciality());

        verify(specialtyRepository,times(2)).deleteById(1l);
        //verify(specialtyRepository,times(1)).delete(any());
    }

    @Test
    void deleteByIdAtLeast() {
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository,atLeastOnce()).deleteById(1l);
    }

    @Test
    void deleteByIdAtMost() {
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository,atMost(5)).deleteById(1l);
    }


    @Test
    void deleteByIdNever() {
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository,atMost(5)).deleteById(1l);


        // mock gets called never with this method+param
        verify(specialtyRepository,never()).deleteById(5l);
    }
    @Test
    void testDelete() {

        service.delete(new Speciality());
    }

    @Test
    void deleteByObject() {
        Speciality speciality = new Speciality();

        service.delete(speciality);

        verify(specialtyRepository).delete(any(Speciality.class));
    }
}