package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sun.source.doctree.SeeTree;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        Visit visit = new Visit();
        Visit visit2 = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        visits.add(visit2);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> allVisits = service.findAll();

        assertThat(allVisits.size()).isEqualTo(2);
        verify(visitRepository).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(visitRepository.findById(any(Long.class))).thenReturn(Optional.of(visit));

        Visit byId = service.findById(1L);

        assertThat(byId).isNotNull();
        verify(visitRepository).findById(1L);
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(new Visit());

        assertThat(savedVisit).isNotNull();

        verify(visitRepository).save(any(Visit.class));
    }

    @Test
    void delete() {
        Visit visit = new Visit();

        service.delete(visit);

        verify(visitRepository).delete(visit);

    }

    @Test
    void deleteById() {

        service.deleteById(1L);

        verify(visitRepository).deleteById(any(Long.class));
        verify(visitRepository).deleteById(anyLong());
    }
}