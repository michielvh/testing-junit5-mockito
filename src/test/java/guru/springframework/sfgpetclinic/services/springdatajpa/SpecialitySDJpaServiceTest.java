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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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

    @Test
    void findByIdBddTest() {
        // BDD : same test - written differently

        //GIVEN
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));

        //WHEN
        Speciality foundSpeciality = service.findById(1L);

        //THEN
        assertThat(foundSpeciality).isNotNull();

        // verify(specialtyRepository,times(1)).findById(1L);

        then(specialtyRepository).should().findById(anyLong());
        //  ==  use one or the other
        then(specialtyRepository).should(times(1)).findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteByObjectBdd() {
        //given
        Speciality speciality = new Speciality();

        //when
        service.delete(speciality);

        //then
        then(specialtyRepository).should().delete(any(Speciality.class));
    }

    @Test
    void deleteByIdBdd() {
        //given none

        //when
        service.deleteById(1l);
        service.deleteById(1l);

        //then
        then(specialtyRepository).should(times(2)).deleteById(1l);
    }


    @Test
    void deleteByIdAtLeastBdd() {
        //given

        //when
        service.deleteById(1l);
        service.deleteById(1l);

        //then
        then(specialtyRepository).should(atLeastOnce()).deleteById(1l);
    }

    @Test
    void deleteByIdAtMostBdd() {
        //given

        //when
        service.deleteById(1l);
        service.deleteById(1l);

        //then
        then(specialtyRepository).should(atMost(5)).deleteById(1l);
    }


    @Test
    void deleteByIdNeverBdd() {

        //given

        //when
        service.deleteById(1l);
        service.deleteById(1l);

        //then
        then(specialtyRepository).should(atLeastOnce()).deleteById(1l);
        then(specialtyRepository).should(never()).deleteById(5l);


    }

    @Test
    void testDeleteBdd() {

        //given

        //when
        service.delete(new Speciality());

        //then
        then(specialtyRepository).should().delete(any());
    }
}