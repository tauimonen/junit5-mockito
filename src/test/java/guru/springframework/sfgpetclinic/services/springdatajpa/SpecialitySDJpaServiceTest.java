package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    void deleteById() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        verify(specialtyRepository, times(2)).deleteById(1l);
    }

    @Test
    void deleteByIdAtLeast() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
    }

    @Test
    void deleteByIdAtMost() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        verify(specialtyRepository, atMost(5)).deleteById(1l);
    }

    @Test
    void deleteByIdNever() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
        verify(specialtyRepository, never()).deleteById(5l);
    }

    @Test
    void testDelete() {
        specialitySDJpaService.delete(new Speciality());
    }
}