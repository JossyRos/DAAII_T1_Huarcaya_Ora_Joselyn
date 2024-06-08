package pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.DAAII_T1_Huarcaya_Ora_Joselyn.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nomrol);
}
