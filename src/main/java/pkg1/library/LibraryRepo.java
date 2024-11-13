package pkg1.library;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<LibraryEntity,Integer>{

}
