package pkg1.pincode;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PincodeRepo extends JpaRepository<PincodeEntity, Integer>{
	@Query(value="select * from pincode1 where pincode=:pin",nativeQuery = true)
	public Optional<PincodeEntity> findPincodeByPincode(@Param(value = "pin") int pin1);
}
